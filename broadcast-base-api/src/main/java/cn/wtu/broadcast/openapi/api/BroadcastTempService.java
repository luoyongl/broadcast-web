package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BBroadcastTemp;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BroadcastTempService extends ParentService<BBroadcastTemp> {
	
	public Integer selectByBroadcastId(Integer broadcastId);

	public boolean addBroadcastTemp(BBroadcastTemp broadcastTemp);
	
	public void deleteBroadcastTemp(Integer broadcastId);
}
