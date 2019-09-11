package cn.wtu.broadcast.openapi.api;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.model.BRollingSubtitles;
import cn.wtu.broadcast.openapi.vo.BRollingSubtitlesVO;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.service.api.ParentService;

public interface BRollingSubtitlesService extends ParentService<BRollingSubtitles>{

	public Boolean addRoliing(BRollingSubtitles bRollingSubtitles) throws ParseException;
	
	public List<BRollingSubtitles> selectAll();
	
	public Boolean updateZimu(BRollingSubtitles bRollingSubtitles) throws ParseException;
	
	public int deleteZimu(String id);
	
	public BRollingSubtitlesVO selectRollById(Integer fId);
	
	/**
	 * 
	 * @param title 传入的标题
	 * @return true 代表有重复 
	 * & false 代表没有重复 默认为false
	 */
	public Boolean checkZimu(String title);

	/**
	 * 查询滚动字幕 自定义模糊查询
	 * @param paramMap
	 * @return
	 * @throws BizException
	 */
	public PageInfo<BRollingSubtitlesVO> queryPage(Map<String, Object> paramMap);
}
