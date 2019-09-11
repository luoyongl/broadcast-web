package cn.wtu.broadcast.openapi.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.thread.SendIPAudioThread;
import cn.wtu.broadcast.openapi.thread.SendIPThread;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;
import cn.wtu.broadcast.parent.vo.IpPictureVO;
import cn.wtu.broadcast.parent.vo.IpTextVO;
import cn.wtu.broadcast.parent.vo.IpVO;
import cn.wtu.broadcast.parent.vo.IpVideoVO;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class SendIPUtils {

	public static Logger logger = LoggerFactory.getLogger(SendIPUtils.class);

	public static ConcurrentHashMap<String, String> paramsCache = new ConcurrentHashMap<String, String>();

	public static ConcurrentHashMap<String, ChannelHandlerContext> ctxMap = new ConcurrentHashMap<String, ChannelHandlerContext>();

	public static ConcurrentHashMap<String, String> answerMap = new ConcurrentHashMap<String, String>();

	public static ConcurrentHashMap<String, IpVO> sendIpVOMap = new ConcurrentHashMap<String, IpVO>();
	
	public static ConcurrentHashMap<String, String> deviceStateMap = new ConcurrentHashMap<String, String>();

	/**
	 * 会话标志
	 */
	private static int talkTagTo = 1;

	/**
	 * 字符串补0操作
	 * 
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				str = sb.toString();
				strLen = str.length();
			}
		} else if (strLen > strLength) {
			str = str.substring(0, 4);
		}

		return str;
	}

	/**
	 * 例如061245140210220301
	 * 
	 * @return
	 */
	public static String heartAnswer(String timeZone) {
		StringBuilder body = new StringBuilder();
		// 应答结果 00成功
		body.append("00");
		// 结果描述长度为
		body.append("0004");
		List<String> privateKeys = new ArrayList<String>();
		SignatureData signatureData = new SignatureData(privateKeys);
		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(timeZone) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));
		} else if (Integer.parseInt(timeZone) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		byte[] random = signatureData.calendar2Bytes(cal);
		String UTC = UDPUtil.byteToHex(random);
		// 加上UTC时间
		body.append(UTC);
		body.insert(0, getRealLenth(Integer.toHexString(body.length() / 2)));
		return body.toString();
	}

	/**
	 * 获取serviceType 例如061245140210220301
	 * 
	 * @return
	 */
	public static String answerToDevice() {
		StringBuilder body = new StringBuilder();
		// 应答结果 00成功
		body.append("00");
		// 结果描述长度为0
		body.append("0000");
		logger.info("业务数据长度：" + (Integer.toHexString(body.length() / 2)));
		// 业务数据类容长度
		body.insert(0, getRealLenth(Integer.toHexString(body.length() / 2)));
		// 42为消息体前面内容长度 数据源对象编码9 + 数据目标对象数量2 + 数据目标对象编码序列9*1 +业务数据类型1
		logger.info("身份认证应答业务数据" + body.toString());
		return body.toString();
	}

	/**
	 * 封装请求头部
	 * 
	 * @param version 版本号
	 * @param talkTag 会话标记，如果是主动请求记得要加1，如果是回复直接取回复的标记即可
	 * @param askOrAnswer 01请求 02应答
	 * @param isSign 是否签名 00：否 01：是
	 * @return
	 */
	public static String getAskHead(String answer) {
		// "02"代表回复身份认证应答
		String askOrAnswer = "02";
		// 会话标记
		String talkTag = answer.substring(8, 16);
		// 获取签名标志
		String isSign = answer.substring(18, 20);
		// 协议类型 例如0200
		String protocol = answer.substring(4, 8);
		// 缺少数据包长度,后面会加上
		String head = "fefd" + protocol + talkTag + askOrAnswer + isSign;
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
	public static String getBody(String senderCode, List<String> objsCode, String serviceType) {
		StringBuilder sb = new StringBuilder(senderCode);
		sb.append("" + getRealLenth("" + objsCode.size()));
		for (String i : objsCode) {
			sb.append(i);
		}
		// 业务数据类型 30身份认证 01开播 12参数设置
		sb.append(serviceType);
		return sb.toString();
	}

	/**
	 * 获取签名后的数据
	 * 
	 * @param head
	 * @param body
	 * @param isSign
	 * @param privateKey
	 * @return
	 */
	public static String tail(String head, String body, boolean isSign, String privateKey, String timeZoneSet) {
		String tail = "";
		if (isSign) {
			StringBuilder dataForSign = new StringBuilder(head);
			String totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 12 + 64 + 6));
			dataForSign.append(totalSize).append(body);

			List<String> privateKeys = new ArrayList<String>();
			privateKeys.add(privateKey);
			SignatureData signatureData = new SignatureData(privateKeys);
			/**
			 * 0-local 1-UTC lxg 2019-04-04
			 */
			Calendar cal = Calendar.getInstance();
			if (Integer.parseInt(timeZoneSet) == 0) {
				// 获得时区和 GMT-0 的时间差,偏移量
				int offset = cal.get(Calendar.ZONE_OFFSET);
				// 获得夏令时 时差
				int dstoff = cal.get(Calendar.DST_OFFSET);
				cal.add(Calendar.MILLISECOND, (offset + dstoff));

			} else if (Integer.parseInt(timeZoneSet) == 1) {
				cal.setTimeZone(TimeZone.getDefault());
			}
			byte[] random = signatureData.calendar2Bytes(cal);
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
			String hex32 = addZeroForNum(Integer.toHexString(calculate), 8);
			tail += hex32;
		} else {
			StringBuilder all = new StringBuilder(head);
			String totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 6));
			all.append(totalSize).append(body);
			int calculate = TCRC32.crc_Calculate(UDPUtil.hexToByte(all.toString()), 0,
					UDPUtil.hexToByte(all.toString()).length);
			String hex32 = addZeroForNum(Integer.toHexString(calculate), 8);
			tail += hex32;
		}
		return tail;
	}

	/**
	 * 获取签名后的数据
	 * 
	 * @param head
	 * @param body
	 * @param isSign
	 * @param privateKey
	 * @return
	 */
	public static String tail(String head, String body, boolean isSign, String privateKey) {
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
			String hex32 = addZeroForNum(Integer.toHexString(calculate), 8);
			tail += hex32;
		} else {
			StringBuilder all = new StringBuilder(head);
			String totalSize = getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 6));
			all.append(totalSize).append(body);
			int calculate = TCRC32.crc_Calculate(UDPUtil.hexToByte(all.toString()), 0,
					UDPUtil.hexToByte(all.toString()).length);
			String hex32 = addZeroForNum(Integer.toHexString(calculate), 8);
			tail += hex32;
		}
		return tail;
	}

	/**
	 * 前面补0操作，满足2字节要求
	 * 
	 * @param len
	 * @return
	 */
	public static String getRealLenth(String len) {
		if (len != null) {
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

	public static String getSendHead(String answer) {
		// "01"发送开播指令
		String askOrAnswer = "01";
		// 会话标记
		String talkTag = getSendTalkTag();
		// 获取签名标志
		String isSign = "01";
		String isMike = answer.substring(0, 2);
		String protocol = "";
		if ("49".equals(isMike)) {
			// 协议类型 例如0200
			protocol = answer.substring(2, 6);
		} else {
			protocol = answer.substring(4, 8);
		}
		// 缺少数据包长度,后面会加上
		String head = "fefd" + protocol + talkTag + askOrAnswer + isSign;
		return head;
	}

	/**
	 * 获取发送IP指令的会话标记，内存中递增，重启后重置
	 * 
	 * @return
	 */
	public static String getSendTalkTag() {
		String talkTag = new DecimalFormat("00000000").format(talkTagTo);
		talkTagTo++;
		return talkTag;
	}

	public static String intToHex(int n) {
		StringBuffer s = new StringBuffer();
		String a;
		char[] b = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (n != 0) {
			s = s.append(b[n % 16]);
			n = n / 16;
		}
		a = s.reverse().toString();
		return a;
	}

	public static String ipToLong(String ipString) {
		String[] ip = ipString.split("\\.");
		StringBuffer sb = new StringBuffer();
		for (String str : ip) {
			sb.append(addZeroForNum(Integer.toHexString(Integer.parseInt(str)), 2));
		}
		return sb.toString();
	}

	public String testName(String answer, int talkTag1, String privateKey) {
		// head部分
		// "01"请求
		String askOrAnswer = "01";
		// 会话标记
		String talkTag = addZeroForNum(Integer.toString(talkTag1), 8);
		// 获取签名标志
		String isSign = "01";
		// 协议类型 例如0200
		String protocol = answer.substring(4, 8);// "0200";
		// 缺少数据包长度,后面会加上
		String head = "fefd" + protocol + talkTag + askOrAnswer + isSign;

		// body部分
		String platForm = "010345108100000001"; // 平台编码
		String objCounts = "0001";
		String objCode = "061245140210220301"; // 设备资源码

		String serviceType = "11"; // 12 终端参数配置

		String serviceDataLen = "";

		// 业务数据
		StringBuilder sb = new StringBuilder();
		// 要查询的参数个数
		int paramCounts = 0;
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0004"); // 参数编码
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0104"); //
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0204"); //
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0304"); //
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0404"); //
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0504"); //
		}
		if (true) {
			// sb.append("01");
			paramCounts++;
			sb.append("0604"); //
		}

		sb.insert(0, addZeroForNum("" + paramCounts, 2));
		serviceDataLen = addZeroForNum(Integer.toHexString(sb.length() / 2), 4);
		String body = platForm + objCounts + objCode + serviceType + serviceDataLen + sb.toString();

		String totalLen = addZeroForNum(Integer.toHexString(head.length() / 2 + body.length() / 2 + 12 + 64 + 6), 4);
		StringBuilder allData = new StringBuilder(head);
		// UTC时间
		String tail = SendIPUtils.tail(head, body.toString(), true, privateKey);
		allData.append(totalLen).append(body).append(tail);
		return allData.toString();
	}

	public static int getRealValue(char c) {
		int n = 0;
		if (c >= 'a' && c <= 'f')
			n = c - 'a' + 10;
		if (c >= 'A' && c <= 'F')
			n = c - 'A' + 10;
		if (c >= '0' && c <= '9')
			n = c - '0';
		return n;
	}

	public static int hexToTen(String s) {
		int m = 0;
		for (int i = 0; i < s.length(); i++) {
			m = 16 * m + getRealValue(s.charAt(i));
		}
		return m;
	}

	/**
	 * 播发数据封装
	 * 
	 * @param fId 广播消息编码
	 * @param broadCastType 广播类型(应急，日常，演练...)
	 * @param level 事件级别（重大，特别重大...）
	 * @param audioUrl 音频url
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
		// playData.append(SendIPThread.addZeroForNum(String.valueOf(orderId++),
		// 4)); // 补齐4位顺序码
		// ipvo.setOrderId(String.valueOf(orderId++));
		playData.append(SendIPThread.addZeroForNum(ipvo.getfId(), 4)); // 补齐4位顺序码

		playData.append(ipvo.getBroadCastType());
		playData.append(ipvo.getEventLevel());
		playData.append(ipvo.getEventType());

		// 将音量如60 转换成16进制 3c
		String volume = intToHex(ipvo.getVolume().intValue());
		playData.append(SendIPThread.addZeroForNum(volume, 2));
		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(ipvo.getTimeZoneSet()) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));
		} else if (Integer.parseInt(ipvo.getTimeZoneSet()) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		String startTime = Integer.toHexString((int) (cal.getTime().getTime() / 1000));
		String endTime = Integer.toHexString((int) ((cal.getTime().getTime() / 1000) + 360)); // 默认取开始时间6分钟后结束，以后可再商议
		playData.append(startTime);
		playData.append(endTime);
		playData.append(ipvo.getCount());
		// 辅助数据类型 01文本 02音频 03图片 04视频
		playData.append(ipvo.getType());
		playData.append(ipvo.getLen());

		if (Integer.parseInt(ipvo.getIpProtocalSet()) == 0) {
			playData.append(ipvo.getProtocolType()).append(ipvo.getAudioCodeType()).append(ipvo.getAudioPid());
			// playData.append(ipvo.getProtocolType()).append(ipvo.getAudioCodeType());
		} else {
			playData.append(ipvo.getProtocolType2()).append(ipvo.getAudioCodeType()).append("0000");
			// playData.append(ipvo.getProtocolType2()).append(ipvo.getAudioCodeType());

		}
		playData.append(ipvo.getReserveInfo()).append(UDPUtil.stringToAscii(ipvo.getAudioURL()));
		// playData.append(UDPUtil.stringToAscii(ipvo.getAudioURL()));
		return playData.toString();
	}

	/**
	 * 心跳应答响应处理
	 * 
	 * @param answer
	 */
	public static void heartControl(Channel channel, String answer) {
		String data = null;
		try {
			// 设备资源编码
			String resourceCode = answer.substring(24, 42);
			// 业务数据类型
			String serviceType = answer.substring(46, 48);
			// 缺少数据包长度,后面会加上
			String head = SendIPUtils.getAskHead(answer);
			// 获取缓存中的数据
			String timeZone = paramsCache.get("timeZone");
			String platformResourceCode = paramsCache.get("platformResourceCode");
			String privateKey = paramsCache.get("privateKey");
			String sendData = SendIPUtils.heartAnswer(timeZone);
			StringBuilder heartBody = new StringBuilder();
			List<String> obj = new ArrayList<String>();
			obj.add(resourceCode);
			// body头部+业务数据长度+业务数据
			heartBody.append(SendIPUtils.getBody(platformResourceCode, obj, serviceType) + sendData);
			String totalSize = SendIPUtils
					.getRealLenth(Integer.toHexString(head.length() / 2 + heartBody.length() / 2 + 6));
			String tail = SendIPUtils.tail(head, heartBody.toString(), false, privateKey, timeZone);
			StringBuilder heartData = new StringBuilder(head);
			heartData.append(totalSize).append(heartBody).append(tail);
			data = heartData.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(UDPUtil.hexToByte(data));
			logger.info("心跳数据:" + answer.toString());
			logger.info("心跳回复发送成功:" + data);
		}
	}

	/**
	 * ip话筒
	 * 
	 * @param serviceIp
	 * @param tsPort
	 * @param pid
	 */
	public static void ipMikeAnswer(Channel channel) {
		String data = null;
		try {
			// 获取缓存中的数据
			String ipServerIP = paramsCache.get("ipServerIP");
			String pid = paramsCache.get("pid");
			String tsPort = paramsCache.get("tsPort");
			StringBuilder body = new StringBuilder();
			System.out.println(ipServerIP);
			body.append("00000000");
			String url = "distribution:TS," + ipServerIP + ":" + tsPort + "," + pid;
			String asciiUrl = UDPUtil.stringToAscii(url);
			int ascLen = asciiUrl.length();
			String len = SendIPUtils.addZeroForNum(Integer.toHexString(ascLen / 2), 8);
			body.append(len).append(asciiUrl);
			data = body.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(UDPUtil.hexToByte(data));
			logger.info("ip话筒回应发送成功:" + data);
		}
	}

	/**
	 * 
	 * @param answer
	 */
	@SuppressWarnings("unused")
	public static void sendIpMikeInfo(String answer) {
		String controlType = null;
		IpVO ipVO = new IpVO();
		try {
			// 获取缓存中的数据
			String platformResourceCode = paramsCache.get("platformResourceCode");
			String privateKey = paramsCache.get("privateKey");
			String ipServerIP = paramsCache.get("ipServerIP");
			String timeZone = paramsCache.get("timeZone");
			String pid = paramsCache.get("pid");
			String tsPort = paramsCache.get("tsPort");
			String ipMikePlayPort = paramsCache.get("ipMikePlayPort");
			String ipProtocalSet = paramsCache.get("ipProtocalSet");
			// ebm--emergency broadcast message
			String ebm_id = answer.substring(18, 48); // BCD编码的应急广播消息标识符；(当EBMID=0时的关机为全区域关机)
			String fId = answer.substring(44, 48);
			controlType = answer.substring(48, 50); // 开机：1；关机：2
			String broadcastType = answer.substring(50, 52);
			String ebmType = answer.substring(52, 62);
			String ebmLevel = answer.substring(62, 64);
			String startTime = answer.substring(64, 72);
			String endTime = answer.substring(72, 80);
			String volume = answer.substring(80, 82);
			String findAddressType = answer.substring(82, 84);
			String resourceCount = answer.substring(84, 86);
			int resourceLen = Integer.parseInt(answer.substring(86, 88));
			List<String> resourceCodeList = new ArrayList<String>();
			for (int i = 0; i < Integer.parseInt(resourceCount); i++) {
				resourceCodeList.add(answer.substring(88 + i * resourceLen * 2, 88 + resourceLen * 2 * (i + 1)));
			}
			ipVO.setPrivateKey(privateKey);
			ipVO.setIpProtocalSet(ipProtocalSet);
			ipVO.setIpPlayPort(ipMikePlayPort);
			ipVO.setServiceIp(ipServerIP);
			ipVO.setIpMikeTSport(tsPort);
			ipVO.setfId(fId);
			// 设置平台资源编码
			ipVO.setPlatformResourceCode(platformResourceCode);
			ipVO.setBroadCastType(broadcastType);
			ipVO.setEventType(ebmType);
			ipVO.setEventLevel(ebmLevel);
			ipVO.setVolume((byte) (SendIPUtils.hexToTen(volume)));
			// 时区
			ipVO.setTimeZoneSet(timeZone);
			String audioUrl = "http://" + ipVO.getServiceIp() + ":" + ipVO.getIpPlayPort() + "/vlc";
			ipVO.setAudioURL(audioUrl);
			ipVO.setPlayType(3);
			ipVO.setResourceCodeList(resourceCodeList);
			ipVO.setAudioPid(SendIPUtils.addZeroForNum(pid, 4));
			String asciiUrl = UDPUtil.stringToAscii(audioUrl);
			int ascLen = asciiUrl.length();
			String len = SendIPUtils.getRealLenth(Integer.toHexString(13 + ascLen / 2)); // 13为9位保留数据+4位pid
			ipVO.setLen(len);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		// IP话筒操作
		if (controlType != null && "01".equals(controlType)) {
			// 开播
			if (SendIPUtils.ctxMap.size() > 0) {
				for (String resourceCode : SendIPUtils.ctxMap.keySet()) {
					if (isCanSend(resourceCode, ipVO.getResourceCodeList())) {
						sendIPControl(SendIPUtils.ctxMap.get(resourceCode).channel(), answer, ipVO, null);
					}
				}
			}
			try {
				Thread sendIPThread = new Thread(new SendIPAudioThread(ipVO, null));
				sendIPThread.start();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else if (controlType != null && "02".equals(controlType)) {
			ipStopBroadcast(ipVO, answer);
		}
	}

	/**
	 * 停播处理
	 * 
	 * @param ipVO
	 */
	private static void ipStopBroadcast(IpVO ipVO, String answer) {
		// 停播
		if (SendIPUtils.ctxMap.size() > 0) {
			for (String resourceCode : SendIPUtils.ctxMap.keySet()) {
				if (SendIPUtils.isCanSend(resourceCode, ipVO.getResourceCodeList())) {
					SendIPUtils.stopIPControl(SendIPUtils.ctxMap.get(resourceCode).channel(),
							SendIPUtils.answerMap.get(resourceCode), ipVO);
				}
			}
		}
	}

	/**
	 * 发送停播指令
	 * 
	 * @param answer
	 * @param ipvo
	 */
	public static void stopIPControl(Channel channel, String answer, IpVO ipVO) {
		String data = null;
		try {
			// 业务数据类型
			String serviceType = "02";
			// 发送停播指令
			String head = SendIPUtils.getSendHead(answer);
			String sendData = SendIPUtils.stopPlay(ipVO);
			StringBuilder playBody = new StringBuilder();
			// body头部+业务数据长度+业务数据
			playBody.append(
					SendIPThread.getBody(ipVO.getPlatformResourceCode(), ipVO.getResourceCodeList(), serviceType)
							+ SendIPThread.getRealLenth(Integer.toHexString(sendData.length() / 2)) + sendData);
			// 12 + 64 + 6 代表尾部的固定长度
			String totalSize = SendIPThread
					.getRealLenth(Integer.toHexString(head.length() / 2 + playBody.length() / 2 + 12 + 64 + 6));
			String tail = SendIPThread.tail(head, playBody.toString(), true, ipVO.getPrivateKey(),
					ipVO.getTimeZoneSet());
			StringBuilder ipStopPlayData = new StringBuilder(head);
			ipStopPlayData.append(totalSize).append(playBody).append(tail);
			data = ipStopPlayData.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(UDPUtil.hexToByte(data));
			logger.info("停播指令发送成功:" + data);
		}
	}

	/**
	 * 主动发送IP播放指令
	 * 
	 * @param answer
	 * @param playType 0文字 1图片 2视频 3音频广播
	 */
	public static void sendIPControl(Channel channel, String answer, IpVO ipVO, Integer playType) {
		String data = null;
		try {
			// 业务数据类型
			String serviceType = "01";
			// 发送开播指令
			String head = getSendHead(answer);
			String sendData = "";
			if (playType == null) {
				sendData = play(ipVO);
			} else if (playType == 2) {
				sendData = videoPlay(ipVO.getIpVideoVO());
			} else if (playType == 1) {
				sendData = picturePlay(ipVO.getIpPictureVO());
			} else if (playType == 0) {
				sendData = textPlay(ipVO.getIpTextVO());
			}
			StringBuilder playBody = new StringBuilder();
			// body头部+业务数据长度+业务数据
			playBody.append(
					SendIPThread.getBody(ipVO.getPlatformResourceCode(), ipVO.getResourceCodeList(), serviceType)
							+ SendIPThread.getRealLenth(Integer.toHexString(sendData.length() / 2)) + sendData);
			// 12 + 64 + 6 代表尾部的固定长度
			String totalSize = SendIPThread
					.getRealLenth(Integer.toHexString(head.length() / 2 + playBody.length() / 2 + 12 + 64 + 6));
			String tail = SendIPThread.tail(head, playBody.toString(), true, ipVO.getPrivateKey(),
					ipVO.getTimeZoneSet());
			StringBuilder ipPlayData = new StringBuilder(head);
			ipPlayData.append(totalSize).append(playBody).append(tail);
			data = ipPlayData.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(UDPUtil.hexToByte(data));
			// 保存已经播放的广播，用于停播用
			if (ipVO.getfId() != null) {
				SendIPUtils.sendIpVOMap.put(ipVO.getfId(), ipVO);
			}
			logger.info("开播指令发送成功:" + data);
		}
	}

	/**
	 * 判断该设备是否是播放区域内的(播放区域去掉尾部0，然后和设备资源编码匹配)
	 * 
	 * @param resourceCode 设备资源编码
	 * @param resourceCodeList 播发区域
	 * @return
	 */
	public static boolean isCanSend(String resourceCode, List<String> resourceCodeList) {
		if (resourceCodeList != null && resourceCodeList.size() > 0) {
			for (String code : resourceCodeList) {
				try {
					// 删除字符串尾部的0
					String newCode = removeTailZero(code);
					String newResourceCode = resourceCode.substring(0, newCode.length());
					if (newCode.equals(newResourceCode)) {
						return true;
					}
				} catch (Exception e) {
					logger.error(e.getMessage() + e);
				}
			}
		}

		return false;
	}

	/**
	 * 删除字符串尾部的0
	 * 
	 * @param str
	 * @return
	 */
	private static String removeTailZero(String str) {
		// 如果字符串尾部不为0，返回字符串
		if (!str.substring(str.length() - 1).equals("0")) {
			return str;
		} else {
			// 否则将字符串尾部删除一位再进行递归
			return removeTailZero(str.substring(0, str.length() - 1));
		}
	}

	/**
	 * 视频广告播发数据封装
	 * 
	 * @param fId 广播消息编码
	 * @param broadCastType 广播类型(应急，日常，演练...)
	 * @param level 事件级别（重大，特别重大...）
	 * @param audioUrl 音频url
	 * @return
	 */
	private static String videoPlay(IpVideoVO ipVideoVO) {
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
		playData.append(ipVideoVO.getPlatformResourceCode()).append(year + month + day);
		playData.append(SendIPThread.addZeroForNum(ipVideoVO.getfId(), 4)); // 补齐4位顺序码
		playData.append(ipVideoVO.getBroadCastType());
		playData.append(ipVideoVO.getEventLevel());
		playData.append(ipVideoVO.getEventType());

		// 将音量如60 转换成16进制 3c
		String volume = intToHex(ipVideoVO.getVolume().intValue());
		playData.append(SendIPThread.addZeroForNum(volume, 2));

		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(ipVideoVO.getTimeZoneSet()) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));
		} else if (Integer.parseInt(ipVideoVO.getTimeZoneSet()) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		String startTime = Integer.toHexString((int) (cal.getTime().getTime() / 1000));
		String endTime = Integer.toHexString((int) ((cal.getTime().getTime() / 1000) + 360)); // 默认取开始时间6分钟后结束，以后可再商议
		playData.append(startTime);
		playData.append(endTime);
		playData.append(ipVideoVO.getCount());
		// 辅助数据类型 01文本 02音频 03图片 04视频
		playData.append(ipVideoVO.getType());
		playData.append(ipVideoVO.getLen());
		// 音频
		playData.append(ipVideoVO.getProtocolType()).append(ipVideoVO.getAudioCodeType())
				.append(ipVideoVO.getAudioPid());
		// 视频
		playData.append(ipVideoVO.getReserveInfo()).append(UDPUtil.stringToAscii(ipVideoVO.getAudioURL()));
		return playData.toString();
	}

	/**
	 * 图片广告播发数据封装
	 * 
	 * @param fId 广播消息编码
	 * @param broadCastType 广播类型(应急，日常，演练...)
	 * @param level 事件级别（重大，特别重大...）
	 * @param audioUrl 音频url
	 * @return
	 */
	private static String picturePlay(IpPictureVO ipPictureVO) {
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
		playData.append(ipPictureVO.getPlatformResourceCode()).append(year + month + day);
		playData.append(SendIPThread.addZeroForNum(ipPictureVO.getfId(), 4)); // 补齐4位顺序码
		playData.append(ipPictureVO.getBroadCastType());
		playData.append(ipPictureVO.getEventLevel());
		playData.append(ipPictureVO.getEventType());

		// 将音量如60 转换成16进制 3c
		String volume = intToHex(ipPictureVO.getVolume().intValue());
		playData.append(SendIPThread.addZeroForNum(volume, 2));

		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(ipPictureVO.getTimeZoneSet()) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));
		} else if (Integer.parseInt(ipPictureVO.getTimeZoneSet()) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		String startTime = Integer.toHexString((int) (cal.getTime().getTime() / 1000));
		String endTime = Integer.toHexString((int) ((cal.getTime().getTime() / 1000) + 360)); // 默认取开始时间6分钟后结束，以后可再商议
		playData.append(startTime);
		playData.append(endTime);
		playData.append(ipPictureVO.getCount());
		// 辅助数据类型 01文本 02音频 03图片 04视频
		playData.append(ipPictureVO.getType());
		playData.append(ipPictureVO.getLen());
		playData.append(UDPUtil.stringToAscii(ipPictureVO.getPictureURL()));
		return playData.toString();
	}

	/**
	 * 文字广告播发数据封装
	 * 
	 * @param fId 广播消息编码
	 * @param broadCastType 广播类型(应急，日常，演练...)
	 * @param level 事件级别（重大，特别重大...）
	 * @param audioUrl 音频url
	 * @return
	 */
	private static String textPlay(IpTextVO ipTextVO) {
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
		playData.append(ipTextVO.getPlatformResourceCode()).append(year + month + day);
		/// playData.append(SendIPThread.addZeroForNum(String.valueOf(orderId++),
		/// 4)); // 补齐4位顺序码
		playData.append(SendIPThread.addZeroForNum(ipTextVO.getfId(), 4)); // 补齐4位顺序码
		playData.append(ipTextVO.getBroadCastType());
		playData.append(ipTextVO.getEventLevel());
		playData.append(ipTextVO.getEventType());

		// 将音量如60 转换成16进制 3c
		String volume = intToHex(ipTextVO.getVolume().intValue());
		playData.append(SendIPThread.addZeroForNum(volume, 2));

		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(ipTextVO.getTimeZoneSet()) == 0) {
			// 获得时区和 GMT-0 的时间差,偏移量
			int offset = cal.get(Calendar.ZONE_OFFSET);
			// 获得夏令时 时差
			int dstoff = cal.get(Calendar.DST_OFFSET);
			cal.add(Calendar.MILLISECOND, (offset + dstoff));
		} else if (Integer.parseInt(ipTextVO.getTimeZoneSet()) == 1) {
			cal.setTimeZone(TimeZone.getDefault());
		}
		String startTime = Integer.toHexString((int) (cal.getTime().getTime() / 1000));
		String endTime = Integer.toHexString((int) ((cal.getTime().getTime() / 1000) + 360)); // 默认取开始时间6分钟后结束，以后可再商议
		playData.append(startTime);
		playData.append(endTime);
		playData.append(ipTextVO.getCount());
		// 辅助数据类型 01文本 02音频 03图片 04视频
		playData.append(ipTextVO.getType());
		playData.append(ipTextVO.getLen());
		// utf-8转GB2312
		playData.append(UDPUtil.stringToAscii(ipTextVO.getText()));
		return playData.toString();
	}

	/**
	 * 身份认证应答响应处理
	 * 
	 * @param answer
	 * @param ipvo
	 */
	public static void authenticationControl(Channel channel, String answer) {
		String data = null;
		try {
			// 获取缓存中的数据
			String platformResourceCode = paramsCache.get("platformResourceCode");
			String privateKey = paramsCache.get("privateKey");
			String timeZone = paramsCache.get("timeZone");
			StringBuilder body = new StringBuilder();
			// 设备资源编码
			String resourceCode = answer.substring(24, 42);
			// 业务数据类型
			String serviceType = answer.substring(46, 48);
			// 缺少数据包长度,后面会加上
			String head = SendIPUtils.getAskHead(answer);
			StringBuilder allData = new StringBuilder(head);
			List<String> obj = new ArrayList<String>();
			obj.add(resourceCode);
			String sendData = SendIPUtils.answerToDevice();
			// body头部+业务数据长度+业务数据
			body.append(SendIPUtils.getBody(platformResourceCode, obj, serviceType) + sendData);
			String totalSize = SendIPUtils
					.getRealLenth(Integer.toHexString(head.length() / 2 + body.length() / 2 + 12 + 64 + 6));
			// true标识要签名
			String tail = SendIPUtils.tail(head, body.toString(), true, privateKey, timeZone);
			allData.append(totalSize).append(body).append(tail);
			data = allData.toString();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		if (data != null && channel.isOpen() && channel.isActive()) {
			channel.writeAndFlush(UDPUtil.hexToByte(data));
			logger.info("身份认证发送成功:" + data);
		}
	}

	/**
	 * 封装停播指令
	 * 
	 * @param ipvo
	 * @return
	 */
	public static String stopPlay(IpVO ipvo) {
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
		playData.append(SendIPThread.addZeroForNum(ipvo.getfId(), 4));
		return playData.toString();
	}
}
