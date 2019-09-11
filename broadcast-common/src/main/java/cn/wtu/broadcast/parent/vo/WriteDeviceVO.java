package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.wtu.broadcast.parent.utils.CRCUtil;
import cn.wtu.broadcast.parent.utils.DateUtil;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-28 15:45
 */
public class WriteDeviceVO implements Serializable{

	private static final long serialVersionUID = -3822958980341262405L;

	private String head;

	private Integer dataLength = 0;

	public String data = "";
	
	/**
	 * 只有当页面点击设置设备参数的时候才将该字段设置为true
	 * 用于判断缓存中的设备是否有设置指令
	 */
	private Boolean hasWriteControl = false;

	/**
	 * 包头标记=0x26 设备资源编码
	 * 
	 * @param deviceSourceNumber
	 * @param source
	 */
	public WriteDeviceVO(String source, String protocolVersion) {
		head = "26" + source + protocolVersion + "00";
	}

	/**
	 * 设置调频接受频率(FM1,FM2)
	 * 
	 * @param rateList
	 */
	public void setSignalRateList(List<Double> rateList) {
		Integer rateNumber = rateList.size();
		Integer length = rateNumber * 3 + 1;
		String s = numToHex8(rateNumber);
		for (int i = 0; i < rateNumber; i++) {
			int cnt = i + 1;
			s += "0" + cnt + numToHex16((int) (rateList.get(i) * 100));
		}
		data += "0103" + numToHex8(length) + s;
		dataLength += 3 + length;
	}
	
	/**
	 * 音频回传协议(1 UDP;2 TCP;3串口;其它值预留)
	 * 
	 * @param rateList
	 */
	public void setAudioProtocol(int type) {
		data += "3903" + "01";
		if(type == 1){
			data += "01";
		} else if(type == 2){
			data += "02";
		} else if(type == 3){
			data += "03";
		}
		dataLength += 4;
	}

	/**
	 * 回传音频文件 //TODO 形参待商议
	 * 
	 * @param option
	 *            B或S
	 * @param date
	 *            开始录音时间
	 */
	public void setAudioFile(String option, Date date) {

		data += "4303" + "36";
		if (option.equals("B")) {
			data += "42";
		} else if (option.equals("S")) {
			data += "53";
		}

		String time = DateUtil.format(date, DateUtil.sdFormat3);
		String[] s = time.split("-");
		data += numToHex16(Integer.parseInt(s[0])) + numToHex8(Integer.parseInt(s[1]))
				+ numToHex8(Integer.parseInt(s[2].substring(0, 2)));

		String tmp = s[2].substring(3, s[2].length());
		String[] split = tmp.split(":");
		data += numToHex8(Integer.parseInt(split[0])) + numToHex8(Integer.parseInt(split[1]))
				+ numToHex8(Integer.parseInt(split[2]));

		// 行政区域码，暂写死
		data += "061245140210220301";
		dataLength += 27;
	}

	/**
	 * 音频回传触发
	 * 
	 * @param ok
	 *            ture:启动 || false:关闭
	 */
	public void setAudioSwitch(boolean ok) {
		data += "4203" + "01";
		if (ok) {
			data += "01";
		} else {
			data += "02";
		}
		dataLength += 4;
	}

	/**
	 * 终端和服务器握手
	 * 
	 * @param ok
	 *            true:终端发送握手请求包 || false:服务器握手应签包
	 */
	public void setHandShake(boolean ok) {
		data += "4103" + "01";
		if (ok) {
			data += "01";
		} else {
			data += "02";
		}
		dataLength += 4;
	}

	/**
	 * 设置音频回传协议
	 * 
	 * @param protocol
	 *            UDP || TCP || 串口
	 */
	public void setAudioReceiveProtocol(String protocol) {
		data += "4003" + "01";
		if (protocol.equals("UDP")) {
			data += "01";
		} else if (protocol.equals("TCP")) {
			data += "02";
		} else if (protocol.equals("串口")) {
			data += "03";
		}
		dataLength += 4;
	}

