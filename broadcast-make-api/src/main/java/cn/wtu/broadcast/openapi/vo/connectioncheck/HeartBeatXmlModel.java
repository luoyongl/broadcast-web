package cn.wtu.broadcast.openapi.vo.connectioncheck;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import cn.wtu.broadcast.openapi.vo.common.CommonEBDXmlModel;
 
@XmlRootElement(name = "EBD")
public class HeartBeatXmlModel extends CommonEBDXmlModel{
	@XmlElement(name = "ConnectionCheck")
	private HeartBeatConnectionCheckXmlModel connectionCheck;

	@XmlTransient
	public HeartBeatConnectionCheckXmlModel getConnectionCheck() {
		return connectionCheck;
	}

	public void setConnectionCheck(HeartBeatConnectionCheckXmlModel connectionCheck) {
		this.connectionCheck = connectionCheck;
	}
}