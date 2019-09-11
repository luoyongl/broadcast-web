package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BVideoAdsServices;
import cn.wtu.broadcast.openapi.dao.BVideoAdsMapper;
import cn.wtu.broadcast.openapi.dao.extend.BVideoAdsExtMapper;
import cn.wtu.broadcast.openapi.model.BVideoAds;
import cn.wtu.broadcast.openapi.model.BVideoAdsExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BVideoVo;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class BVideoAdsServiceImpl extends ParentServiceImpl<BVideoAds> implements BVideoAdsServices{

	public static Logger logger=LoggerFactory.getLogger(BVideoAdsServiceImpl.class);

	private final BVideoAdsMapper bVideoAdsMapper;
	
	private final BVideoAdsExtMapper bVideoAdsExtMapper;
	
	public BVideoAdsServiceImpl(BVideoAdsExtMapper bVideoAdsExtMapper,
			BVideoAdsMapper bVideoAdsMapper) {
		this.bVideoAdsExtMapper=bVideoAdsExtMapper;
		this.bVideoAdsMapper=bVideoAdsMapper;
	}
	
	@Override
	protected DBInterface<BVideoAds> getDao() {
		return bVideoAdsMapper;
	}

	@Override
	public Boolean insertVideo(BVideoAds bVideoAds) {
		TUser sessionUser = getSessionUser();
		bVideoAds.setfCreatorId(sessionUser.getfId());
		try {
			int count=bVideoAdsMapper.insertSelective(bVideoAds);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
	}

	@Override
	public List<BVideoAds> selectAll() {
		BVideoAdsExample example=new BVideoAdsExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		return bVideoAdsMapper.selectByExample(example);
	}

	@Override
	public void updateVideo(BVideoAds bVideoAds) {
		TUser sessionUser = getSessionUser();
		bVideoAds.setfOperatorId(sessionUser.getfId());
		bVideoAdsMapper.updateByPrimaryKeySelective(bVideoAds);
	}

	@Override
	public int deleteVideo(String fId) {
		TUser tUser = getSessionUser();
		BVideoAds bVideoAds=new BVideoAds();
		bVideoAds.setfDeleteFlag(true);
		bVideoAds.setfOperatorId(tUser.getfId());
		int count=0;
		String[] ids=fId.split(",");
		for (String id : ids) {
			try {
				bVideoAds.setfId(Integer.parseInt(id));
				bVideoAdsMapper.updateByPrimaryKeySelective(bVideoAds);
				count++;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return count;
		
	}

	
	@Override
	public PageInfo<BVideoAds> queryPageByParam(Map<String, Object> paramMap) throws BizException {
		List<BVideoAds> list=null;
 		try {
 			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
	 		list =bVideoAdsExtMapper.selectVideoAll(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
 		
        return new PageInfo<BVideoAds>(list);
	}

	@Override
	public Boolean checkVideo(String title) {
		int count=0;
		BVideoAdsExample example=new BVideoAdsExample();
		example.createCriteria().andFVideoNameEqualTo(title).andFDeleteFlagEqualTo(false);
		try {
			count=bVideoAdsMapper.countByExample(example);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}if (count>0) {
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public BVideoVo selectVideoById(Integer fId) {
		return bVideoAdsExtMapper.selectVideoById(fId);
	}

}
