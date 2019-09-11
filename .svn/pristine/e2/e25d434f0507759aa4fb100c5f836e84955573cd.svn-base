package cn.wtu.broadcast.openapi.api;

import java.util.List;

import cn.wtu.broadcast.openapi.model.BRegionalFeatures;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface RegionFeatureService extends ParentService<BRegionalFeatures>{
	//添加区域特色图片
    public Boolean addBRegionalFeatures(BRegionalFeatures bRegionalFeatures);
	
    //修改区域特色图片
    public boolean update(BRegionalFeatures bRegionalFeatures);
    
    //删除区域特色图片
    public int deleteRegionFeatureByIds(List<Integer> idList,Integer fBriefClassification);
    
    //查找所有数据
    public List<BRegionalFeatures> selectFeaturesByBriefClassification(Integer fBriefClassification);
    
    //删除简介
    //public int deleteRegionFeatureByBriefClassification(Integer fBriefClassification);
    
    //保存简介
    public Boolean addBRegionalFeaturesSynopsis(BRegionalFeatures bRegionalFeatures,Integer fBriefClassification);
}
