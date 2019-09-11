package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BBroadcastTiming;
import cn.wtu.broadcast.openapi.vo.BroadcastTimingVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.vo.EBITParamsVO;

public interface BBroadcastTimingExtMapper extends DBInterface<BBroadcastTiming>{

	List<BroadcastTimingVO> selectBoradcastAll(Map<String, Object> paramMap);

	/**
	 * @Desc 根据广播类型和id查询数据并封装到索引表
	 * @Date 2019-01-14
	 * @Author lxg
	 * @return
	 */
	EBITParamsVO queryThirdBroadcastData(Integer fId);

	void setStateByFid(Integer state, Integer fId);
}