	/**
	 * 设置默认网关
	 * 
	 * @param gateWay
	 */
	public void setGateWay(String gateWay) {

		data += "3703" + "04";
		String[] str = gateWay.split(".");
		for (String s : str) {
			data += numToHex8(Integer.parseInt(s));
		}
		dataLength += 10;
	}

	/**
	 * 设置子网掩码
	 * 
	 * @param mask
	 */
	public void setSubnetMask(String mask) {

		data += "3603" + "04";
		String[] str = mask.split(".");
		for (String s : str) {
			data += numToHex8(Integer.parseInt(s));
		}
		dataLength += 10;
	}

	/**
	 * 设置本机IP
	 * 
	 * @param ip
	 */
	public void setLocalHostIP(String ip) {
		data += "3503" + "04";
		String[] str = ip.split(".");
		for (String s : str) {
			data += numToHex8(Integer.parseInt(s));
		}
		dataLength += 10;
	}

	/**
	 * 设置网络模式
	 * 
	 * @param netMode
	 *            局域网 || 跨路由
	 */
	public void setNetMode(String netMode) {
		data += "3003" + "04";
		if (netMode.equals("局域网")) {
			data += "01";
		} else if (netMode.equals("跨路由")) {
			data += "02";
		}

	}

	/**
	 * 设置参数完后的执行方法
	 */
	public String getSendData() {
		String body = "10" + numToHex16(dataLength) + data;
		String crc = CRCUtil.getCRC(CRCUtil.hexToByte(body));
		return head + body + crc;
	}

	/**
	 * @Description 设置数字电视射频模式
	 * @Date 2019-01-29
	 * @Author LiLinFeng
	 * @param RadioMode
	 */
	public void setDigitalTelevisionRadioMode(String RadioMode) {
		String string = "0503" + "01";
		if (RadioMode.equals("DTMB")) {
			string += "00";
		} else if (RadioMode.equals("DVB-C")) {
			string += "01";
		}
		data += string;
		dataLength += 4;
	}

	/**
	 * @Description 设置数字电视射频频率，默认单位是MHz
	 * @Date 2019-01-29
	 * @Author LiLinFeng
	 * @param radioRate
	 */
	public void setDigitalTelevisionRadioRate(String radioRate) {
		String str = radioRate;
		String newStr = null;

		for (int i = 1; i <= 6 - radioRate.length(); i++) {
			str += "0";
		}
		newStr = str.substring(4, 6) + str.substring(2, 4) + str.substring(0, 2);
		data += "0603" + "03" + newStr;
		dataLength += 6;
	}

	/**
	 * @Description 设置QAM调制方式
	 * @Date 2019-01-29
	 * @Author LiLinFeng
	 * @param QMA
	 */
	public void setQAM(String QMA) {
		String newQMA = QMA;
		if (QMA.contains("QMA")) {
			newQMA = QMA.replace("QMA", "");
		}
		if (newQMA.equals("16")) {
			data += "0703" + "01" + 00;
		} else if (newQMA.equals("32")) {
			data += "0703" + "01" + 01;
		} else if (newQMA.equals("64")) {
			data += "0703" + "01" + 02;
		} else if (newQMA.equals("128")) {
			data += "0703" + "01" + 03;
		} else if (newQMA.equals("256")) {
			data += "0703" + "01" + 04;
		}
		dataLength += 4;
	}

	/**
	 * @Description 设置默认音量
	 * @Date 2019-01-29
	 * @Author LiLinFeng
	 * @param deviceVolume
	 */
	public void setDeviceVolume(String deviceVolume) {
		Integer volume = Integer.valueOf(deviceVolume);
		String HexToI = null;
		for (int i = 0; i <= 100; i++) {
			if (volume == i) {
				HexToI = numToHex8(i);
			}
		}
		data += "0803" + "01" + HexToI;
		dataLength += 4;
	}

	/**
	 * @Description 设置广播超时时间,单位秒(s)
	 * @Date 2019-01-29
	 * @Author LiLinFeng
	 * @param time
	 */
	public void setBroadcastTimeOut(String time) {
		data += "0903" + "01" + numToHex8(Integer.valueOf(time));
		dataLength += 4;
	}

