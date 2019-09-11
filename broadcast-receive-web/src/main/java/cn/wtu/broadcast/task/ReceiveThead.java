package cn.wtu.broadcast.task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.BDeviceReturnAudioService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.vo.ReceiveStateVO;

public class ReceiveThead extends Observable implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(ReceiveThead.class);

	private BDeviceInfoService bdeviceInfoService;

	private SystemConfigurationService systemConfigurationService;
	
	private BDeviceReturnAudioService bDeviceReturnAudioService;

	private DatagramSocket datagramSocket;
	
	private DatagramSocket audioDatagramSocket;
	
	private BBroadcastDeviceService bBroadcastDeviceService;

	/**
	 * 缓存上次的设备信息，如果设备信息有变化才更新数据，否则不更新数据库 
	 * key值为设备资源编码例如061245140210220302
	 */
	public static Map<String, ReceiveStateVO> receiveCacheMap = new HashMap<String, ReceiveStateVO>();
	
	/**
	 * 缓存设备的上次的连入时间，用来判断是否超时，超时后更新为离线
	 * key值为设备资源编码例如061245140210220302，value值为时间
	 */
	public static Map<String, Date> receiveDateTimeMap = new HashMap<String, Date>();

	public ReceiveThead(BDeviceInfoService bdeviceInfoService, SystemConfigurationService systemConfigurationService, 
			BDeviceReturnAudioService bDeviceReturnAudioService, BBroadcastDeviceService bBroadcastDeviceService) {
		this.bdeviceInfoService = bdeviceInfoService;
		this.systemConfigurationService = systemConfigurationService;
		this.bDeviceReturnAudioService = bDeviceReturnAudioService;
		this.bBroadcastDeviceService = bBroadcastDeviceService;
	};

	@Override
	public synchronized void run() {
		try {
			// 系统配置表获取端口号
			TSystemConfiguration tsystemConfiguration = systemConfigurationService.selectDataByCName("return_server_port");
			Integer returnServerPort = Integer.valueOf(tsystemConfiguration.getfConfigurationValue());
			datagramSocket = new DatagramSocket(returnServerPort);
			logger.info("指令回传服务器启动监听端口：{}" , returnServerPort);
			TSystemConfiguration audio = systemConfigurationService.selectDataByCName("audio_server_port");
			Integer audioServerPort = Integer.valueOf(audio.getfConfigurationValue());
			audioDatagramSocket = new DatagramSocket(audioServerPort);
			logger.info("音频回传服务器启动监听端口：{}" , audioServerPort);
			while (true) {
				// 创建字节数据
				byte[] data = new byte[4096];
				// 创建数据包对象，传递字节数组
				DatagramPacket packet = new DatagramPacket(data, data.length);
				// 调用datagramSocket对象的方法receive传递数据包
				datagramSocket.receive(packet);
				// 开启数据处理子线程
				ReceiveAnswerThead receiveAnswerThead = new ReceiveAnswerThead(datagramSocket, packet, audioDatagramSocket,
						bdeviceInfoService, bDeviceReturnAudioService, bBroadcastDeviceService);
				new Thread(receiveAnswerThead).start();
			}
		} catch (Exception e) {
			logger.error("回传处理发生未知异常：" + e.getMessage() + e);
			if (datagramSocket != null && !datagramSocket.isClosed()) {
				datagramSocket.close();
			}
			doBusiness();
		}
	}
	
	/**
	 * 此方法一经调用，立马可以通知观察者，在本例中是监听线程
	 */
	private void doBusiness() {
		if (true) {
			super.setChanged();
		}
		notifyObservers();
	}
}
