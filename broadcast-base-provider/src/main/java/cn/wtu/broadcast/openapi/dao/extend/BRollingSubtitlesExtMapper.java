package cn.wtu.broadcast.openapi.dao.extend;

		import cn.wtu.broadcast.openapi.model.BRollingSubtitles;
import cn.wtu.broadcast.openapi.vo.BRollingSubtitlesVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import java.util.Map;

public interface BRollingSubtitlesExtMapper extends DBInterface<BRollingSubtitles>{

	public BRollingSubtitlesVO selectRollById(Integer fId);

	public List<BRollingSubtitlesVO> selectRollAll(Map<String, Object> paramMap);
}
