package cn.wtu.broadcast.openapi.vo.ebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;

@XmlRootElement(name = "Auxiliary")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMMsgContentAuxiliaryXmlModel {

	@XmlElement(name = "AuxiliaryType")
	private String auxiliaryType = StringUtils.EMPTY;
	
	@XmlElement(name = "AuxiliaryDesc")
	private String auxiliaryDesc = StringUtils.EMPTY;
	
	@XmlElement(name = "Size")
	private String size = StringUtils.EMPTY;
	
	@XmlElement(name = "Digest")
	private String digest = StringUtils.EMPTY;

	@XmlTransient
	public String getAuxiliaryType() {
		return auxiliaryType;
	}

	public void setAuxiliaryType(String auxiliaryType) {
		this.auxiliaryType = auxiliaryType;
	}

	@XmlTransient
	public String getAuxiliaryDesc() {
		return auxiliaryDesc;
	}

	public void setAuxiliaryDesc(String auxiliaryDesc) {
		this.auxiliaryDesc = auxiliaryDesc;
	}

	@XmlTransient
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@XmlTransient
	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

}
