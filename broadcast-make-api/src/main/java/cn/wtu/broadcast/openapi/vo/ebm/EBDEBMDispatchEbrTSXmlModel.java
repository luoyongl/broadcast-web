package cn.wtu.broadcast.openapi.vo.ebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;

@XmlRootElement(name = "EBRTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class EBDEBMDispatchEbrTSXmlModel {

	@XmlElement(name = "EBRID")
	private String ebrID = StringUtils.EMPTY;

	@XmlTransient
	public String getEbrID() {
		return ebrID;
	}

	public void setEbrID(String ebrID) {
		this.ebrID = ebrID;
	}
}
