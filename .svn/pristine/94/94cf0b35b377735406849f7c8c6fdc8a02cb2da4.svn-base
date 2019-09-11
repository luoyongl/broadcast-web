package cn.wtu.broadcast.openapi.thread;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.BroadcastTempService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.api.TSStreamPackagedService;
import cn.wtu.broadcast.openapi.model.BBroadcastTemp;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.BroadcastTypeKeyEnum;
import cn.wtu.broadcast.parent.utils.FfmpegUtil;
import cn.wtu.broadcast.parent.vo.EBITParamsVO;

public class SendTSThread implements Runnable {

	public Logger logger = LoggerFactory.getLogger(SendTSThread.class);

	/**
	 * 音频线程结束标志，用来停止发送21包的线程
	 * （key值为广播ID + broadcastType，value值为发送音频的线程是否结束）
	 */
	public static ConcurrentHashMap<String, Boolean> endFlagMap = new ConcurrentHashMap<String, Boolean>();

	/**
	 * PID是否有用空闲的，用来启动待播放的广播
	 * （key值为广播ID + broadcastType，value值为基本PID）
	 */
	public static ConcurrentHashMap<String, String> hasPidMap = new ConcurrentHashMap<String, String>();

	/**
	 * 1:开启发送21包TS流的线程 2：开启发送音频的线程
	 */
	private int type;

	/**
	 * 21包的类型(DVBC, DTMB) 用来当作key值的一部分
	 * 传的值是BroadcastTypeKeyEnum枚举类的desc值
	 */
	private String broadcastType;

	/**
	 * 2：开启发送音频的线程 传输 音频数据
	 *
	 * @author lxg
	 * @since 2019-01-25
	 */
	private EBITParamsVO paramsEBITVO;

	/**
	 * 查询所有没有用到的基本PID
	 */
	private TDictionaryService tDictionaryService;

	/**
	 * 用于封装发送的21包以及音频流数据
	 */
	private TSStreamPackagedService tsStreamPackagedService;

	/**
	 * 用于修改广播状态
	 */
	private BBroadcastDataService broadcastService;
	
	/**
	 * 用于暂时存放  待播发队列的记录
	 */
	private BroadcastTempService broadcastTempService;
	
	/**
	 * 存放广播对应的21包发送是否异常，如果异常的话不要发送音频操作
	 * （key值为广播ID + broadcastType）
	 * 默认值为NULL，只有当有异常的时候对应map才有值
	 */
	private static ConcurrentHashMap<String, Boolean> is21ExceptionMap = new ConcurrentHashMap<String, Boolean>();

	public SendTSThread(int type, String broadcastType, EBITParamsVO paramsEBITVO, TSStreamPackagedService tsStreamPackagedService,
						TDictionaryService tDictionaryService, BBroadcastDataService broadcastService,BroadcastTempService broadcastTempService) {
		this.type = type;
		this.broadcastType = broadcastType;
		this.paramsEBITVO = paramsEBITVO;
		this.tsStreamPackagedService = tsStreamPackagedService;
		this.tDictionaryService = tDictionaryService;
		this.broadcastService = broadcastService;
		this.broadcastTempService = broadcastTempService;
	};

