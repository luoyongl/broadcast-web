package cn.wtu.broadcast.openapi.vo.common;
 
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.StringUtils;

import cn.wtu.broadcast.openapi.common.JaxbDateSerializer;
import cn.wtu.broadcast.openapi.common.XmlDefaultDate;

public class CommonEBDXmlModel {
	@XmlElement(name = "EBDVersion")
	private String ebdVersion = StringUtils.EMPTY;
	
	@XmlElement(name = "EBDID")
	private String ebdID = StringUtils.EMPTY;
	
	@XmlElement(name = "EBDType")
	private String ebdType = StringUtils.EMPTY;
	
	@XmlElement(name = "SRC")
	private CommonSRCXmlModel srcXmlModel;
	
	@XmlElement(name = "DEST")
	private CommonDESTXmlModel dest;
	
	@XmlElement(name = "EBDTime")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date ebdTime = XmlDefaultDate.getDefaultDate();
	
	@XmlElement(name = "RelatedEBD")
	private CommonDESTXmlModel relatedEBD;

	@XmlTransient
	public String getEbdVersion() {
		return ebdVersion;
	}

	public void setEbdVersion(String ebdVersion) {
		this.ebdVersion = ebdVersion;
	}

	@XmlTransient
	public String getEbdID() {
		return ebdID;
	}

	public void setEbdID(String ebdID) {
		this.ebdID = ebdID;
	}

	@XmlTransient
	public String getEbdType() {
		return ebdType;
	}

	public void setEbdType(String ebdType) {
		this.ebdType = ebdType;
	}

	@XmlTransient
	public CommonSRCXmlModel getSrcXmlModel() {
		return srcXmlModel;
	}

	public void setSrcXmlModel(CommonSRCXmlModel srcXmlModel) {
		this.srcXmlModel = srcXmlModel;
	}

	@XmlTransient
	public CommonDESTXmlModel getDest() {
		return dest;
	}

	public void setDest(CommonDESTXmlModel dest) {
		this.dest = dest;
	}

	@XmlTransient
	public Date getEbdTime() {
		return ebdTime;
	}

	public void setEbdTime(Date ebdTime) {
		this.ebdTime = ebdTime;
	}

	@XmlTransient
	public CommonDESTXmlModel getRelatedEBD() {
		return relatedEBD;
	}

	public void setRelatedEBD(CommonDESTXmlModel relatedEBD) {
		this.relatedEBD = relatedEBD;
	}
}