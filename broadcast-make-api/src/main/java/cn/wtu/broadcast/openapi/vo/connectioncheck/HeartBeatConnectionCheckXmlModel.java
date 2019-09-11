package cn.wtu.broadcast.openapi.vo.connectioncheck;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cn.wtu.broadcast.openapi.common.JaxbDateSerializer;
import cn.wtu.broadcast.openapi.common.XmlDefaultDate;

@XmlRootElement(name = "ConnectionCheck")
@XmlAccessorType(XmlAccessType.FIELD)
public class HeartBeatConnectionCheckXmlModel {

	@XmlElement(name = "RptTime")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date rptTime = XmlDefaultDate.getDefaultDate();

	@XmlTransient
	public Date getRptTime() {
		return rptTime;
	}

	public void setRptTime(Date rptTime) {
		this.rptTime = rptTime;
	}
}
