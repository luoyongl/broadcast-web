package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDeviceMapper;
import cn.wtu.broadcast.openapi.dao.BDeviceInfoMapper;
import cn.wtu.broadcast.openapi.dao.extend.BDeviceInfoExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.model.BBroadcastDeviceExample;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.model.BDeviceInfoExample;
import cn.wtu.broadcast.openapi.vo.BDeviceInfoVo;
import cn.wtu.broadcast.openapi.vo.ExceptionDeviceExportVO;
import cn.wtu.broadcast.openapi.vo.ReceiveStateVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.DeviceTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bDeviceInfoService")
public class BDeviceInfoServiceImpl extends ParentServiceImpl<BDeviceInfo> implements BDeviceInfoService {


	private static Logger logger = LoggerFactory.getLogger(BBroadcastDataServiceImpl.class);

	@Autowired
	private BDeviceInfoExtMapper bDeviceInfoExtMapper;

	@Autowired
	private BDeviceInfoMapper bDeviceInfoMapper;
	
	@Autowired
	private BBroadcastDeviceMapper bBroadcastDeviceMapper;

	/**
	 * @param paramMap
	 * @return
	 * @description 查询所有异常设备信息
	 * @author LiLinFeng
	 * @date 2019-01-15
	 */
	@Override
	public PageInfo<BDeviceInfoVo> selectExceptionDeviceInfos(Map<String, Object> paramMap) {

		PageInfo<BDeviceInfoVo> list = null;
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
			List<BDeviceInfoVo> list1 = bDeviceInfoExtMapper.selectExceptionDeviceInfos(paramMap);
			if (list1 != null) {
				list = new PageInfo<>(list1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return list;
	}

	@Override
	public List<ExceptionDeviceExportVO> queryExceptionDeviceInfos() {

		List<ExceptionDeviceExportVO> list = null;
		try {
			list = bDeviceInfoExtMapper.queryExceptionDeviceInfos();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public Boolean updateThirdDeviceInfo(ReceiveStateVO receiveStateVO) {
		BDeviceInfo deviceInfo = null;
		BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
		BDeviceInfoExample.Criteria criteria = bDeviceInfoExample.createCriteria();
		String fDeviceResorceCode = receiveStateVO.getReceiveProperties().getDeviceSourceCode();
		criteria.andFDeviceResourceCodeEqualTo(fDeviceResorceCode).andFDeleteFlagEqualTo(false);
		List<BDeviceInfo> list = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);
		if(list != null && list.size() > 0){
			deviceInfo = list.get(0);
		}
		if (deviceInfo != null) {
			try {
				deviceInfo.setfBackTime(receiveStateVO.getTime());
				deviceInfo.setfPhysicalCode(receiveStateVO.getPhysicalNumber());
				deviceInfo.setfLogicCode(receiveStateVO.getLogicNumber());
				deviceInfo.setfBackMode(receiveStateVO.getReceiveMode());
				deviceInfo.setfNetworkMode(receiveStateVO.getNetMode());
				deviceInfo.setfHardwareVersion(receiveStateVO.getHardVersion());
				deviceInfo.setfSoftwareVersion(receiveStateVO.getSoftVersion());
				deviceInfo.setfVoltage(receiveStateVO.getWorkVoltage());
				deviceInfo.setfPowerCurrent(receiveStateVO.getCurrent());
				deviceInfo.setfBroadcastState(receiveStateVO.getBroadcastState());
				deviceInfo.setfDeviceVolume(receiveStateVO.getDeviceVolume());
				deviceInfo.setfDigitalTelevisionRadioMode(receiveStateVO.getDigitalTelevisionRadioMode());
				deviceInfo.setfDigitalTelevisionRadioRate(receiveStateVO.getDigitalTelevisionRadioRate());
				deviceInfo.setfQma(receiveStateVO.getQAM());
				deviceInfo.setfDigitalTelevisionSignalQuality(receiveStateVO.getDigitalTelevisionSignalQuality());
				deviceInfo.setfDigitalTelevisionSignalStrength(receiveStateVO.getDigitalTelevisionSignalStrength());
				if(receiveStateVO.getSignalRateList() != null && receiveStateVO.getSignalRateList().size() > 0){
					String signalRateList = Joiner.on(",").join(receiveStateVO.getSignalRateList());
					deviceInfo.setfSignalRateList(signalRateList);
				}
				if(receiveStateVO.getSignalStrengthList() != null && receiveStateVO.getSignalStrengthList().size() > 0){
					String signalStrengthList = Joiner.on(",").join(receiveStateVO.getSignalStrengthList());
					deviceInfo.setfSignalStrengthList(signalStrengthList);
				}
				if(receiveStateVO.getLongitude() != null && Float.valueOf(receiveStateVO.getLongitude()).compareTo(Float.valueOf(0)) > 0){
					deviceInfo.setfLongitude(receiveStateVO.getLongitude());
				}
				if(receiveStateVO.getLatitude() != null && Float.valueOf(receiveStateVO.getLatitude()).compareTo(Float.valueOf(0)) > 0){
					deviceInfo.setfDimension(receiveStateVO.getLatitude());
				}				
				if(receiveStateVO.getDeviceState() != null){
					deviceInfo.setfDeviceState(receiveStateVO.getDeviceState());
				}
				BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
				BDeviceInfoExample.Criteria criteria1 = bDeviceInfoExample1.createCriteria();
				criteria1.andFDeviceResourceCodeEqualTo(fDeviceResorceCode).andFDeleteFlagEqualTo(false);
				int flag = 0;
				flag = bDeviceInfoMapper.updateByExample(deviceInfo, bDeviceInfoExample1);
				if (flag > 0) {
					return true;
				}
			} catch (Exception e) {
				logger.error("数据更新失败");
			}
		}
		return false;
	}

	@Override
	public Integer selectState(Integer flag) {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFDeviceStateEqualTo((byte)flag.intValue()).andFDeleteFlagEqualTo(false)
		.andFDeviceTypeBetween((byte)DeviceTypeEnum.frontDevice.getCode(),(byte)DeviceTypeEnum.terminalDevice.getCode());
		List<BDeviceInfo> bDeviceInfo = bDeviceInfoMapper.selectByExample(example);
		return bDeviceInfo.size();
	}


	@Override
	public Integer selectDeviceType(Integer type) {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFDeviceTypeEqualTo((byte)type.intValue());
		return bDeviceInfoMapper.selectByExample(example).size();
	}

	@Override
	protected DBInterface<BDeviceInfo> getDao() {
		return bDeviceInfoMapper;
	}

	@Override
	public Boolean updateDeviceStateBySourceCode(String deviceSourceCode, Byte deviceState) {
		Boolean result = false;
		try {
			BDeviceInfoExample example = new BDeviceInfoExample();
			example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceResourceCodeEqualTo(deviceSourceCode);
			List<BDeviceInfo> bDeviceInfoList = bDeviceInfoMapper.selectByExample(example);
			if (bDeviceInfoList != null) {
				for (BDeviceInfo bDeviceInfo : bDeviceInfoList) {
					try {
						bDeviceInfo.setfDeviceState(deviceState);
						bDeviceInfoMapper.updateByExample(bDeviceInfo, example);
					} catch (Exception e) {
						logger.error(e.getMessage() + e);
					}
				}
			}
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		return result;
	}

	@Override
	public void updateAllDeceiveState() {
		try {
			bDeviceInfoExtMapper.updateAllDeceiveState();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
	}

	/**
	 * 通过设备资源ID查询到对应的广播ID和设备ID, 音频回传用
	 */
	@Override
	public Map<String, Object> getBDeviceInfoForReceive(Map<String, Object> paramMap) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("fDeviceId", 0);
		result.put("fBroadcastId", 0);
		String deviceSourceCode = String.valueOf(paramMap.get("deviceSourceCode"));
		BDeviceInfoExample example = new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFDeviceResourceCodeEqualTo(deviceSourceCode);
		List<BDeviceInfo> bDeviceInfoList = bDeviceInfoMapper.selectByExample(example);
		if (bDeviceInfoList != null) {
			Integer fDeviceId = bDeviceInfoList.get(0).getfId();
			result.put("fDeviceId", fDeviceId);
			// 查询对应的广播ID
			BBroadcastDeviceExample bbde = new BBroadcastDeviceExample();
			bbde.setOrderByClause("f_broadcast_send_time desc");
			bbde.createCriteria().andFDeviceIdEqualTo(fDeviceId);
			List<BBroadcastDevice> list = bBroadcastDeviceMapper.selectByExample(bbde);
			if(list != null){
				BBroadcastDevice bBroadcastDevice = list.get(0);
				result.put("fBroadcastId", bBroadcastDevice.getfBroadcastId());
			}
		}
		
		return result;
	}

	@Override
	public List<BDeviceInfo> listAll() {
		BDeviceInfoExample example=new BDeviceInfoExample();
		example.createCriteria().andFDeleteFlagEqualTo(false).andFLocationIsNotNull().andFDeviceResourceCodeIsNotNull().andFDeviceStateEqualTo((byte)1);
		return bDeviceInfoMapper.selectByExample(example);
	}
	
	
	/**
	 * 查询出所有 正在广播和在线的设备(0,1)  
	 * 用于省平台测试时的设备展示  
	 *  2019-04-10  lxg
	 */
	public List<Integer> getAllDevices(){
		return bDeviceInfoExtMapper.getAllDevices();
	}
}