package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.BTeletextTerminalService;
import cn.wtu.broadcast.openapi.dao.BTeletextTerminalMapper;
import cn.wtu.broadcast.openapi.model.BTeletextTerminal;
import cn.wtu.broadcast.openapi.model.BTeletextTerminalExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.exceptions.BizException;

@Service
public class BTeletextTerminalServiceImpl extends ParentServiceImpl<BTeletextTerminal> implements BTeletextTerminalService{

	public static Logger logger=LoggerFactory.getLogger(BTeletextTerminalServiceImpl.class);
	
	private final BTeletextTerminalMapper bTeletextTerminalMapper;
	
	public BTeletextTerminalServiceImpl(BTeletextTerminalMapper bTeletextTerminalMapper) {
		this.bTeletextTerminalMapper=bTeletextTerminalMapper;
	}
	@Override
	public Boolean addTerminal(BTeletextTerminal bTeletextTerminal) {
		TUser tUser = getSessionUser();
		bTeletextTerminal.setfCreatorId(tUser.getfId());
		try {
			int count=bTeletextTerminalMapper.insertSelective(bTeletextTerminal);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
	}

	@Override
	public List<BTeletextTerminal> selectAll() {
		BTeletextTerminalExample example=new BTeletextTerminalExample();
		example.createCriteria().andFDeleteFlagEqualTo(false);
		return bTeletextTerminalMapper.selectByExample(example);
	}

	@Override
	public Boolean updateTerminal(BTeletextTerminal bTeletextTerminal) {
		TUser tUser = getSessionUser();
		bTeletextTerminal.setfOperatorId(tUser.getfId());
		try {
			int count=bTeletextTerminalMapper.updateByPrimaryKeySelective(bTeletextTerminal);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
			return false;
		
	}

	@Override
	public int deleteimgTextTerminal(String fId) {
		TUser tUser = getSessionUser();
		BTeletextTerminal bTeletextTerminal=new BTeletextTerminal();
		bTeletextTerminal.setfOperatorId(tUser.getfId());
		bTeletextTerminal.setfDeleteFlag(true);
		int count=0;
		String[] ids=fId.split(",");
		for (String id : ids) {
			try {
				bTeletextTerminal.setfId(Integer.parseInt(id));
				count+=bTeletextTerminalMapper.updateByPrimaryKeySelective(bTeletextTerminal);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}	
		}
		return count;
	}
	@Override
	public PageInfo<BTeletextTerminal> queryPageByParam(Map<String, Object> paramMap)throws BizException {
		PageInfo<BTeletextTerminal> result = null;
		BTeletextTerminalExample example=new BTeletextTerminalExample();
		example.setOrderByClause(paramMap.get("sortName")+" "+paramMap.get("sortOrder"));
		example.createCriteria().andFDeleteFlagEqualTo(false);
		try {
			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
			List<BTeletextTerminal> dataList = bTeletextTerminalMapper.selectByExample(example);
			if (dataList != null) {
				result = new PageInfo<>(dataList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} 
		return result;
	}

	
	@Override
	protected DBInterface<BTeletextTerminal> getDao() {
		return bTeletextTerminalMapper;
	}

	@Override
	public Boolean checkTextTerminal(String title) {
		int count=0;
		BTeletextTerminalExample example=new BTeletextTerminalExample();
		example.createCriteria().andFTerminalNameEqualTo(title).andFDeleteFlagEqualTo(false);
		try {
			count=bTeletextTerminalMapper.countByExample(example);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}if (count>0) {
			return true;
		}else{
			return false;
		}	
	}

}