	@Override
	public synchronized void run() {
		Integer broadcastId = paramsEBITVO.getfId();
		// 发送21包
		if (type == 1) {
			// 开启线程循环获取空闲的基本PID，只有获取到了空闲基本PID后才继续后面操作
			freePidControl(broadcastId,paramsEBITVO.getfState());

			// DVB-C调制方式
			byte[] dataDVBC = null;
			byte[] dataDTMB = null;
			if (broadcastType.equals(BroadcastTypeKeyEnum.DVBC.getDesc())) {
				// 索引表
				try {
					dataDVBC = tsStreamPackagedService.getEBITTsData(paramsEBITVO, broadcastType);	
				} catch (Exception e) {
					logger.error("DVBC索引表数据封装异常：" + e.getMessage() + e);
					is21ExceptionMap.put(broadcastId + broadcastType, true);
					return;
				}
			}
			// DTMB调制方式
			if (broadcastType.equals(BroadcastTypeKeyEnum.DTMB.getDesc())) {
				// 索引表
				try {
					dataDTMB = tsStreamPackagedService.getEBITTsData(paramsEBITVO, broadcastType);
				} catch (Exception e) {
					logger.error("DTMB索引表数据封装异常：" + e.getMessage() + e);
					is21ExceptionMap.put(broadcastId + broadcastType, true);
					return;
				}
			}

			// 配置表
			byte[] configureData = null;
			try {
				configureData = tsStreamPackagedService.getEBCONTTsData(paramsEBITVO);
			} catch (Exception e) {
				logger.error("配置表数据封装异常：" + e.getMessage() + e);
				is21ExceptionMap.put(broadcastId + broadcastType, true);
				return;
			}
			
			// 封装的数据为空的时候异常结束
			if(dataDVBC == null && dataDTMB == null && configureData == null){
				logger.error("广播{}的21包发送异常结束", broadcastId + broadcastType);
				is21ExceptionMap.put(broadcastId + broadcastType, true);
				return;
			}

			// 初始化结束标志
			endFlagMap.put(broadcastId + broadcastType, false);
			while (endFlagMap.containsKey(broadcastId + broadcastType) && !endFlagMap.get(broadcastId + broadcastType)) {
				try {
					if(broadcastType.equals(BroadcastTypeKeyEnum.DVBC.getDesc())){
						// 发送21包-索引表内容
						UDPUtil.udpSend(dataDVBC, dataDVBC.length, paramsEBITVO.getDvbcAdapterIp(),
								Integer.parseInt(paramsEBITVO.getDvbcAdapterPort()));
						// 发送21包-配置表内容
						if(configureData != null){
							UDPUtil.udpSend(configureData, configureData.length, paramsEBITVO.getDvbcAdapterIp(),
									Integer.parseInt(paramsEBITVO.getDvbcAdapterPort()));
						}
					} else if(broadcastType.equals(BroadcastTypeKeyEnum.DTMB.getDesc())){
						// 发送21包-索引表内容
						UDPUtil.udpSend(dataDTMB, dataDTMB.length, paramsEBITVO.getDtmbAdapterIp(),
								Integer.parseInt(paramsEBITVO.getDtmbAdapterPort()));
						// 发送21包-配置表内容
						UDPUtil.udpSend(configureData, configureData.length, paramsEBITVO.getDtmbAdapterIp(),
								Integer.parseInt(paramsEBITVO.getDtmbAdapterPort()));
					}
					Thread.sleep(100);
				} catch (Exception e) {
					logger.error(e.getMessage() + e);
					endFlagMap.remove(broadcastId + broadcastType);
					is21ExceptionMap.put(broadcastId + broadcastType, true);
					return;
				}
			}
			// 21包结束发送后清空结束标志，释放内存
			endFlagMap.remove(broadcastId + broadcastType);
			logger.info("广播{}的21包发送正常结束", broadcastId + broadcastType);
			// 发送TS停播指令
			stopBroadcast(paramsEBITVO);
		} else if (type == 2) {
			try {
				// hasPidMap为发送21包的线程里面添加PID，只有当hasPidMap里面对应广播ID包含了PID的时候就开启发送音频的进程
				while (!hasPidMap.containsKey(broadcastId + broadcastType) 
						|| (hasPidMap.get(broadcastId + broadcastType) == null || "".equals(hasPidMap.get(broadcastId + broadcastType)))) {
					Thread.sleep(10);
				}
				Boolean is21Exception = is21ExceptionMap.get(broadcastId + broadcastType);
				if(is21Exception != null && is21Exception){
					logger.error("由于21包发送异常，音频发送线程异常结束");
					// 音频异常结束后释放基本PID
					Constant.usedPidList.remove(hasPidMap.get(broadcastId + broadcastType));
					hasPidMap.remove(broadcastId + broadcastType);
					return;
				}
				
				// 添加广播状态的修改（修改为正在播放状态）
				broadcastService.setStateByTypeAndFid(paramsEBITVO.getfState(), paramsEBITVO.getfId(),
						BroadcastStateEnum.broadcasting.getCode());

				// 发送音频业务内容
				paramsEBITVO.setElementary_PID(Short.valueOf(hasPidMap.get(broadcastId + broadcastType)));
				logger.info("广播{}的音频获取的基本PID为：{}", broadcastId + broadcastType, Short.valueOf(hasPidMap.get(broadcastId + broadcastType)));
				try {
					FfmpegUtil.Mp32TS(paramsEBITVO, broadcastType);
				} catch (Exception e) {
					logger.error("TS指令音频发送发送异常：" + e.getMessage() + e);
				}
				// 加入音频发送结束标志到集合中，用于21包结束的标志
				endFlagMap.put(broadcastId + broadcastType, true);
				// 移除发送音频的进程集合（在启动音频发送的时候会加入集合，目的是用户停播操作）
				Constant.tsAudioProcessMap.remove(String.valueOf(broadcastId));
				// 发送音频结束后释放基本PID
				Constant.usedPidList.remove(hasPidMap.get(broadcastId + broadcastType));
				hasPidMap.remove(broadcastId + broadcastType);
				// 添加广播状态的修改（修改为播放完成状态）
				broadcastService.setStateByTypeAndFid(paramsEBITVO.getfState(), paramsEBITVO.getfId(),
						BroadcastStateEnum.broadcasted.getCode());
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
		}
	}
	
	/**
	 * 发送TS停播指令
	 */
	private void stopBroadcast(EBITParamsVO paramsEBITVO) {
		try {
			byte[] data = tsStreamPackagedService.getStopBroadcastData(paramsEBITVO);
			UDPUtil.udpSend(data, data.length, paramsEBITVO.getDtmbAdapterIp(),
						Integer.parseInt(paramsEBITVO.getDtmbAdapterPort()));
			logger.info("TS停播指令正常发送成功");
		} catch (Exception e) {
			logger.error("TS发送停播指令报错：" + e.getMessage() + e);
		}
	}

	/**
	 * 开启线程循环获取空闲的基本PID，只有获取到了空闲基本PID后才继续后面操作
	 *
	 * @param broadcastId
	 */
	private void freePidControl(Integer broadcastId,Integer fstate) {
		//加入到b_broadcast_temp表 f_broadcast_id f_timing_broadcast
		BBroadcastTemp  broadcastTemp = new BBroadcastTemp();
		broadcastTemp.setfBroadcastId(broadcastId);
		broadcastTemp.setfTimingBroadcast(fstate == BroadcastTypeEnum.timing.getCode()?true:false);
		broadcastTemp.setfCreateTime(new Date());
		broadcastTempService.addBroadcastTemp(broadcastTemp);
		// 获取数据表中的空闲基本PID
		String pid = null;
		while (pid == null) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("usedPidList", StringUtils.join(Constant.usedPidList, ","));
			List<TDictionary> unUsedPid = tDictionaryService.selectPidList(param);
			if (unUsedPid != null && unUsedPid.size() > 0) {
				// 结束循环标志
				pid = unUsedPid.get(0).getfDictionaryContent();
				// 添加到已使用的列表中，便于下次查询的时候筛选掉
				Constant.usedPidList.add(pid);
				hasPidMap.put(broadcastId + broadcastType, pid);
				// 设置基本PID
				paramsEBITVO.setElementary_PID(Short.valueOf(pid));
				logger.info("广播{}的广播获取到的基本PID为：{}" , broadcastId + broadcastType, pid);
			} else {
				try {
					// 等待其他线程PID的释放
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					logger.error(e.getMessage() + e);
				}
			}
		}
		//从b_broadcast_temp中删除这条记录
		broadcastTempService.deleteBroadcastTemp(broadcastId);
	}
}
