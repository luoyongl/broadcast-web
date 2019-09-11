package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * 音频播放业务层service
 * 发送21包数据(索引表和配置表)  及  音频流数据   
 * @author lxg
 * @date 2019/2/19
 */
public interface AudioPlayService {

	/**
	 * 音频播放   发送21包数据(索引表和配置表)  及  音频流数据  
	 * @author lxg
	 * @since  2019/2/19
	 * @param  广播类型  broadcastType,广播ID fId
	 */
	public BroadcastResult playAudio(Integer broadcastType, Integer fId);
	
	/**
	 * 用于图文视频发布
	 * @param playType
	 * @param name
	 * @param contentOrUrl
	 * @param resourceCodes
	 * @param broadcastTomcatPath
	 * @return
	 */
	public BroadcastResult ipPictureVideoPlay(Integer playType, String name, String contentOrUrl, String resourceCodes, String broadcastTomcatPath,String pictureId);
	
	public BroadcastResult ipPlayAudio(Integer broadcastType, Integer fId, String broadcastTomcatPath);
	
	/**
	 * 根据广播选中的区域查询对应的设备
	 * @param resourceId
	 * @param broadcastfId
	 * @param type
	 */
	public void addDeviceByResourceIds(String resourceId,Integer broadcastfId,Integer type);

	public void addDeviceResourceIds(String resourceId, Integer broadcastfId, Integer type);
	
}
