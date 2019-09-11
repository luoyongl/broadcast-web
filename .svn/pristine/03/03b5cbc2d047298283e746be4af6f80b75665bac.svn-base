package cn.wtu.broadcast.openapi.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.utils.FfmpegUtil;
import cn.wtu.broadcast.parent.vo.IpVO;

public class SendIPAudioThread implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(SendIPAudioThread.class);

	/**
	 * 用于修改广播状态
	 */
	private BBroadcastDataService broadcastService;
	
	private IpVO sendIpvo;

	public SendIPAudioThread(IpVO sendIpvo, BBroadcastDataService broadcastService) {
		this.sendIpvo = sendIpvo;
		this.broadcastService = broadcastService;
	}

	@Override
	public synchronized void run() {
		// IP广播时候才更新数据库
		if(sendIpvo.getPlayType() == null && broadcastService != null){
			// 更新广播数据表中的状态为正在播放 同时加入的待播放的数据表中
			broadcastService.setStateByFid(Integer.parseInt(sendIpvo.getfId()),
					BroadcastStateEnum.broadcasting.getCode());
		}
		try {
			if(sendIpvo.getPlayType() == null){
				FfmpegUtil.play(sendIpvo);
			} else if(sendIpvo.getPlayType() == 2){
				// 图文播放视频
				FfmpegUtil.playVideo(sendIpvo);
			} else if(sendIpvo.getPlayType() == 3){
				// Ip话筒发送
				FfmpegUtil.ipMikeTS(sendIpvo);
			}
		} catch (Exception e) {
			logger.error("IP指令音频发送发送异常：" + e.getMessage() + e);
		}
		if(sendIpvo.getPlayType() == null && broadcastService != null){
			// 更新广播数据表中的状态为播放结束 同时删除待播放列表中的相关数据
			broadcastService.setStateByFid(Integer.parseInt(sendIpvo.getfId()),
					BroadcastStateEnum.broadcasted.getCode());
			logger.info("广播{}正常播放完成, 状态更新为{}", sendIpvo.getfId(), BroadcastStateEnum.broadcasted.getCode());
		}
	}
}
