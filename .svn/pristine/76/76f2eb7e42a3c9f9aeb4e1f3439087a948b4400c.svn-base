package cn.wtu.broadcast.openapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.utils.FfmpegUtil;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;
import cn.wtu.broadcast.parent.vo.IpVO;

/**
 * @description:
 * @author: AYY
 * @date: 2019-02-14 10:18
 */
public class TCPUtil2 {
	private static Logger logger = LoggerFactory.getLogger(FfmpegUtil.class);
	
	public static String talkTagTo = "00000000";

	/**
	 * 消息头部分 后面还需加上数据包长度
	 * 
	 * @param version
	 * @param talkTag
	 * @param askOrAnswer
	 * @param isSign
	 * @return
	 */
	public static String head2(String version, String talkTag, String askOrAnswer, String isSign) {
		String head = "fefd" + version + talkTag + askOrAnswer + isSign;

		return head;
	}
	
	public static String askHead(String version, String isSign) {
		String head = "fefd" + version + talkTagTo + "01" + isSign;  //01表示请求数据包   isSign是否签名 
		int i = (Integer.parseInt(talkTagTo)+1);
		if(i<10){
			talkTagTo = "0000000"+i;
		}else if(i<100){
			talkTagTo = "000000"+i;
		}else if(i<1000){
			talkTagTo = "00000"+i;
		}else if(i<10000){
			talkTagTo = "0000"+i;
		}else if(i<100000){
			talkTagTo = "000"+i;
		}else if(i<1000000){
			talkTagTo = "00"+i;
		}else if(i<10000000){
			talkTagTo = "0"+i;
		}else{
			talkTagTo = ""+i;
		}
		return head;
	}

	/**
	 * body部分 后面还需加上 业务数据长度 + 业务数据内容
	 * 
	 * @param senderCode
	 * @param objsCode
	 * @param serviceType
	 * @return
	 */
	public static String body2(String senderCode, List<String> objsCode, String serviceType) {
		StringBuilder sb = new StringBuilder(senderCode);
		sb.append("" + getRealLenth("" + objsCode.size()));
		for (String i : objsCode) {
			sb.append(i);
		}
		// 业务数据类型 30身份认证 01开播 12参数设置
		sb.append(serviceType);
		return sb.toString();
	}

	public static String tail(String head, String body, boolean isSign,String privateKey) {
		String tail = "";
		if (isSign) {
			StringBuilder dataForSign = new StringBuilder(head);
			String totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 12 + 64 + 6));
			dataForSign.append(totalSize).append(body);

			List<String> privateKeys = new ArrayList<String>();
			privateKeys.add(privateKey);
			SignatureData signatureData = new SignatureData(privateKeys);

			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
			byte[] random = signatureData.calendar2Bytes(calendar);
			signatureData.random = random;

