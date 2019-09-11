package cn.wtu.broadcast.openapi.vo.ebm;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "MsgContent")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMMsgContentXmlModel{
	@XmlElement(name = "LanguageCode")
	private String languageCode = StringUtils.EMPTY;
	
	@XmlElement(name = "MsgTitle")
	private String msgTitle = StringUtils.EMPTY;
	
	@XmlElement(name = "MsgDesc")
	private String msgDesc = StringUtils.EMPTY;
	
	@XmlElement(name = "AreaCode")
	private String areaCode = StringUtils.EMPTY;
	
	@XmlElement(name = "ProgramNum")
	private String programNum = StringUtils.EMPTY;
	
	@XmlElement(name = "Auxiliary")
	private EBDEBMMsgContentAuxiliaryXmlModel auxiliary;

	@XmlTransient
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@XmlTransient
	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@XmlTransient
	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	@XmlTransient
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@XmlTransient
	public String getProgramNum() {
		return programNum;
	}

	public void setProgramNum(String programNum) {
		this.programNum = programNum;
	}

	@XmlTransient
	public EBDEBMMsgContentAuxiliaryXmlModel getAuxiliary() {
		return auxiliary;
	}

	public void setAuxiliary(EBDEBMMsgContentAuxiliaryXmlModel auxiliary) {
		this.auxiliary = auxiliary;
	}

	
}