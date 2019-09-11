package cn.wtu.broadcast.openapi.vo.ebm;
 
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.StringUtils;

import cn.wtu.broadcast.openapi.common.JaxbDateSerializer;
import cn.wtu.broadcast.openapi.common.XmlDefaultDate;
 
@XmlRootElement(name = "MsgBasicInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMMsgBasicInfoXmlModel{
	@XmlElement(name = "MsgType")
	private String msgType = StringUtils.EMPTY;
	
	@XmlElement(name = "SenderName")
	private String senderName = StringUtils.EMPTY;
	
	@XmlElement(name = "SenderCode")
	private String senderCode = StringUtils.EMPTY;
	
	@XmlElement(name = "SendTime")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date sendTime = XmlDefaultDate.getDefaultDate();
	
	@XmlElement(name = "EventType")
	private String eventType = StringUtils.EMPTY;
	
	@XmlElement(name = "Severity")
	private String severity = StringUtils.EMPTY;
	
	@XmlElement(name = "StartTime")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date startTime = XmlDefaultDate.getDefaultDate();
	
	@XmlElement(name = "EndTime")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date endTime = XmlDefaultDate.getDefaultDate();
	
	@XmlTransient
	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@XmlTransient
	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	@XmlTransient
	public String getSenderCode() {
		return senderCode;
	}
	
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	
	@XmlTransient
	public Date getSendTime() {
		return sendTime;
	}
	
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	@XmlTransient
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	@XmlTransient
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	@XmlTransient
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@XmlTransient
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}