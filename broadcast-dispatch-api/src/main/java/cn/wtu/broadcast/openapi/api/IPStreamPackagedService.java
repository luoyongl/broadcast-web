package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.vo.IpVO;

public interface IPStreamPackagedService {

	/**
	 * 
	 */
	public void sendIPCommand(String serviceType,IpVO ipvo);
}
