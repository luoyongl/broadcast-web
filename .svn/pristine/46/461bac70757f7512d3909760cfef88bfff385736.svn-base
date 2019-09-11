package cn.wtu.broadcast.openapi.vo.ebm;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "Dispatch")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMDispatchXmlModel{
	@XmlElement(name = "LanguageCode")
	private String languageCode = StringUtils.EMPTY;
	
	@XmlElement(name = "EBRPS")
	private EBDEBMDispatchEbrPSXmlModel ebrPS;
	
	@XmlElement(name = "EBRTS")
	private EBDEBMDispatchEbrTSXmlModel ebrTS;
	
	@XmlElement(name = "EBRAS")
	private EBDEBMDispatchEbrASXmlModel ebrAS;
	
	@XmlElement(name = "EBRBS")
	private EBDEBMDispatchEbrBSXmlModel ebrBS;

	@XmlTransient
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@XmlTransient
	public EBDEBMDispatchEbrPSXmlModel getEbrPS() {
		return ebrPS;
	}

	public void setEbrPS(EBDEBMDispatchEbrPSXmlModel ebrPS) {
		this.ebrPS = ebrPS;
	}

	@XmlTransient
	public EBDEBMDispatchEbrTSXmlModel getEbrTS() {
		return ebrTS;
	}

	public void setEbrTS(EBDEBMDispatchEbrTSXmlModel ebrTS) {
		this.ebrTS = ebrTS;
	}

	@XmlTransient
	public EBDEBMDispatchEbrASXmlModel getEbrAS() {
		return ebrAS;
	}

	public void setEbrAS(EBDEBMDispatchEbrASXmlModel ebrAS) {
		this.ebrAS = ebrAS;
	}

	@XmlTransient
	public EBDEBMDispatchEbrBSXmlModel getEbrBS() {
		return ebrBS;
	}

	public void setEbrBS(EBDEBMDispatchEbrBSXmlModel ebrBS) {
		this.ebrBS = ebrBS;
	}
	
	
}