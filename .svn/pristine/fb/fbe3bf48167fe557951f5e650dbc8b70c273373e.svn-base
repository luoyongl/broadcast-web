package cn.wtu.broadcast.task;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.BDeviceReturnAudioService;
import cn.wtu.broadcast.openapi.vo.ReceiveProperties;
import cn.wtu.broadcast.openapi.vo.ReceiveStateVO;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import cn.wtu.broadcast.parent.utils.CRCUtil;
import cn.wtu.broadcast.parent.vo.WriteDeviceVO;

public class ReceiveAnswerThead extends Observable implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(ReceiveAnswerThead.class);

	private BDeviceInfoService bdeviceInfoService;
	
	private BDeviceReturnAudioService bDeviceReturnAudioService;
	
	private BBroadcastDeviceService bBroadcastDeviceService;

	private DatagramSocket datagramSocket;
	
	private DatagramPacket packet;
	
	private DatagramSocket audioDatagramSocket;
	/**
	 * 缓存设备的上次的连入时间，用来判断是否超时，超时后更新为离线
	 * key值为设备资源编码例如061245140210220302，value值为时间
	 */
	public static Map<String, Date> receiveDateTimeMap = new HashMap<String, Date>();

	public ReceiveAnswerThead(DatagramSocket datagramSocket, DatagramPacket packet, DatagramSocket audioDatagramSocket,
			BDeviceInfoService bdeviceInfoService, BDeviceReturnAudioService bDeviceReturnAudioService,
			BBroadcastDeviceService bBroadcastDeviceService) {
		this.datagramSocket = datagramSocket;
		this.packet = packet;
		this.audioDatagramSocket = audioDatagramSocket;
		this.bdeviceInfoService = bdeviceInfoService;
		this.bDeviceReturnAudioService = bDeviceReturnAudioService;
		this.bBroadcastDeviceService = bBroadcastDeviceService;
	};

	@Override
	public synchronized void run() {
		try {
			String hexData = CRCUtil.byteToHex(packet.getData(), packet.getLength());
			// 响应包头标记
			String head = hexData.substring(0, 2);
			if(!"25".equals(head)){
				// 回传服务器当前状态的检查
				if("8888".equals(hexData.substring(0, 4))){
					receiveHeartAnswer(datagramSocket, packet, hexData.substring(0, 4));
				}
				return;
			}
			logger.info("Receive from client :" + hexData);
			ReceiveStateVO receiveStateVO = new ReceiveStateVO(hexData);
			// 缓存设备的上次的连入时间，用来判断是否超时，超时后更新为离线
			if (receiveStateVO != null) {
				receiveDateTimeMap.put(receiveStateVO.getReceiveProperties().getDeviceSourceCode(), new Date());
			}
			// 设备资源信息更新
			if (receiveStateVO != null && isUpdateDeviceData(hexData)) {
				Boolean updateResult = bdeviceInfoService.updateThirdDeviceInfo(receiveStateVO);
				logger.info("设备资源码{} 更新结果为{}", receiveStateVO.getReceiveProperties().getDeviceSourceCode(),
						updateResult);
			}
			if (receiveStateVO != null) {
				try {
					ReceiveProperties receiveProperties = receiveStateVO.getReceiveProperties();
					// 设备在线的时候将改设备的基础信息放到缓存中
					WriteDeviceVO writeDeviceVO = new WriteDeviceVO(receiveProperties.getDeviceSourceCode(), receiveProperties.getProtocolVersion());
					Constant.writeDeviceDataMap.put(receiveProperties.getDeviceSourceCode(), writeDeviceVO);
					// 判断是否有该设备的设置指令存在，有的话执行设置指令操作
					writeDevice(receiveProperties.getDeviceSourceCode(), packet);
					// 开启或者关闭音频触发指令
					boolean result = sendOrStopAudioReceive(receiveProperties.getDeviceSourceCode(), receiveStateVO.getDeviceState(), packet);
					if(!result){
						// 没有发送触发音频指令的时候应答所有的指令
						receiveAnswer(datagramSocket, packet, hexData);
					}
				} catch (Exception e) {
					logger.error("音频回传处理发生未知异常：" + e.getMessage() + e);
				}
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
	 * 开启或者关闭音频触发指令
	 * @param deviceSourceCode
	 * @param deviceState
	 * @param dp
	 * @return
	 */
	private boolean sendOrStopAudioReceive(String deviceSourceCode, Byte deviceState, DatagramPacket packet) {
		boolean result = false;
		WriteDeviceVO writeDeviceVO = Constant.writeDeviceDataMap.get(deviceSourceCode);
		// 广播状态为正在播放时候，开启音频获取, 且只需要第一次心跳时候开启
		if (writeDeviceVO != null && deviceState != null
				&& Byte.valueOf(String.valueOf(DeviceStateEnum.broadcasting.getCode())).compareTo(deviceState) == 0
				&& !ReceiveAudioThead.receiveAudioEndMap.containsKey(deviceSourceCode)) {
			logger.info("======发送开启实时音频处理开始======");
			// 发送开启实时音频处理
			writeDeviceVO.setAudioProtocol(1);
			writeDeviceVO.setAudioSwitch(true);
			writeDeviceVO.setHasWriteControl(true);
			Constant.writeDeviceDataMap.put(deviceSourceCode, writeDeviceVO);
			writeDevice(deviceSourceCode, packet);
			// 开启线程写入该设备的音频流
			ReceiveAudioThead.receiveAudioEndMap.put(deviceSourceCode, false);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("deviceSourceCode", deviceSourceCode);
			Map<String, Object> map = bdeviceInfoService.getBDeviceInfoForReceive(paramMap);
			Integer fDeviceId = Integer.valueOf(String.valueOf(map.get("fDeviceId")));
			Integer fBroadcastId = Integer.valueOf(String.valueOf(map.get("fBroadcastId")));
			ReceiveAudioThead receiveAudioThead = new ReceiveAudioThead(deviceSourceCode, fDeviceId, fBroadcastId,
					bDeviceReturnAudioService, audioDatagramSocket);
			new Thread(receiveAudioThead).start();
			// 更新广播设备关系表（记录时效处理）
			bBroadcastDeviceService.updateReceiveInfoToTbl(fDeviceId, fBroadcastId, false);
			result = true;
			logger.info("======发送开启实时音频处理结束======");
		} else if (writeDeviceVO != null && deviceState != null
				&& Byte.valueOf(String.valueOf(DeviceStateEnum.broadcasting.getCode())).compareTo(deviceState) != 0 
				&& ReceiveAudioThead.receiveAudioEndMap.containsKey(deviceSourceCode)
				&& !ReceiveAudioThead.receiveAudioEndMap.get(deviceSourceCode)) {
			logger.info("======发送结束实时音频处理开始======");
			// 发送结束实时音频处理
			writeDeviceVO.setAudioProtocol(1);
			writeDeviceVO.setAudioSwitch(false);
			writeDeviceVO.setHasWriteControl(true);
			Constant.writeDeviceDataMap.put(deviceSourceCode, writeDeviceVO);
			writeDevice(deviceSourceCode, packet);
			// 关闭线程写入该设备的音频流
			ReceiveAudioThead.receiveAudioEndMap.remove(deviceSourceCode);
			result = true;
			logger.info("======发送结束实时音频处理结束======");
		}

		return result;
	} 
	
	/**
	 * 自己检查是否回传服务器正常，用于更新对应的相关表数据
	 */
	private void receiveHeartAnswer(DatagramSocket datagramSocket, DatagramPacket packet, String answer){
		try {
			DatagramPacket sendDP = new DatagramPacket(CRCUtil.hexToByte(answer), CRCUtil.hexToByte(answer).length,
					packet.getAddress(), packet.getPort());
			datagramSocket.send(sendDP);
		} catch (IOException e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * UDP设置处理
	 * 
	 * @param inetAddress
	 * @param port
	 */
	private void writeDevice(String deviceSourceCode, DatagramPacket dp) {
		try {
			WriteDeviceVO writeDeviceVO = Constant.writeDeviceDataMap.get(deviceSourceCode);
			// 如果设备缓存中存在（证明在线）并且写入命令缓存中的写入标志为true（有页面的设置操作时候）
			if (writeDeviceVO != null && writeDeviceVO.getHasWriteControl()) {
				logger.info("设备{}回传设置开始执行", deviceSourceCode);
				byte[] totalData = CRCUtil.hexToByte(writeDeviceVO.getSendData());
				DatagramPacket sendDP = new DatagramPacket(totalData, totalData.length, dp.getAddress(), dp.getPort());
				datagramSocket.send(sendDP);
				logger.info("设备{}回传设置正常结束,指令为{}", deviceSourceCode, writeDeviceVO.getSendData());
			}
		} catch (Exception e) {
			logger.error("设置回传设置过程发生异常：" + e.getMessage() + e);
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

	/**
	 * 功能码：0x03读应答，0x10写应答，0x005A搜索应答，0x90错误,0x65上报,0x66报警,0x56心跳
	 * 只有0x65上报的时候更新数据库
	 * 
	 * @param data
	 * @return
	 */
	private static boolean isUpdateDeviceData(String data) {
		ReceiveStateVO newReceiveStateVO = new ReceiveStateVO(data);
		boolean result = false;
		if (newReceiveStateVO != null) {
			String function = newReceiveStateVO.getReceiveProperties().getFunction();
			if ("65".equals(function)) {
				String deviceSourceCode = newReceiveStateVO.getReceiveProperties().getDeviceSourceCode();
				ReceiveStateVO oldReceiveStateVO = ReceiveThead.receiveCacheMap.get(deviceSourceCode);
				if (oldReceiveStateVO == null) {
					ReceiveThead.receiveCacheMap.put(deviceSourceCode, newReceiveStateVO);
					result = true;
				} else {
					result = compareResult(oldReceiveStateVO, newReceiveStateVO, getCompareList());
					ReceiveThead.receiveCacheMap.put(deviceSourceCode, newReceiveStateVO);
				}

			}
		}

		return result;
	}

	/**
	 * 获取到对比的集合
	 * 
	 * @return
	 */
	private static List<String> getCompareList() {
		List<String> list = new ArrayList<String>();
		list.add("physicalNumber");
		list.add("logicNumber");
		list.add("receiveMode");
		list.add("netMode");
		list.add("hardVersion");
		list.add("softVersion");
		list.add("workVoltage");
		list.add("current");
		list.add("broadcastState");
		list.add("deviceVolume");
		list.add("digitalTelevisionRadioMode");
		list.add("digitalTelevisionRadioRate");
		list.add("QAM");
		list.add("digitalTelevisionSignalQuality");
		list.add("digitalTelevisionSignalStrength");
		list.add("signalRateList");
		list.add("signalStrengthList");
		list.add("longitude");
		list.add("latitude");
		list.add("deviceSourceNumber");
		list.add("deviceState");

		return list;
	}

	/**
	 * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个list分别存oldObj,newObj此属性名的值
	 * 
	 * @param oldObj
	 *            进行属性比较的对象1
	 * @param newObj
	 *            进行属性比较的对象2
	 * @param compareArr
	 *            选择要比较的属性数组
	 * @return 属性差异比较结果map
	 */
	@SuppressWarnings("rawtypes")
	private static boolean compareResult(Object oldObj, Object newObj, List<String> compareList) {
		try {
			if (compareList == null) {
				return false;
			}
			// 只有两个对象都是同一类型的才有可比性
			if (oldObj.getClass() == newObj.getClass()) {
				Class clazz = oldObj.getClass();
				// 获取object的属性描述
				PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
				// 这里就是所有的属性了
				for (PropertyDescriptor pd : pds) {
					// 属性名
					String name = pd.getName();
					// 如果当前属性选择进行比较，跳到下一次循环
					if (compareList != null && compareList.contains(name)) {
						// get方法
						Method readMethod = pd.getReadMethod();
						// 在oldObj上调用get方法等同于获得oldObj的属性值
						Object objBefore = readMethod.invoke(oldObj);
						// 在newObj上调用get方法等同于获得newObj的属性值
						Object objAfter = readMethod.invoke(newObj);
						// 时间类型不需要比较，直接跳过
						if (objBefore instanceof Timestamp) {
							continue;
						}
						if (objBefore == null && objAfter == null) {
							continue;
						} else if (objBefore == null && objAfter != null) {
							return true;
						}
						if (objBefore instanceof List) {
							objBefore = Joiner.on(",").join((List) objBefore);
						}
						if (objAfter instanceof List) {
							objAfter = Joiner.on(",").join((List) objAfter);
						}
						// 比较这两个值是否相等,不等则放入map
						if (!objBefore.equals(objAfter)) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * 响应相关心跳以及上报命令 //帧头 12 u8 Head; //包头标记=0x26 u8 Source[9]; //设备资源编码 u8 Ver;
	 * //协议版本号0x01 u8 Reserve; //保留0 //帧体 3+n u8 Function;
	 * //功能码：0x03读，0x10写,0x005A搜索 u16 DataLen; //数据长度 u8 * DataBuf; //数据内容，可变长度
	 * //校验 2 u16 CRC16; //帧体数据CRC16_MODBUS
	 * 
	 * @param hexData
	 */
	private static void receiveAnswer(DatagramSocket ds, DatagramPacket dp, String hexData) {
		try {
			ReceiveStateVO receiveStateVO = new ReceiveStateVO(hexData);
			ReceiveProperties receiveProperties = receiveStateVO.getReceiveProperties();
			String head = "26";
			String source = receiveProperties.getDeviceSourceCode();
			String ver = receiveProperties.getProtocolVersion();
			String reserve = "00";
			String function = "10";
			String dataLenth = "0400";
			String data = "41030100";
			String body = function + dataLenth + data;
			String crc = CRCUtil.getCRC(CRCUtil.hexToByte(body));
			String sendData = head + source + ver + reserve + body + crc;
			logger.info("Send To {}:{} " + sendData, dp.getAddress().getHostAddress(), dp.getPort());
			DatagramPacket sendDP = new DatagramPacket(CRCUtil.hexToByte(sendData), CRCUtil.hexToByte(sendData).length,
					dp.getAddress(), dp.getPort());
			ds.send(sendDP);
		} catch (IOException e) {
			logger.error("回传响应的应答出现异常：" + e.getMessage() + e);
		}
	}

	/**
	 * 测试用
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		DatagramSocket datagramSocket = new DatagramSocket(7000);
		while (true) {
			// 创建字节数据
			byte[] data = new byte[1024];
			// 创建数据包对象，传递字节数组
			DatagramPacket dp = new DatagramPacket(data, data.length);
			// 调用datagramSocket对象的方法receive传递数据包
			datagramSocket.receive(dp);
			String hexData = CRCUtil.byteToHex(dp.getData(), dp.getLength());
			logger.info(hexData);
			ReceiveStateVO receiveStateVO = new ReceiveStateVO(hexData);
			if (receiveStateVO != null && isUpdateDeviceData(hexData)) {
				logger.info("设备资源码{} 更新结果为{}", receiveStateVO.getReceiveProperties().getDeviceSourceCode(), 1);
			}
			receiveAnswer(datagramSocket, dp, hexData);
			receiveWriteTest();
		}
	}

	/**
	 * 回传设置
	 * 
	 * @throws SocketException
	 */
	@SuppressWarnings("resource")
	private static void receiveWriteTest() throws SocketException {
		DatagramSocket ds = new DatagramSocket(7000);
		while (true) {
			try {
				// 创建字节数据
				byte[] data = new byte[1024];
				// 创建数据包对象，传递字节数组
				DatagramPacket dp = new DatagramPacket(data, data.length);
				// 调用ds对象的方法receive传递数据包
				ds.receive(dp);
				System.out.println(CRCUtil.byteToHex(dp.getData(), dp.getLength()));
				ReceiveStateVO rsvo = new ReceiveStateVO(CRCUtil.byteToHex(dp.getData(), dp.getLength()));
				logger.info(dp.getAddress() + "--" + dp.getPort() + "--" + rsvo.toString());
				WriteDeviceVO wd = new WriteDeviceVO(
						CRCUtil.byteToHex(dp.getData(), dp.getLength()).substring(6, 20),
						rsvo.getReceiveProperties().getProtocolVersion());
				// wd.setQAM("32");
				// wd.setDeviceVolume("88");
				wd.setHandShake(false);
				// wd.setBroadcastTimeOut("10");
				// wd.setDigitalTelevisionRadioRate("475");
				wd.setDigitalTelevisionRadioMode("DVB-C");
				String totalData = wd.getSendData();
				logger.info(totalData);
				DatagramPacket sendDP = new DatagramPacket(CRCUtil.hexToByte(totalData),
						CRCUtil.hexToByte(totalData).length, dp.getAddress(), dp.getPort());
				ds.send(sendDP);
				/*
				 * wd.execute(); ds.close();
				 */
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}
