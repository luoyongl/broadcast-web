package cn.wtu.broadcast.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.AudioPlayService;
import cn.wtu.broadcast.openapi.thread.SendTSThread;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BroadcastTypeKeyEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.IpVO;

@Controller
@RequestMapping("/dispatch")
public class BroadcastDispatchController {

	private Logger logger = LoggerFactory.getLogger(BroadcastDispatchController.class);

	@Autowired
	private AudioPlayService audioPlayService;

	/**
	 * 平台心跳测试，检查本平台是否正常启动了
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/heart", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult heart(HttpServletRequest request, HttpServletResponse response) {
		return BroadcastResult.ok();
	}

	/**
	 * 开启图文相关发送指令的操作
	 * 
	 * @param ipVO
	 * @return
	 */
	@RequestMapping(value = "/sendIpPictureVideo")
	@ResponseBody
	public BroadcastResult sendIpPictureVideo(String playType, String name, String contentOrUrl, String resourceCodes,
			String broadcastTomcatPath, String pictureId) {
		BroadcastResult broadcastResult = new BroadcastResult();
		try {
			broadcastResult = audioPlayService.ipPictureVideoPlay(Integer.parseInt(playType), name, contentOrUrl,
					resourceCodes, broadcastTomcatPath, pictureId);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail();
		}

		return broadcastResult;
	}

	/**
	 * 开启发送指令的操作
	 * 
	 * @param broadcastTo
	 *            所选播发区域
	 * @param broadcastType
	 *            广播类型
	 * @param broadcastId
	 *            广播ID
	 * @param broadcastTomcatPath
	 *            平台服务器Tomcat绝对路径，用于IP播发时的本地音频
	 * @return
	 */
	@RequestMapping(value = "/sendBroadcast")
	@ResponseBody
	public BroadcastResult sendBroadcast(String broadcastTo, Integer broadcastType, Integer broadcastId,
			String broadcastTomcatPath) {
		BroadcastResult broadcastResult = new BroadcastResult();
		try {
			String[] broadcastToArr = broadcastTo.split(",");
			if (broadcastToArr != null && broadcastToArr.length > 0) {
				for (String i : broadcastToArr) {
					// 23表示大喇叭发送IP
					if ("23".equals(i)) {
						broadcastResult = audioPlayService.ipPlayAudio(broadcastType, broadcastId, broadcastTomcatPath);
					}
					// 25表示广播电视发送ts
					if ("25".equals(i)) {
						broadcastResult = audioPlayService.playAudio(broadcastType, broadcastId);
					}
				}
			} else {
				return BroadcastResult.fail();
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail();
		}

		return broadcastResult;
	}

	/**
	 * 停播
	 * 
	 * @param broadcastTo
	 *            所选播发区域
	 * @param broadcastId
	 *            广播ID
	 * @return
	 */
	@RequestMapping(value = "/stopBroadcast")
	@ResponseBody
	public BroadcastResult stopBroadcast(String broadcastTo, Integer broadcastId) {
		try {
			String[] strings = broadcastTo.split(",");
			if (strings != null && strings.length > 0) {
				List<String> list = Arrays.asList(strings);
				// IP指令模式停播
				if (list.contains("23")) {
					List<Process> ipProcessList = Constant.tsAudioProcessMap.get("IP" + String.valueOf(broadcastId));
					if (ipProcessList != null) {
						// 关闭音频进程处理
						for (Process process : ipProcessList) {
							process.destroy();
						}
						Constant.tsAudioProcessMap.remove(ipProcessList);
						IpVO ipVO = SendIPUtils.sendIpVOMap.get(broadcastId.toString());
						ipStopBroadcast(ipVO);
						SendIPUtils.sendIpVOMap.remove(broadcastId.toString());						
					} else {
						return BroadcastResult.build(400, "该广播非正在播发状态，停播失败");
					}
				}

				if (list.contains("1")) {
					IpVO ipVO = SendIPUtils.sendIpVOMap.get(broadcastId.toString());
					ipStopBroadcast(ipVO);
					SendIPUtils.sendIpVOMap.remove(broadcastId.toString());
				}

				// TS指令模式停播
				if (list.contains("25")) {
					List<Process> processList = Constant.tsAudioProcessMap.get(String.valueOf(broadcastId));
					if (processList != null) {
						for (Process process : processList) {
							process.destroy();
						}
						Constant.tsAudioProcessMap.remove(processList);
						SendTSThread.endFlagMap.put(broadcastId + BroadcastTypeKeyEnum.DVBC.getDesc(), true);
						SendTSThread.endFlagMap.put(broadcastId + BroadcastTypeKeyEnum.DTMB.getDesc(), true);
					} else {
						return BroadcastResult.build(400, "该广播非正在播发状态，停播失败");
					}
				}

				return BroadcastResult.build(200, "停播成功");
			} else {
				return BroadcastResult.fail();
			}

		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return BroadcastResult.fail();
		}
	}
	
	/**
	 * 停播处理
	 * @param ipVO
	 */
	private void ipStopBroadcast(IpVO ipVO){
		// 停播
		if(SendIPUtils.ctxMap.size() > 0){
			for (String resourceCode : SendIPUtils.ctxMap.keySet()) {
				if (SendIPUtils.isCanSend(resourceCode, ipVO.getResourceCodeList())) {
					SendIPUtils.stopIPControl(SendIPUtils.ctxMap.get(resourceCode).channel(),
							SendIPUtils.answerMap.get(resourceCode), ipVO);
				}
			}
		}
	}
}