package cn.wtu.broadcast.openapi.api;

import java.util.List;

import cn.wtu.broadcast.openapi.model.BVideoAds;
import cn.wtu.broadcast.openapi.vo.BVideoVo;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BVideoAdsServices extends ParentService<BVideoAds>{
	public Boolean insertVideo(BVideoAds bVideoAds);
	
	public List<BVideoAds> selectAll();
	
	public void updateVideo(BVideoAds bVideoAds);
	
	public int deleteVideo(String ids);
	
	public Boolean checkVideo(String title);
	
	public BVideoVo selectVideoById(Integer fId);
}
