package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;


public interface DispatchHttpclientService {

	/**
     * 开启发送指令的操作
     * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
     * @param broadcastTo 所选播发区域
     * @param broadcastType 广播类型
     * @param broadcastId 广播ID
     * @return
     */
	public BroadcastResult sendBroadcast(String dispatchServerTomcatPort, String broadcastTo, Integer broadcastType, Integer broadcastId);
	
	/**
	 * 停播
	 * @param dispatchServerTomcatPort 调控服务器http请求地址的tomcat端口
	 * @param broadcastTo 所选播发区域
	 * @param broadcastId 广播ID
	 * @return
	 */
	public BroadcastResult stopBroadcast(String dispatchServerTomcatPort, String broadcastTo, Integer broadcastId);
	
	/**
	 * 图文相关处理
	 * @param name
	 * @param contentOrUrl
	 * @param resourceCodes
	 * @param dispatchServerTomcatPort
	 * @return
	 */
	public BroadcastResult sendIpPictureVideo(String playType, String name, String contentOrUrl, String resourceCodes,
			String dispatchServerTomcatPort, Integer pictureId);
}
