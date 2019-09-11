package cn.wtu.broadcast.openapi.vo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import cn.wtu.broadcast.parent.utils.CRCUtil;

/**
 * @description: 状态回传测试参数
 * @author: AYY
 * @date: 2019-01-25 13:56
 */
public class ReceiveStateVO {
	
	public static Logger logger = LoggerFactory.getLogger(ReceiveStateVO.class);

	// 持有receiveProperties类的引用
	private ReceiveProperties receiveProperties = null;

	// 回传时间
	private Date time;

	// 物理码
	private String physicalNumber;

	// 逻辑码
	private String logicNumber;

	// 回传模式
	private String receiveMode;

	// 网路模式
	private String netMode;

	// 硬件版本号
	private String hardVersion;

	// 软件版本号
	private String softVersion;

	// 工作电压
	private String workVoltage = "220V";

	// 功放电流
	private String current;

	// 广播状态
	private String broadcastState;

	// 设备音量
	private String deviceVolume;

	// 数字电视射频模式
	private String digitalTelevisionRadioMode;

	// 数字电视射频频率
	private String digitalTelevisionRadioRate;

	// QAM方式
	private String QAM;

	// 数字电视信号质量
	private String digitalTelevisionSignalQuality;

	// 数字电视信号强度
	private String digitalTelevisionSignalStrength;

	// 调频信号接受频率列表
	private List<String> signalRateList;

	// 调频信号强度
	private List<String> signalStrengthList;

	// 经度
	private String longitude;

	// 纬度
	private String latitude;

	// 设备资源码
	private String deviceSourceNumber;

	// 设备工作状态
	private Byte deviceState;

	public ReceiveStateVO(String recevieStr) {
		receiveProperties = new ReceiveProperties(recevieStr);
		setData();
	}

	public void setData() {
		setHardVersion(receiveProperties.getHardVersion());
		setSoftVersion(receiveProperties.getSoftVersion());
		setTime(new Date());
		setDeviceSourceNumber(receiveProperties.getSourceType());

		Map<String, String> dataMap = receiveProperties.analysisData();

		if (dataMap == null) {
			return;
		}
		StringBuffer result = new StringBuffer();
		dataMap.forEach((key, val) -> {
			result.append("{指令key:" + key + " 值value:" + val + "}");
			if (key.equals("0103")) {
				List<String> signalRateList = new ArrayList<>();
				for (int i = 2; i + 6 <= val.length(); i += 6) {
					Double rate = hexToInteger(receiveProperties.strToSmall(val.substring(i + 2, i + 6))) / 100.0;
					signalRateList.add(rate + "MHZ");
				}
				this.setSignalRateList(signalRateList);
			} else if (key.equals("0203")) {
				List<String> signalStrengthList = new ArrayList<>();
				for (int i = 2; i + 4 <= val.length(); i += 4) {
					Integer strength = hexToInteger(val.substring(i + 2, i + 4));
					signalStrengthList.add(strength + "dBuv");
				}
				setSignalStrengthList(signalStrengthList);
			} else if (key.equals("2503")) {
				if (val.substring(0, 1).equals("8")) {
					setDeviceState(Byte.valueOf(String.valueOf(DeviceStateEnum.broadcasting.getCode())));
				} else if (val.substring(0, 1).equals("0")) {
					setDeviceState(Byte.valueOf(String.valueOf(DeviceStateEnum.online.getCode())));
				}
			} else if(key.equals("4903")){
                if(val.equals("01")){
                	setDeviceState(Byte.valueOf(String.valueOf(DeviceStateEnum.malfunction.getCode())));
                } else if (val.equals("02")) {
					setDeviceState(Byte.valueOf(String.valueOf(DeviceStateEnum.online.getCode())));
				}
            } else if (key.equals("2903")) {
				if (val.equals("01")) {
					setReceiveMode("移动通信网络");
				} else if (val.equals("02")) {
					setReceiveMode("有线IP网络");
				}
			} else if (key.equals("3003")) {
				if (val.equals("01")) {
					setNetMode("局域网");
				} else if (val.equals("02")) {
					setNetMode("跨路由");
				}
			} else if (key.equals("2303")) {
				setLogicNumber(val);
			} else if (key.equals("2403")) {
				setPhysicalNumber(val);
			} else if (key.equals("3403")) {
				float v = caculateFloat(val);
				setCurrent(v + "A");
			} else if (key.equals("0603")) {
				Double current = Integer.parseInt(val.substring(4, 6) + val.substring(2, 4) + val.substring(0, 2))
						/ 1000.00;
				setDigitalTelevisionRadioRate(current + "MHZ");
			} else if (key.equals("0303")) {// 广播状态

				String source = val.substring(0, 1);
				String level = val.substring(1, 2);
				String sourceVal = "";
				String levelVal = "";
				if (source.equals("1")) {
					sourceVal = "省";
				} else if (source.equals("2")) {
					sourceVal = "市";
				} else if (source.equals("3")) {
					sourceVal = "县";
				} else if (source.equals("4")) {
					sourceVal = "乡或镇";
				} else if (source.equals("5")) {
					sourceVal = "行政村";
				}

				if (level.equals("1")) {
					levelVal = "一级";
				} else if (level.equals("2")) {
					levelVal = "二级";
				} else if (level.equals("3")) {
					levelVal = "三级";
				} else if (level.equals("4")) {
					levelVal = "四级";
				}

				setBroadcastState(sourceVal + "," + levelVal);
			} else if (key.equals("0803")) {
				setDeviceVolume(hexToInteger(val).toString());
			} else if (key.equals("0503")) {
				if (val.equals("00")) {
					setDigitalTelevisionRadioMode("DTMB");
				} else if (val.equals("01")) {
					setDigitalTelevisionRadioMode("DVB-C");
				}
			} else if (key.equals("0703")) {
				if (val.equals("00")) {
					setQAM("16QAM");
				} else if (val.equals("01")) {
					setQAM("32QAM");
				} else if (val.equals("02")) {
					setQAM("64QAM");
				} else if (val.equals("03")) {
					setQAM("128QAM");
				} else if (val.equals("04")) {
					setQAM("256QAM");
				}
			} else if (key.equals("1003")) {
				setDigitalTelevisionSignalQuality(hexToInteger(val) / 255 + "%");
			} else if (key.equals("1103")) {
				setDigitalTelevisionSignalStrength(hexToInteger(val) + "dBuv");
			} else if (key.equals("2703")) {
				float v = caculateFloat(val);
				setLongitude(v + "");
			} else if (key.equals("2803")) {
				float v = caculateFloat(val);
				setLongitude(v + "");
			} else if (key.equals("1703") || key.equals("3803") || key.equals("4203")) {
				logger.info("音频回传测试指令进来了");
			}
		});
		logger.info("回传指令和值为：" + result.toString());
	}

