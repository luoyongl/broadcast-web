package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BRollingSubtitles;
import cn.wtu.broadcast.openapi.model.BRollingSubtitlesExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BRollingSubtitlesMapper extends DBInterface<BRollingSubtitles>{
    int countByExample(BRollingSubtitlesExample example);

    int deleteByExample(BRollingSubtitlesExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BRollingSubtitles record);

    int insertSelective(BRollingSubtitles record);

    List<BRollingSubtitles> selectByExample(BRollingSubtitlesExample example);

    BRollingSubtitles selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BRollingSubtitles record, @Param("example") BRollingSubtitlesExample example);

    int updateByExample(@Param("record") BRollingSubtitles record, @Param("example") BRollingSubtitlesExample example);

    int updateByPrimaryKeySelective(BRollingSubtitles record);

    int updateByPrimaryKey(BRollingSubtitles record);
}