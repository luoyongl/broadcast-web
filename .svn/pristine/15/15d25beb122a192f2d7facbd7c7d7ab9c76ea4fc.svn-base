package cn.wtu.broadcast.openapi.vo.ebm;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import cn.wtu.broadcast.openapi.vo.common.CommonEBDXmlModel;
 
@XmlRootElement(name = "EBD")
public class EBDXmlModel extends CommonEBDXmlModel{
	@XmlElement(name = "EBM")
	private EBDEBMXmlModel ebm;

	@XmlTransient
	public EBDEBMXmlModel getEbm() {
		return ebm;
	}

	public void setEbm(EBDEBMXmlModel ebm) {
		this.ebm = ebm;
	}
	
}