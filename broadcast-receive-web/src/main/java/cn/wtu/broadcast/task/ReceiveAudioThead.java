package cn.wtu.broadcast.task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BDeviceReturnAudioService;
import cn.wtu.broadcast.openapi.model.BDeviceReturnAudio;

public class ReceiveAudioThead implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(ReceiveAudioThead.class);

	/**
	 * 缓存设备的音频流处理 key值为设备资源编码例如061245140210220302 value为是否结束音频采集
	 */
	public static Map<String, Boolean> receiveAudioEndMap = new HashMap<String, Boolean>();

	private BDeviceReturnAudioService bDeviceReturnAudioService;

	private String deviceSourceCode;

	private DatagramSocket datagramSocket;

	private Integer fDeviceId;

	private Integer fBroadcastId;

	public ReceiveAudioThead(String deviceSourceCode, Integer fDeviceId, Integer fBroadcastId,
			BDeviceReturnAudioService bDeviceReturnAudioService, DatagramSocket datagramSocket) {
		this.deviceSourceCode = deviceSourceCode;
		this.fDeviceId = fDeviceId;
		this.fBroadcastId = fBroadcastId;
		this.bDeviceReturnAudioService = bDeviceReturnAudioService;
		this.datagramSocket = datagramSocket;
	};

	@Override
	public synchronized void run() {
		try {
			// 音频数据的回填处理
			BDeviceReturnAudio bDeviceReturnAudio = new BDeviceReturnAudio();
			bDeviceReturnAudio.setfDeviceId(fDeviceId);
			bDeviceReturnAudio.setfBroadcastId(fBroadcastId);
			bDeviceReturnAudio.setfCreateTime(new Date());
			byte[] radioByte = null; 
			Long audioLength = Long.valueOf(0);
			// 只有当音频结束指令发送或者文件大于10M的时候开始停止当前线程
			try {
				while (receiveAudioEndMap.containsKey(deviceSourceCode) && !receiveAudioEndMap.get(deviceSourceCode)
						&& audioLength.compareTo(Long.valueOf(10 * 1024 * 1024)) < 0) {
					// 创建字节数据
					byte[] data = new byte[10 * 1024];
					// 创建数据包对象，传递字节数组
					DatagramPacket dp = new DatagramPacket(data, data.length);
					datagramSocket.setSoTimeout(10000);
					// 调用datagramSocket对象的方法receive传递数据包
					datagramSocket.receive(dp);
					if(radioByte == null){
						radioByte = subByte(dp.getData(), 0, 0, dp.getLength());
					} else {
						radioByte = byteMerger(radioByte, subByte(dp.getData(), 0, 0, dp.getLength()));
					}
					audioLength = Long.sum(audioLength, Long.valueOf(dp.getLength()));
				}
			} catch (Exception e) {
				logger.info("超时回传音频，正常结束");
			}
			
			logger.info("=======音频回传采集结束，采集音频长度为{}=======", audioLength);
			// 音频数据的回填处理
			bDeviceReturnAudio.setfIsTimingBroadcast(false);
			bDeviceReturnAudio.setfEndTime(new Date());
			bDeviceReturnAudio.setfAudioByte(radioByte);
			// 只有有音频数据的时候才回填到数据库
			if(audioLength.compareTo(Long.valueOf(0)) > 0){
				bDeviceReturnAudioService.insertReturnAudio(bDeviceReturnAudio);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}
	
	/**
	 * 合并两个byte数组
	 * @param bt1
	 * @param bt2
	 * @return
	 */
	private static byte[] byteMerger(byte[] bt1, byte[] bt2) {
		byte[] bt3 = new byte[bt1.length + bt2.length];
		System.arraycopy(bt1, 0, bt3, 0, bt1.length);
		System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
		return bt3;
	}
	
	/**
	 * 截取byte数组   不改变原数组
	 * @param src byte源数组
	 * @param srcPos 截取源byte数组起始位置（0位置有效）
	 * @param destPos 截取后存放的数组起始位置（0位置有效）
	 * @param length 截取的数据长度
	 * @return
	 */
	private byte[] subByte(byte[] src, int srcPos, int destPos, int length) {
		byte[] dest = new byte[length];
		System.arraycopy(src, srcPos, dest, destPos, length);
		return dest;
	}
}
