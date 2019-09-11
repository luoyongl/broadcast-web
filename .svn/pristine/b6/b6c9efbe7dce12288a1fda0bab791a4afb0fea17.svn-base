package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BPictureAdsService;
import cn.wtu.broadcast.openapi.dao.BPictureAdsMapper;
import cn.wtu.broadcast.openapi.dao.extend.BPictureAdsExtMapper;
import cn.wtu.broadcast.openapi.model.BPictureAds;
import cn.wtu.broadcast.openapi.model.BPictureAdsExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BPictureAdsVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

@Service
public class BPictureAdsServiceImpl extends ParentServiceImpl<BPictureAds> implements BPictureAdsService{

	public static Logger logger=LoggerFactory.getLogger(BPictureAdsServiceImpl.class);
	
	private final BPictureAdsMapper bPictureAdsMapper;
	
	private final BPictureAdsExtMapper bPictureAdsExtMapper;
	
	@Autowired
	public BPictureAdsServiceImpl(BPictureAdsMapper broadcastDataMapper,
			BPictureAdsExtMapper bPictureAdsExtMapper) {
		this.bPictureAdsMapper = broadcastDataMapper;
		this.bPictureAdsExtMapper = bPictureAdsExtMapper;
	}
	
	@Override
	protected DBInterface<BPictureAds> getDao() {
		return bPictureAdsMapper;
	}
	
	@Override
	public List<BPictureAds> selectAll() {
		BPictureAdsExample example=new BPictureAdsExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		return bPictureAdsMapper.selectByExample(example);
	}
	
	@Override
	public Boolean addPicture(BPictureAds bPictureAds) {
		TUser tUser = getSessionUser();
		bPictureAds.setfCreatorId(tUser.getfId());
		try {
			int count=bPictureAdsMapper.insertSelective(bPictureAds);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
	}

	@Override
	public Boolean updatePicture(BPictureAds bPictureAds) {
		TUser tUser = getSessionUser();
		bPictureAds.setfOperatorId(tUser.getfId());
		try {
			int count=bPictureAdsMapper.updateByPrimaryKeySelective(bPictureAds);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;

	}

	@Override
	public int deletePicture(String fId) {
		BPictureAds bPictureAds=new BPictureAds();
		TUser tUser = getSessionUser();
		bPictureAds.setfOperatorId(tUser.getfId());
		bPictureAds.setfDeleteFlag(true);
		int count=0;
		String[] ids=fId.split(",");
		for (String id : ids) {
			try {
				bPictureAds.setfId(Integer.parseInt(id));
				count+=bPictureAdsMapper.updateByPrimaryKeySelective(bPictureAds);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}	
		}
		return count;
		
	}

	@Override
	public BPictureAdsVO selectPictureById(Integer fId) {
		return bPictureAdsExtMapper.selectPictureById(fId);
	}

		
		@Override
		public PageInfo<BPictureAdsVO> queryPage(Map<String, Object> paramMap) {
			 PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
		        List<BPictureAdsVO> list = bPictureAdsExtMapper.selectPictureAll(paramMap);
		        return new PageInfo<BPictureAdsVO>(list);
		}

		@Override
		public Boolean checkPicture(String fImageName) {
			int count=0;
			BPictureAdsExample example=new BPictureAdsExample();
			example.createCriteria().andFImageNameEqualTo(fImageName).andFDeleteFlagEqualTo(false);
			try {
				count=bPictureAdsMapper.countByExample(example);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}if (count>0) {
				return true;
			}else{
				return false;
			}
		}
}
