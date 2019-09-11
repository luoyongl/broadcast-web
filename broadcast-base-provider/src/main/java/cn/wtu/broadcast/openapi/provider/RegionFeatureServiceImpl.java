package cn.wtu.broadcast.openapi.provider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.RegionFeatureService;
import cn.wtu.broadcast.openapi.dao.BRegionalFeaturesMapper;
import cn.wtu.broadcast.openapi.model.BRegionalFeatures;
import cn.wtu.broadcast.openapi.model.BRegionalFeaturesExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;

/**
 * @author: yinjie
 * @since: 2019-1-15
 */
@Service("regionFeatureService")
public class RegionFeatureServiceImpl extends ParentServiceImpl<BRegionalFeatures> implements RegionFeatureService {

    private static Logger logger = LoggerFactory.getLogger(RegionFeatureServiceImpl.class);

    private final BRegionalFeaturesMapper bRegionalFeaturesMapper;

    @Autowired
    public RegionFeatureServiceImpl(BRegionalFeaturesMapper bRegionalFeaturesMapper) {
		this.bRegionalFeaturesMapper = bRegionalFeaturesMapper;
	}
    
    @Override
    protected DBInterface<BRegionalFeatures> getDao() {
    	return bRegionalFeaturesMapper;
    }


	@Override
    public Boolean addBRegionalFeatures(BRegionalFeatures bRegionalFeatures) {
        TUser sessionUser = getSessionUser();
        bRegionalFeatures.setfCreatorId(sessionUser.getfId());
        int result = 0;
        try{
            result = bRegionalFeaturesMapper.insertSelective(bRegionalFeatures);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        if(result==1){
            insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","成功");
            return true;
        }else {
            insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","失败");
            return false;
        }
    }
	
	@Override
    public Boolean addBRegionalFeaturesSynopsis(BRegionalFeatures bRegionalFeatures,Integer fBriefClassification){
		BRegionalFeaturesExample example = new BRegionalFeaturesExample();
        example.createCriteria().andFDeleteFlagEqualTo(false).andFBriefClassificationEqualTo(fBriefClassification);
        List<BRegionalFeatures> RegionalFeatures = bRegionalFeaturesMapper.selectByExample(example); 
		if(RegionalFeatures.size()==0){
			TUser sessionUser = getSessionUser();
			bRegionalFeatures.setfCreatorId(sessionUser.getfId());
			int result = 0;
			try{
				result = bRegionalFeaturesMapper.insertSelective(bRegionalFeatures);
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
			if(result==1){
				insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","成功");
				return true;
			}else {
				insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","失败");
				return false;
			}			
		}else {
			int result = 0;
			for (BRegionalFeatures RegionalFeature : RegionalFeatures) {
				RegionalFeature.setfMainTitle(bRegionalFeatures.getfMainTitle());
				RegionalFeature.setfContent(bRegionalFeatures.getfContent());
				RegionalFeature.setfRichTextContent(bRegionalFeatures.getfRichTextContent());
				RegionalFeature.setfImageUrl(bRegionalFeatures.getfImageUrl());
				RegionalFeature.setfSubheadingOne(bRegionalFeatures.getfSubheadingOne());
				RegionalFeature.setfSubContentOne(bRegionalFeatures.getfSubContentOne());
				RegionalFeature.setfSubheadingTwo(bRegionalFeatures.getfSubheadingTwo());
				RegionalFeature.setfSubContentTwo(bRegionalFeatures.getfSubContentTwo());
				RegionalFeature.setfSubheadingThree(bRegionalFeatures.getfSubheadingThree());
				RegionalFeature.setfSubContentThree(bRegionalFeatures.getfSubContentThree());
				RegionalFeature.setfImageType(bRegionalFeatures.getfImageType());
				RegionalFeature.setfBriefClassification(fBriefClassification);
				TUser sessionUser = getSessionUser();
				RegionalFeature.setfCreatorId(sessionUser.getfId());
				Date date = new Date();
				RegionalFeature.setfCreateTime(date);
				result = bRegionalFeaturesMapper.updateByPrimaryKeyWithBLOBs(RegionalFeature);
			}
			if(result==1){
				insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","成功");
				return true;
			}else {
				insertLog(OperationLogTypeEnum.INSERT,"新增区域特色简介","失败");
				return false;
			}
		}
    }
    
   @Override
   public boolean update(BRegionalFeatures bRegionalFeatures) {
	   bRegionalFeatures.setfOperatorId(getSessionUser().getfId());
	   bRegionalFeatures.setfUpdateTime(new Date());
        try {
            int result = bRegionalFeaturesMapper.updateByPrimaryKeySelective(bRegionalFeatures);
            if (result == 1) {
                insertLog(OperationLogTypeEnum.UPDATE, "修改区域特色图片", "成功");
                return true;
            } else {
                insertLog(OperationLogTypeEnum.UPDATE, "修改区域特色图片", "失败");
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            insertLog(OperationLogTypeEnum.UPDATE, "修改区域特色图片", "失败");
            return false;
        }
    }
    
    @Override
	@Transactional(rollbackFor = {Exception.class})
	public int deleteRegionFeatureByIds(List<Integer> idList,Integer fBriefClassification) {
    	int result = 0;
		Date date = new Date();
		TUser sessionUser = getSessionUser();
		for(Integer id:idList){
			BRegionalFeatures bRegionalFeatures = new BRegionalFeatures();
			bRegionalFeatures.setfId(id);
			bRegionalFeatures.setfUpdateTime(date);
			bRegionalFeatures.setfDeleteFlag(true);
			bRegionalFeatures.setfOperatorId(sessionUser.getfId());
			bRegionalFeatures.setfBriefClassification(fBriefClassification);
			try{
				result += bRegionalFeaturesMapper.updateByPrimaryKeySelective(bRegionalFeatures);
			}catch (Exception e){
				logger.error(e.getMessage(),e);
			}
		}
		insertLog(OperationLogTypeEnum.DELETE,"删除区域特色图片","删除了"+result+"个区域特色图片");
		return result;
	}
   
    /*@Override
  	@Transactional(rollbackFor = {Exception.class})
  	public int deleteRegionFeatureByBriefClassification(Integer fBriefClassification) {
	   int result = 0;
	   try{
		   List<BRegionalFeatures> bRegionalFeatures = new ArrayList<BRegionalFeatures>();
		   BRegionalFeaturesExample example = new BRegionalFeaturesExample();
	       example.createCriteria().andFDeleteFlagEqualTo(false).andFBriefClassificationEqualTo(fBriefClassification);
	       bRegionalFeatures =  bRegionalFeaturesMapper.selectByExample(example);
	       for (BRegionalFeatures bRegionalFeature : bRegionalFeatures) {
			   bRegionalFeature.setfDeleteFlag(true);
			   bRegionalFeaturesMapper.updateByPrimaryKeySelective(bRegionalFeature);
			   result = result+1;
		   }
	   }catch (Exception e){
			logger.error(e.getMessage(),e);
	   }
  	   insertLog(OperationLogTypeEnum.DELETE,"删除区域特色简介","删除了区域特色简介");
  	   return result;
  	}*/
   
    @Override
    public PageInfo<BRegionalFeatures> queryPageByParam(Map<String, Object> paramMap) throws BizException {
        PageHelper.startPage((Integer) paramMap.get("pageNo"),(Integer) paramMap.get("pageSize"));
        List<BRegionalFeatures> bRegionalFeatures = null;
        try {
        	BRegionalFeaturesExample example = new BRegionalFeaturesExample();
            example.createCriteria().andFDeleteFlagEqualTo(false).andFBriefClassificationEqualTo(4);
            bRegionalFeatures =  bRegionalFeaturesMapper.selectByExample(example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return new PageInfo<>(bRegionalFeatures);
    }
    

    public List<BRegionalFeatures> selectFeaturesByBriefClassification(Integer fBriefClassification){
        List<BRegionalFeatures> bRegionalFeatures = null;
        try {
        	BRegionalFeaturesExample example = new BRegionalFeaturesExample();
            example.createCriteria().andFDeleteFlagEqualTo(false).andFBriefClassificationEqualTo(fBriefClassification);
            //bRegionalFeatures =  bRegionalFeaturesMapper.selectByExample(example);
            bRegionalFeatures = bRegionalFeaturesMapper.selectByExampleWithBLOBs(example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return bRegionalFeatures;
    }

}



