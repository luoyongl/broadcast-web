package cn.wtu.broadcast.parent.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class IpVO  implements Serializable {

	private static final long serialVersionUID = 5704556028483087032L;

	private String fId; //广播id
	
	private String broadCastType;
	
	private String eventLevel;
	
	private String eventType;
	
	private Byte volume;
	
	//下面这部分是辅助数据数量
	private String count = "01";
	
	private String type= "02";	//辅助数据类型 辅助数据类型1:文本	2:音频；3:图片；4:视频； 5: 设备流类型；
	
	private String len;
	
	private String protocolType="04"; //标识HTTP
	
	private String protocolType2="01"; //标识RTSP
	
	private String audioCodeType="01";  //01标识MP3
	
	private String audioPid;
	
	private String audioURL;		//辅助数据音频地址

	private String reserveInfo="000000000000000000";
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
	private String broadcastAudioUrl;	//广播表音频地址

	/*
	 * 文本转语音url 网络路径 定时广播时 textToAudioUrl=""; 需要这样吗 不需要 会自动初始化
	 */
	private String textToAudioUrl;
	
	/*
	 * 县平台证书私钥   32位
	 * 从数据库中查询出来的
	 * lxg  2019-02-21
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
	
	private String deviceResourceCode;

	/*
	 * 播发区域 区域编码的list形式 对应
	 * 广播数据表b_broadcast_data和b_broadcast_timing的f_broadcast_area
	 */
	private List<String> resourceCodeList;
	
	private String ipPlayPort;
	
	private String broadcastTomcatPath; 
	
	/**
	 * 时区设置
	 * 是local还是UTC
	 * 0-local  1-UTC
	 * lxg  2019-04-04
	 */
	private String timeZoneSet;
	
	/**
	 * 协议设置
	 * 是rtsp还是http
	 * 0-http  1-rtsp
	 * lxg  2019-04-04
	 */
	private String ipProtocalSet;
	
	/**
	 * NULL: IP播发   0:字幕 1：图片  2：视频 3:IP话筒
	 */
	private Integer playType;
	
	/**
	 * 用于图文发布处理
	 */
	private IpPictureVO ipPictureVO;
	
	/**
	 * 用于视频发布处理
	 */
	private IpVideoVO ipVideoVO;
	
	/**
	 * 用于字幕发布处理
	 */
	private IpTextVO ipTextVO;
	
	/**
	 * 存放广播顺序码
	 */
	private String orderId;
	
	private String fProgramPass;
	
	private String ipMikeTSport;
	
	public String getIpMikeTSport() {
		return ipMikeTSport;
	}
	public void setIpMikeTSport(String ipMikeTSport) {
		this.ipMikeTSport = ipMikeTSport;
	}
	public String getIpProtocalSet() {
		return ipProtocalSet;
	}
	public void setIpProtocalSet(String ipProtocalSet) {
		this.ipProtocalSet = ipProtocalSet;
	}
	public String getfProgramPass() {
		return fProgramPass;
	}
	public void setfProgramPass(String fProgramPass) {
		this.fProgramPass = fProgramPass;
	}
	public String getProtocolType2() {
		return protocolType2;
	}
	public void setProtocolType2(String protocolType2) {
		this.protocolType2 = protocolType2;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public IpVideoVO getIpVideoVO() {
		return ipVideoVO;
	}
	public void setIpVideoVO(IpVideoVO ipVideoVO) {
		this.ipVideoVO = ipVideoVO;
	}
	public IpTextVO getIpTextVO() {
		return ipTextVO;
	}
	public void setIpTextVO(IpTextVO ipTextVO) {
		this.ipTextVO = ipTextVO;
	}
	public String getDeviceResourceCode() {
		return deviceResourceCode;
	}
	public void setDeviceResourceCode(String deviceResourceCode) {
		this.deviceResourceCode = deviceResourceCode;
	}
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

	public List<String> getResourceCodeList() {
		return resourceCodeList;
	}

	public void setResourceCodeList(List<String> resourceCodeList) {
		this.resourceCodeList = resourceCodeList;
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

	public String getTextToAudioUrl() {
		return textToAudioUrl;
	}

	public void setTextToAudioUrl(String textToAudioUrl) {
		this.textToAudioUrl = textToAudioUrl;
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
	public String getBroadcastTomcatPath() {
		return broadcastTomcatPath;
	}
	public void setBroadcastTomcatPath(String broadcastTomcatPath) {
		this.broadcastTomcatPath = broadcastTomcatPath;
	}
	public IpPictureVO getIpPictureVO() {
		return ipPictureVO;
	}
	public void setIpPictureVO(IpPictureVO ipPictureVO) {
		this.ipPictureVO = ipPictureVO;
	}
	public Integer getPlayType() {
		return playType;
	}
	public void setPlayType(Integer playType) {
		this.playType = playType;
	}
}
