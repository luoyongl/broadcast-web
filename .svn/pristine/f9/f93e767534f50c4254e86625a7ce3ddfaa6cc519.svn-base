package cn.wtu.broadcast.openapi.vo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-24 9:57
 */
public class ReceiveProperties {

	private static Logger logger = LoggerFactory.getLogger(ReceiveProperties.class);

	// 回传码
	private String recevieStr = null;

	// 帧头
	private String head = null;

	public ReceiveProperties(String recevieStr) {
		try {
			this.recevieStr = recevieStr;
			if (!recevieStr.substring(0, 2).equals("25")) {
				throw new Exception("响应包头标记错误");
			}
			this.head = recevieStr.substring(2, 36);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}
	
	/**
	 * 设备资源编码
	 * 
	 * @return
	 */
	public String getDeviceSourceCode() {
		return head.substring(0, 18);
	}

	public String strToSmall(String str) {
		return str.substring(2, 4) + str.substring(0, 2);
	}

	/**
	 * 得到资源类型 0612
	 * 
	 * @return
	 */
	public String getSourceType() {
		return strToSmall(head.substring(0, 4));
	}

	/**
	 * 得到行政区域
	 * 
	 * @return
	 */
	public String getAdministrativeArea() {
		return head.substring(4, 16);
	}

	/**
	 * 得到资源设备编号
	 * 
	 * @return
	 */
	public String getSourceDeviceNumber() {
		return head.substring(16, 18);
	}

	/**
	 * 得到厂家编号
	 * 
	 * @return
	 */
	public String getVenderPid() {
		return strToSmall(head.substring(18, 22));
	}

	/**
	 * 得到硬件版本编号
	 * 
	 * @return
	 */
	public String getHardVersion() {
		String bigVersion = head.substring(24, 26);
		if (bigVersion.charAt(0) == '0') {
			bigVersion = bigVersion.substring(1, 2);
		}

		return bigVersion + "." + head.substring(22, 24);
	}

	/**
	 * 得到软件版本编号
	 * 
	 * @return
	 */
	public String getSoftVersion() {
		String bigVersion = head.substring(28, 30);
		if (bigVersion.charAt(0) == '0') {
			bigVersion = bigVersion.substring(1, 2);
		}

		return bigVersion + "." + head.substring(26, 28);
	}

	/**
	 * 得到协议版本号
	 * 
	 * @return
	 */
	public String getProtocolVersion() {
		return head.substring(30, 32);
	}

	/**
	 * 得到功能码
	 * 
	 * @return
	 */
	public String getFunction() {
		return recevieStr.substring(36, 38);
	}

	/***
	 * 得到数据长度
	 * 
	 * @return
	 */
	public Integer getDataLength() {
		return Integer.parseInt(strToSmall(recevieStr.substring(38, 42)), 16) * 2;
	}

	/**
	 * 得到数据
	 * 
	 * @return
	 */
	public String getData() {
		return recevieStr.substring(42, 42 + getDataLength());
	}

	/**
	 * 得到CRC校验码
	 * 
	 * @return
	 */
	public String getCRC() {
		return null;
	}

	public Map<String, String> analysisData() {
		// 数据内容
		String data = getData();

		Map<String, String> dataMap = new HashMap<>();
		int len = 0;
		for (int i = 0; i + 6 <= data.length(); i += len + 6) {
			len = getLength(data.substring(i + 4, i + 6));
			dataMap.put(data.substring(i, i + 4), data.substring(i + 6, i + 6 + len));
		}
		return dataMap;
	}

	public Integer getLength(String str) {
		return Integer.parseInt(str, 16) * 2;
	}
}