	public float caculateFloat(String val) {
		String str = val.substring(6, 8) + val.substring(4, 6) + val.substring(2, 4) + val.substring(0, 2);
		byte[] bytes = CRCUtil.hexToByte(str);
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
		float f = 0;
		try {
			f = dis.readFloat();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public Integer hexToInteger(String str) {
		return Integer.parseInt(str, 16);
	}

	public ReceiveProperties getReceiveProperties() {
		return receiveProperties;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPhysicalNumber() {
		return physicalNumber;
	}

	public void setPhysicalNumber(String physicalNumber) {
		this.physicalNumber = physicalNumber;
	}

	public String getLogicNumber() {
		return logicNumber;
	}

	public void setLogicNumber(String logicNumber) {
		this.logicNumber = logicNumber;
	}

	public String getReceiveMode() {
		return receiveMode;
	}

	public void setReceiveMode(String receiveMode) {
		this.receiveMode = receiveMode;
	}

	public String getNetMode() {
		return netMode;
	}

	public void setNetMode(String netMode) {
		this.netMode = netMode;
	}

	public String getHardVersion() {
		return hardVersion;
	}

	public void setHardVersion(String hardVersion) {
		this.hardVersion = hardVersion;
	}

	public String getSoftVersion() {
		return softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}

	public String getWorkVoltage() {
		return workVoltage;
	}

	public void setWorkVoltage(String workVoltage) {
		this.workVoltage = workVoltage;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getBroadcastState() {
		return broadcastState;
	}

	public void setBroadcastState(String broadcastState) {
		this.broadcastState = broadcastState;
	}

	public String getDeviceVolume() {
		return deviceVolume;
	}

	public void setDeviceVolume(String deviceVolume) {
		this.deviceVolume = deviceVolume;
	}

	public String getDigitalTelevisionRadioMode() {
		return digitalTelevisionRadioMode;
	}

	public void setDigitalTelevisionRadioMode(String digitalTelevisionRadioMode) {
		this.digitalTelevisionRadioMode = digitalTelevisionRadioMode;
	}

	public String getDigitalTelevisionRadioRate() {
		return digitalTelevisionRadioRate;
	}

	public void setDigitalTelevisionRadioRate(String digitalTelevisionRadioRate) {
		this.digitalTelevisionRadioRate = digitalTelevisionRadioRate;
	}

	public String getQAM() {
		return QAM;
	}

	public void setQAM(String QAM) {
		this.QAM = QAM;
	}

	public String getDigitalTelevisionSignalQuality() {
		return digitalTelevisionSignalQuality;
	}

	public void setDigitalTelevisionSignalQuality(String digitalTelevisionSignalQuality) {
		this.digitalTelevisionSignalQuality = digitalTelevisionSignalQuality;
	}

	public String getDigitalTelevisionSignalStrength() {
		return digitalTelevisionSignalStrength;
	}

	public void setDigitalTelevisionSignalStrength(String digitalTelevisionSignalStrength) {
		this.digitalTelevisionSignalStrength = digitalTelevisionSignalStrength;
	}

	public List<String> getSignalRateList() {
		return signalRateList;
	}

	public void setSignalRateList(List<String> signalRateList) {
		this.signalRateList = signalRateList;
	}

	public List<String> getSignalStrengthList() {
		return signalStrengthList;
	}

	public void setSignalStrengthList(List<String> signalStrengthList) {
		this.signalStrengthList = signalStrengthList;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getDeviceSourceNumber() {
		return deviceSourceNumber;
	}

	public void setDeviceSourceNumber(String deviceSourceNumber) {
		this.deviceSourceNumber = deviceSourceNumber;
	}

	public Byte getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(Byte deviceState) {
		this.deviceState = deviceState;
	}
}
