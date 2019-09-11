package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BBroadcastTemp;
import cn.wtu.broadcast.openapi.model.BBroadcastTempExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BBroadcastTempMapper extends DBInterface<BBroadcastTemp> {
    int countByExample(BBroadcastTempExample example);

    int deleteByExample(BBroadcastTempExample example);

    int insert(BBroadcastTemp record);

    int insertSelective(BBroadcastTemp record);

    List<BBroadcastTemp> selectByExample(BBroadcastTempExample example);

    int updateByExampleSelective(@Param("record") BBroadcastTemp record, @Param("example") BBroadcastTempExample example);

    int updateByExample(@Param("record") BBroadcastTemp record, @Param("example") BBroadcastTempExample example);
}