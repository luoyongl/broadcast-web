package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BTransmitterinfo;
import cn.wtu.broadcast.openapi.model.BTransmitterinfoExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BTransmitterinfoMapper extends DBInterface<BTransmitterinfo>{
    int countByExample(BTransmitterinfoExample example);

    int deleteByExample(BTransmitterinfoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BTransmitterinfo record);

    int insertSelective(BTransmitterinfo record);

    List<BTransmitterinfo> selectByExample(BTransmitterinfoExample example);

    BTransmitterinfo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BTransmitterinfo record, @Param("example") BTransmitterinfoExample example);

    int updateByExample(@Param("record") BTransmitterinfo record, @Param("example") BTransmitterinfoExample example);

    int updateByPrimaryKeySelective(BTransmitterinfo record);

    int updateByPrimaryKey(BTransmitterinfo record);
}