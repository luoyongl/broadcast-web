package cn.wtu.broadcast.openapi.vo.ebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;

@XmlRootElement(name = "EBRBS")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMDispatchEbrBSXmlModel {

	@XmlElement(name = "BrdSysType")
	private String brdSysType = StringUtils.EMPTY;

	@XmlElement(name = "BrdSysInfo")
	private String brdSysInfo = StringUtils.EMPTY;

	@XmlTransient
	public String getBrdSysType() {
		return brdSysType;
	}

	public void setBrdSysType(String brdSysType) {
		this.brdSysType = brdSysType;
	}

	@XmlTransient
	public String getBrdSysInfo() {
		return brdSysInfo;
	}

	public void setBrdSysInfo(String brdSysInfo) {
		this.brdSysInfo = brdSysInfo;
	}
	
}
