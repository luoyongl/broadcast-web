package cn.wtu.broadcast.openapi.api;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BPictureAds;
import cn.wtu.broadcast.openapi.vo.BPictureAdsVO;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BPictureAdsService extends ParentService<BPictureAds>{
	
	public Boolean addPicture(BPictureAds bPictureAds);
	
	public Boolean updatePicture(BPictureAds bPictureAds);
	
	public List<BPictureAds> selectAll();
	
	public int deletePicture(String fId);
	
	public BPictureAdsVO selectPictureById(Integer fId);
	
	PageInfo<BPictureAdsVO> queryPage(Map<String, Object> paramMap);
	
	public Boolean checkPicture(String fImageName);
}