	/**
	 * @Description 设置数据回传IP地址1
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param ip1
	 *            eg:10.177.3.211
	 */
	public void setDataReturnIPAddress1(String ip1) {
		String[] strs = ip1.split(".");
		String data1 = null;
		for (int i = 0; i < strs.length; i++) {
			String newIp = numToHex8(Integer.valueOf(strs[i]));
			data1 += newIp;
		}
		data += "1203" + "04" + data1;
		dataLength += 7;
	}

	/**
	 * @Description 设置数据回传端口1
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param port1
	 *            eg:8080
	 */
	public void setDataReturnIPPort1(String port1) {
		data += "1303" + "02" + littleStr(port1);
		dataLength += 5;
	}

	/**
	 * @Description 设置音频回传地址1
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param address1
	 *            eg:10.177.3.211
	 */
	public void setAudioReturnAddress1(String address1) {
		String[] strs = address1.split(".");
		String data1 = null;
		for (int i = 0; i < strs.length; i++) {
			String newIp = numToHex8(Integer.valueOf(strs[i]));
			data1 += newIp;
		}
		data += "1403" + "04" + data1;
		dataLength += 7;
	}

	/**
	 * @Description 设置音频回传端口1
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param port1
	 *            eg:8080
	 */
	public void setAudioReturnPort1(String port1) {
		data += "1503" + "02" + littleStr(port1);
		dataLength += 5;
	}

	/**
	 * @Description 设置数据回传IP地址2
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param ip2
	 *            eg:10.177.3.211
	 */
	public void setDataReturnIPAddress2(String ip2) {
		String[] strs = ip2.split(".");
		String data1 = null;
		for (int i = 0; i < strs.length; i++) {
			String newIp = numToHex8(Integer.valueOf(strs[i]));
			data1 += newIp;
		}
		data += "A203" + "04" + data1;
		dataLength += 7;
	}

	/**
	 * @Description 设置数据回传端口2
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param port2
	 *            eg:8080
	 */
	public void setDataReturnIPPort2(String port2) {
		data += "A303" + "02" + littleStr(port2);
		dataLength += 5;
	}

	/**
	 * @Description 设置音频回传地址2
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param address2
	 *            eg:10.177.3.211
	 */
	public void setAudioReturnAddress2(String address2) {
		String[] strs = address2.split(".");
		String data1 = null;
		for (int i = 0; i < strs.length; i++) {
			String newIp = numToHex8(Integer.valueOf(strs[i]));
			data1 += newIp;
		}

		data += "A403" + "04" + data1;
		dataLength += 7;
	}

	/**
	 * @Description 设置音频回传端口2
	 * @Date 2019-01-30
	 * @Author LiLinFeng
	 * @param port2
	 *            eg:8080
	 */
	public void setAudioReturnPort2(String port2) {
		data += "A503" + "02" + littleStr(port2);
		dataLength += 5;
	}

	/**
	 * @Description 设置逻辑区域码
	 * @Date 2019-01-31
	 * @Author LiLinFeng
	 * @param logicalAreaCode
	 */
	public void setLogicalAreaCode(String logicalAreaCode) {
		data += "2303" + "06" + logicalAreaCode;
		dataLength += 9;
	}

	/**
	 * 使用1字节就可以表示b
	 * @param b
	 * @return
	 */
	public static String numToHex8(int b) {
		return String.format("%02x", b);
	}

	/**
	 * 需要使用2字节表示b
	 * @param b
	 * @return
	 */
	public static String numToHex16(int b) {
		String str = String.format("%04x", b);
		return str.substring(2, 4) + str.substring(0, 2);
	}

	/**
	 * 小端模式转换（例如传进来为1206，转换成了0612）
	 * @param str
	 * @return
	 */
	public String littleStr(String str) {
		return str.substring(2, 4) + str.substring(0, 2);
	}

	public Boolean getHasWriteControl() {
		return hasWriteControl;
	}

	public void setHasWriteControl(Boolean hasWriteControl) {
		this.hasWriteControl = hasWriteControl;
	}

}
