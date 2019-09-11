package cn.wtu.broadcast.openapi.vo.common;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
 
@XmlRootElement(name = "SRC")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonSRCXmlModel {
	@XmlElement(name = "EBRID")
	private String ebrID = StringUtils.EMPTY;
	
	@XmlElement(name = "URL")
	private String url = StringUtils.EMPTY;

	@XmlTransient
	public String getEbrID() {
		return ebrID;
	}

	public void setEbrID(String ebrID) {
		this.ebrID = ebrID;
	}

	@XmlTransient
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}