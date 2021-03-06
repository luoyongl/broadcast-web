package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
import java.util.Date;

public class IpVideoVO implements Serializable {

	private static final long serialVersionUID = 2382532033052415768L;

	private String fId; // 广播id

	private String broadCastType = "05"; // 日常

	private String eventLevel = "04"; // 一般

	private String eventType = "3130303030";

	private Byte volume = 64;

	// 下面这部分是辅助数据数量
	private String count = "01";

	private String type = "04"; // 辅助数据类型 辅助数据类型1:文本 2:音频；3:图片；4:视频； 5: 设备流类型；

	private String len;

	private String protocolType = "04"; // 标识HTTP

	private String audioCodeType = "02"; // 01标识MP3 02标识视频 MP4

	private String audioPid = "0000";

	private String audioURL; // 辅助数据音频地址

	private String reserveInfo = "000000000000000000";
	//

	private String serviceIp;

	private String servicePort;

	private Date EBM_start_time;

	/*
	 * 省级平台接收专用
	 */
	private Date EBMEndTime;

	/*
	 * 音频url 网络路径
	 */
	private String broadcastAudioUrl; // 广播表音频地址

	/*
	 * 县平台证书私钥 32位 从数据库中查询出来的 lxg 2019-02-21
	 */
	private String privateKey;

	/*
	 * 平台资源编码 对应 配置表 t_system_configuration的资源编码
	 */
	private String platformResourceCode;

	/*
	 * 播发区域 用于接收 从广播数据表传来的 区域id 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private String EBM_resource_codes;

	private String ipPlayPort;

	/**
	 * 时区设置 是local还是UTC 0-local 1-UTC lxg 2019-04-04
	 */
	private String timeZoneSet;

	public String getTimeZoneSet() {
		return timeZoneSet;
	}

	public void setTimeZoneSet(String timeZoneSet) {
		this.timeZoneSet = timeZoneSet;
	}

	public String getIpPlayPort() {
		return ipPlayPort;
	}

	public void setIpPlayPort(String ipPlayPort) {
		this.ipPlayPort = ipPlayPort;
	}

	public String getAudioPid() {
		return audioPid;
	}

	public void setAudioPid(String audioPid) {
		this.audioPid = audioPid;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLen() {
		return len;
	}

	public void setLen(String len) {
		this.len = len;
	}

	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getAudioCodeType() {
		return audioCodeType;
	}

	public void setAudioCodeType(String audioCodeType) {
		this.audioCodeType = audioCodeType;
	}

	public String getReserveInfo() {
		return reserveInfo;
	}

	public void setReserveInfo(String reserveInfo) {
		this.reserveInfo = reserveInfo;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPlatformResourceCode() {
		return platformResourceCode;
	}

	public void setPlatformResourceCode(String platformResourceCode) {
		this.platformResourceCode = platformResourceCode;
	}

	public String getEBM_resource_codes() {
		return EBM_resource_codes;
	}

	public void setEBM_resource_codes(String eBM_resource_codes) {
		EBM_resource_codes = eBM_resource_codes;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getBroadCastType() {
		return broadCastType;
	}

	public void setBroadCastType(String broadCastType) {
		this.broadCastType = broadCastType;
	}

	public String getEventLevel() {
		return eventLevel;
	}

	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}

	public String getAudioURL() {
		return audioURL;
	}

	public void setAudioURL(String audioUrl) {
		this.audioURL = audioUrl;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Byte getVolume() {
		return volume;
	}

	public void setVolume(Byte volume) {
		this.volume = volume;
	}

	public String getServiceIp() {
		return serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public Date getEBM_start_time() {
		return EBM_start_time;
	}

	public void setEBM_start_time(Date eBM_start_time) {
		EBM_start_time = eBM_start_time;
	}

	public String getBroadcastAudioUrl() {
		return broadcastAudioUrl;
	}

	public void setBroadcastAudioUrl(String broadcastAudioUrl) {
		this.broadcastAudioUrl = broadcastAudioUrl;
	}

	public Date getEBMEndTime() {
		return EBMEndTime;
	}

	public void setEBMEndTime(Date eBMEndTime) {
		EBMEndTime = eBMEndTime;
	}
}
