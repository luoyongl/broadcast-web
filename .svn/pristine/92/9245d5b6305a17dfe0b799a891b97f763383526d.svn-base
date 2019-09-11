package cn.wtu.broadcast.openapi.vo.ebm;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "EBM")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMXmlModel{
	
	@XmlElement(name = "EBMVersion")
	private String ebmVersion = StringUtils.EMPTY;
	
	@XmlElement(name = "EBMID")
	private String ebmID = StringUtils.EMPTY;
	
	@XmlElement(name = "RelatedInfo")
	private EBDEBMRelatedInfoXmlModel relatedInfo;
	
	@XmlElement(name = "MsgBasicInfo")
	private EBDEBMMsgBasicInfoXmlModel msgBasicInfo;

	@XmlElement(name = "MsgContent")
	private EBDEBMMsgContentXmlModel msgContent;
	
	@XmlElement(name = "Dispatch")
	private EBDEBMDispatchXmlModel dispatch;

	@XmlTransient
	public EBDEBMMsgBasicInfoXmlModel getMsgBasicInfo() {
		return msgBasicInfo;
	}

	public void setMsgBasicInfo(EBDEBMMsgBasicInfoXmlModel msgBasicInfo) {
		this.msgBasicInfo = msgBasicInfo;
	}

	@XmlTransient
	public EBDEBMMsgContentXmlModel getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(EBDEBMMsgContentXmlModel msgContent) {
		this.msgContent = msgContent;
	}

	@XmlTransient
	public EBDEBMDispatchXmlModel getDispatch() {
		return dispatch;
	}

	public void setDispatch(EBDEBMDispatchXmlModel dispatch) {
		this.dispatch = dispatch;
	}

	@XmlTransient
	public String getEbmVersion() {
		return ebmVersion;
	}

	public void setEbmVersion(String ebmVersion) {
		this.ebmVersion = ebmVersion;
	}

	@XmlTransient
	public String getEbmID() {
		return ebmID;
	}

	public void setEbmID(String ebmID) {
		this.ebmID = ebmID;
	}

	@XmlTransient
	public EBDEBMRelatedInfoXmlModel getRelatedInfo() {
		return relatedInfo;
	}

	public void setRelatedInfo(EBDEBMRelatedInfoXmlModel relatedInfo) {
		this.relatedInfo = relatedInfo;
	}

}