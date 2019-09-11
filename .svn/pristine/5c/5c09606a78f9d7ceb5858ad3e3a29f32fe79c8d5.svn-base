package cn.wtu.broadcast.openapi.vo.common;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "RelatedEBD")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonRelatedEBDXmlModel {
	@XmlElement(name = "EBDID")
	private String ebdID = StringUtils.EMPTY;

	@XmlTransient
	public String getEbdID() {
		return ebdID;
	}

	public void setEbdID(String ebdID) {
		this.ebdID = ebdID;
	}	
}