package cn.wtu.broadcast.openapi.dao.extend;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.model.BVideoAds;
import cn.wtu.broadcast.openapi.vo.BVideoVo;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BVideoAdsExtMapper extends DBInterface<BVideoAds> {

	List<BVideoAds> selectVideoAll(Map<String, Object> paramMap);

	public BVideoVo selectVideoById(Integer fId);
}