			signatureData.setSrcData(UDPUtil.hexToByte(dataForSign.toString()));
			byte[] signData = signatureData.convertToBytes();
			// 签名时间 + 证书编号 +签名
			tail += UDPUtil.byteToHex(signData);
			// 验证数据加上长度
			tail = getRealLenth(Integer.toHexString(tail.length() / 2)) + tail;
			StringBuilder all = new StringBuilder(head);
			all.append(totalSize).append(body).append(tail);
			int calculate = TCRC32.crc_Calculate(UDPUtil.hexToByte(all.toString()), 0,
					UDPUtil.hexToByte(all.toString()).length);
			String hex32 = Integer.toHexString(calculate);
			tail += hex32;
		} else {
			StringBuilder all = new StringBuilder(head);
			String totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 6));
			all.append(totalSize).append(body);
			int calculate = TCRC32.crc_Calculate(UDPUtil.hexToByte(all.toString()), 0,
					UDPUtil.hexToByte(all.toString()).length);
			String hex32 = Integer.toHexString(calculate);
			tail += hex32;
		}
		return tail;
	}

	/**
	 * 开始播发
	 * 
	 * @param fId
	 *            广播消息编码
	 * @param broadCastType
	 *            广播类型(应急，日常，演练...)
	 * @param level
	 *            事件级别（重大，特别重大...）
	 * @param audioUrl
	 *            音频url
	 * @return
	 */
	public static String play(IpVO ipvo) {
		Calendar now = Calendar.getInstance();
		String year = "" + now.get(Calendar.YEAR);
		String month = "" + (now.get(Calendar.MONTH) + 1);
		String day = "" + now.get(Calendar.DAY_OF_MONTH);
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}

		StringBuilder playData = new StringBuilder();
		playData.append(ipvo.getPlatformResourceCode()).append(year + month + day);
		playData.append(ipvo.getfId());
		playData.append(ipvo.getBroadCastType());
		playData.append(ipvo.getEventLevel());
		playData.append(ipvo.getEventType());
		playData.append("" + ipvo.getVolume());

		Calendar cal = Calendar.getInstance();
		long time = cal.getTime().getTime();
		String startTime = Integer.toHexString((int) (time / 1000));
		String endTime = Integer.toHexString((int) ((time / 1000) + 360)); // 默认取开始时间6分钟后结束，以后可再商议
		playData.append(startTime);
		playData.append(endTime);
		playData.append(ipvo.getCount());
		playData.append(ipvo.getType());
		playData.append(ipvo.getLen());
		playData.append(ipvo.getProtocolType()).append(ipvo.getAudioCodeType()).append(ipvo.getAudioPid());
		//playData.append("04").append("02").append(ipvo.getAudioPid());
		playData.append(ipvo.getReserveInfo()).append(UDPUtil.stringToAscii(ipvo.getAudioURL()));
		return playData.toString();

	}

	/**
	 * 发送ip指令，根据数据包返回客户端ip地址
	 * @param serviceType 业务数据类型 例如 01代表开播
	 * @param ipvo 待封装的业务数据
	 * @return
	 * @throws IOException
	 */
	public static String send(String serviceType, IpVO ipvo) throws IOException {

		// 建立服务端，ip地址为本机ip
		ServerSocket serverSocket = new ServerSocket(9000);
		// 监听客户端的链接，一旦有客户端链接，则会返回客户端对应的accept
		Socket accept = serverSocket.accept();
		InputStream inputStream = accept.getInputStream();
		byte[] b = new byte[1024];
		inputStream.read(b);
		InetAddress inetAddress = accept.getInetAddress();
		logger.info("inetAddress:" + inetAddress.getHostAddress());
		String answer = UDPUtil.byteToHex(b);
		logger.info("接收：" + answer);
		String talkTag = answer.substring(8, 16);
		String objCode = answer.substring(24, 42);
		String senderCode = ipvo.getPlatformResourceCode();
		StringBuilder body = new StringBuilder();
		// 给客户端发送消息
		OutputStream outputStream = accept.getOutputStream();
		// 业务数据
		String sendData = "";
		// "30" 身份认证请求标识  "01"表示客户端请求标志
		if (answer.substring(46, 48).equals("30")) {
			if (answer.substring(16, 18).equals("01")) {
				// "02"代表回复身份认证应答
				String askOrAnswer = "02";
				// 获取签名标志
				String isSign = answer.substring(18, 20);
				// 业务数据类型
				String serviceType1 = answer.substring(46, 48);
				// 协议类型 例如0200
				String protocol = answer.substring(4, 8);
				// 缺少数据包长度,后面会加上
				String head = head2(protocol, talkTag, askOrAnswer, isSign); 
				StringBuilder allData = new StringBuilder(head);
				List<String> obj = new ArrayList<String>();
				obj.add(objCode);		//TODO 目标对象编码到底该填区域码 还是建立连接的客户端资源码
				sendData = answerToDevice();
				body.append(body2(senderCode, obj, serviceType1) + sendData); // body头部+业务数据长度+业务数据
				String totalSize = getRealLenth(
						Integer.toHexString(head.length() / 2 + body.length() / 2 + 12 + 64 + 6));
				String tail = tail(head, body.toString(), true ,ipvo.getPrivateKey()); // true标识要签名
				allData.append(totalSize).append(body).append(tail);
				outputStream.write(UDPUtil.hexToByte(allData.toString()));
				logger.info("身份认证发送成功:" + allData.toString());

				// 再次接收数据
				inputStream.read(b);
				answer = UDPUtil.byteToHex(b);
				logger.info("接收2：" + answer);
				serviceType1 = answer.substring(46, 48);
				talkTag = answer.substring(8, 16);
				isSign = answer.substring(18, 20);
				// 若为心跳，则回复一般应答
				if (serviceType1 == "10" || serviceType1.equals("10")) {
					head = head2(answer.substring(4, 8), talkTag, askOrAnswer, isSign);
					sendData = heartAnswer();
					StringBuilder heartBody = new StringBuilder();
					// body头部+业务数据长度+业务数据
					heartBody.append(body2(senderCode, obj, serviceType1) + sendData); 
					totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + heartBody.length() / 2 + 6));
					tail = tail(head, heartBody.toString(), false, ipvo.getPrivateKey());
					StringBuilder heartData = new StringBuilder(head);
					heartData.append(totalSize).append(heartBody).append(tail);
					outputStream.write(UDPUtil.hexToByte(heartData.toString()));
					logger.info("心跳回复发送成功:" + heartData.toString());
				}

				// 发送开播指令
				head = askHead(protocol, "01");
				sendData = play(ipvo);
				StringBuilder playBody = new StringBuilder();
				// body头部+业务数据长度+业务数据
				playBody.append(body2(senderCode, ipvo.getResourceCodeList(), serviceType) 
						+ getRealLenth(Integer.toHexString(sendData.length() / 2))
						+ sendData); 
				// 12 + 64 + 6 代表尾部的固定长度
				totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + playBody.length() / 2 + 12 + 64 + 6));
				tail = tail(head, playBody.toString(), true ,ipvo.getPrivateKey());
				StringBuilder ipPlayData = new StringBuilder(head);
				ipPlayData.append(totalSize).append(playBody).append(tail);
				outputStream.write(UDPUtil.hexToByte(ipPlayData.toString()));
				logger.info("开播指令发送成功:" + ipPlayData.toString());
				new Thread(() -> {
/*					try {
						FfmpegUtil.play(Integer.valueOf(ipvo.getfId()), ipvo.getServiceIp(), ipvo.getBroadcastAudioUrl(),ipvo.getIpPlayPort(), ipvo.getBroadcastTomcatPath());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
*/				}).start();
				// 再次读取设备信息				
				int i = 100;
				while (true) {
					inputStream.read(b);
					String answer4 = UDPUtil.byteToHex(b);
					talkTag = answer4.substring(8, 16);
					System.out.println("心跳会话标识："+answer4.substring(8, 16));
					// answer.substring(4, 8) 代表协议类型例如0200  00代表不签名
					head = head2(answer4.substring(4, 8), talkTag, askOrAnswer, "00");
					sendData = heartAnswer();
					StringBuilder heartBody = new StringBuilder();
					StringBuilder heartData = new StringBuilder(head);
			        // body头部+业务数据长度+业务数据
					heartBody.append(body2(senderCode, obj, "10") + sendData); 
					totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + heartBody.length() / 2 + 6));
					tail = tail(head, heartBody.toString(), false ,ipvo.getPrivateKey());
					heartData.append(totalSize).append(heartBody).append(tail);
					outputStream.write(UDPUtil.hexToByte(heartData.toString()));
					logger.info("send:" + heartData.toString());
					i--;
					if (i == 0) {
						break;
					}
				}
			}
		} else if (serviceType == "10" || serviceType.equals("10")) {
			// 心跳包，暂时不处理
		}

		inputStream.read(b);
		answer = UDPUtil.byteToHex(b);
		logger.info("接收：" + answer);
		talkTag = answer.substring(8, 16);
		objCode = answer.substring(24, 42);
		serverSocket.close();
		return inetAddress.getHostAddress();
	}

	private static String heartAnswer() {
		// body 061245140210220301
		StringBuilder body = new StringBuilder();
		// 业务数据长度
		body.append("00"); // 应答结果 00成功
		body.append("0004"); // 结果描述长度为
		List<String> privateKeys = new ArrayList<String>();
		SignatureData signatureData = new SignatureData(privateKeys);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		byte[] random = signatureData.calendar2Bytes(calendar);
		String UTC = UDPUtil.byteToHex(random);
		// 加上UTC时间
		body.append(UTC); 
		logger.info("业务数据长度：" + (Integer.toHexString(body.length() / 2)));
		body.insert(0, getRealLenth(Integer.toHexString(body.length() / 2)));
		logger.info("身份认证应答业务数据" + body.toString());
		return body.toString();
	}

	public static String answerToDevice() {
		// body 061245140210220301
		StringBuilder body = new StringBuilder();
		// 业务数据长度
		body.append("00"); // 应答结果 00成功
		body.append("0000"); // 结果描述长度为0
		logger.info("业务数据长度：" + (Integer.toHexString(body.length() / 2)));
		body.insert(0, getRealLenth(Integer.toHexString(body.length() / 2))); // 业务数据类容长度
		// 42为消息体前面内容长度
		// 数据源对象编码9 +
		// 数据目标对象数量2 +
		// 数据目标对象编码序列9*1
		// +业务数据类型1
		logger.info("身份认证应答业务数据" + body.toString());
		return body.toString();
	}

	/**
	 * 前面补0操作，满足2字节要求
	 * @param len
	 * @return
	 */
	private static String getRealLenth(String len) {
		if(len != null){
			if (len.length() == 1) {
				return "000" + len;
			} else if (len.length() == 2) {
				return "00" + len;
			} else if (len.length() == 3) {
				return "0" + len;
			}
		}
		
		return len;
	}
}