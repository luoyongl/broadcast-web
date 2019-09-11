package cn.wtu.broadcast.openapi.vo.ebm;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "RelatedInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMRelatedInfoXmlModel{
	
	@XmlElement(name = "EBIID")
	private String ebiID = StringUtils.EMPTY;
	
	@XmlElement(name = "EBMID")
	private String ebmID = StringUtils.EMPTY;

	@XmlTransient
	public String getEbiID() {
		return ebiID;
	}

	public void setEbiID(String ebiID) {
		this.ebiID = ebiID;
	}

	@XmlTransient
	public String getEbmID() {
		return ebmID;
	}

	public void setEbmID(String ebmID) {
		this.ebmID = ebmID;
	}	
	
}