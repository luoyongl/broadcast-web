package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BBroadcastArea;
import cn.wtu.broadcast.openapi.model.BBroadcastAreaExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BBroadcastAreaMapper extends DBInterface<BBroadcastArea>{
    int countByExample(BBroadcastAreaExample example);

    int deleteByExample(BBroadcastAreaExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BBroadcastArea record);

    int insertSelective(BBroadcastArea record);

    List<BBroadcastArea> selectByExample(BBroadcastAreaExample example);

    BBroadcastArea selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BBroadcastArea record, @Param("example") BBroadcastAreaExample example);

    int updateByExample(@Param("record") BBroadcastArea record, @Param("example") BBroadcastAreaExample example);

    int updateByPrimaryKeySelective(BBroadcastArea record);

    int updateByPrimaryKey(BBroadcastArea record);
}