package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.BRollingSubtitlesService;
import cn.wtu.broadcast.openapi.dao.BRollingSubtitlesMapper;
import cn.wtu.broadcast.openapi.dao.extend.BRollingSubtitlesExtMapper;
import cn.wtu.broadcast.openapi.model.BRollingSubtitles;
import cn.wtu.broadcast.openapi.model.BRollingSubtitlesExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.vo.BRollingSubtitlesVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service("bRollingSubtitlesService")
public class BRollingSubtitlesServiceImpl extends ParentServiceImpl<BRollingSubtitles> implements BRollingSubtitlesService{

	public static Logger logger=LoggerFactory.getLogger(BRollingSubtitlesServiceImpl.class);
	
	private final BRollingSubtitlesMapper bRollingSubtitlesMapper;
	
	private final BRollingSubtitlesExtMapper bRollingSubtitlesExtMapper;
	
	public BRollingSubtitlesServiceImpl(BRollingSubtitlesMapper bRollingSubtitlesMapper,
			BRollingSubtitlesExtMapper bRollingSubtitlesExtMapper) {
		this.bRollingSubtitlesMapper=bRollingSubtitlesMapper;
		this.bRollingSubtitlesExtMapper=bRollingSubtitlesExtMapper;
	}
	@Override
	public Boolean addRoliing(BRollingSubtitles bRollingSubtitles) throws ParseException {
		TUser tUser = getSessionUser();
		bRollingSubtitles.setfCreatorId(tUser.getfId());
		try {
			int count=bRollingSubtitlesMapper.insertSelective(bRollingSubtitles);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
			
	}
	
	@Override
	public List<BRollingSubtitles> selectAll() {
		BRollingSubtitlesExample example = new BRollingSubtitlesExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		return bRollingSubtitlesMapper.selectByExample(example);
	}
	
	@Override
	protected DBInterface<BRollingSubtitles> getDao() {
		return bRollingSubtitlesMapper;
	}

	@Override
	public Boolean updateZimu(BRollingSubtitles bRollingSubtitles) throws ParseException {
		TUser tUser = getSessionUser();
		bRollingSubtitles.setfOperatorId(tUser.getfId());;
		try {
			int count=bRollingSubtitlesMapper.updateByPrimaryKeySelective(bRollingSubtitles);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
		
	}

	@Override
	public int deleteZimu(String id) {
		TUser tUser = getSessionUser();
		BRollingSubtitles bRollingSubtitles=new BRollingSubtitles();
		bRollingSubtitles.setfDeleteFlag(true);
		bRollingSubtitles.setfOperatorId(tUser.getfId());
		int count=0;
		String[] ids=id.split(",");
		for (String fId : ids) {
			bRollingSubtitles.setfId(Integer.parseInt(fId));
			count+=bRollingSubtitlesMapper.updateByPrimaryKeySelective(bRollingSubtitles);
		}
		return count;
	}

	@Override
	public BRollingSubtitlesVO selectRollById(Integer fId) {
		return bRollingSubtitlesExtMapper.selectRollById(fId);
	}

	
	 	@Override
	    public PageInfo<BRollingSubtitlesVO> queryPage(Map<String, Object> paramMap){
	 		PageInfo<BRollingSubtitlesVO> result = null;
	 		try {
	 			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
	 			List<BRollingSubtitlesVO> dataList = bRollingSubtitlesExtMapper.selectRollAll(paramMap); 
	 			if (dataList != null) {
	 				result=new PageInfo<>(dataList);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}	
	        return result;
	    }

		@Override
		public Boolean checkZimu(String title) {
			int count=0;
			BRollingSubtitlesExample example=new BRollingSubtitlesExample();
			example.createCriteria().andFTitleEqualTo(title).andFDeleteFlagEqualTo(false);
			try {
				count=bRollingSubtitlesMapper.countByExample(example);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}if (count>0) {
				return true;
			}else{
				return false;
			}	
		}
}
