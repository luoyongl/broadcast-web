package cn.wtu.broadcast.openapi.provider;

import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.BroadcastTempService;
import cn.wtu.broadcast.openapi.dao.BBroadcastTempMapper;
import cn.wtu.broadcast.openapi.dao.extend.BroadcastTempExtMapper;
import cn.wtu.broadcast.openapi.model.BBroadcastTemp;
import cn.wtu.broadcast.parent.db.api.DBInterface;

@Service("broadcastTempService")
public class BroadcastTempServiceImpl extends ParentServiceImpl<BBroadcastTemp> implements BroadcastTempService {

	private final BBroadcastTempMapper broadcastTempMapper;
	
	private final BroadcastTempExtMapper broadcastTempExtMapper;
	
	public BroadcastTempServiceImpl(BBroadcastTempMapper broadcastTempMapper,BroadcastTempExtMapper broadcastTempExtMapper) {
		this.broadcastTempMapper = broadcastTempMapper;
		this.broadcastTempExtMapper=broadcastTempExtMapper;
	}

	protected DBInterface<BBroadcastTemp> getDao() {
		return broadcastTempMapper;
	}

	public boolean addBroadcastTemp(BBroadcastTemp broadcastTemp){
		int i = broadcastTempMapper.insert(broadcastTemp);
        return i>0 ? true:false;
	}
	
	public void deleteBroadcastTemp(Integer broadcastId){
		broadcastTempExtMapper.deleteBBroadcastTemp(broadcastId);
	}

	public Integer selectByBroadcastId(Integer broadcastId) {
		return broadcastTempExtMapper.selectByBroadcastId(broadcastId);
	}
}
