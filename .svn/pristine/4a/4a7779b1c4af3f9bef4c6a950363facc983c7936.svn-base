package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceStateReturn;
import cn.wtu.broadcast.openapi.model.BDeviceStateReturnExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceStateReturnMapper extends DBInterface<BDeviceStateReturn>{
    int countByExample(BDeviceStateReturnExample example);

    int deleteByExample(BDeviceStateReturnExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceStateReturn record);

    int insertSelective(BDeviceStateReturn record);

    List<BDeviceStateReturn> selectByExample(BDeviceStateReturnExample example);

    BDeviceStateReturn selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceStateReturn record, @Param("example") BDeviceStateReturnExample example);

    int updateByExample(@Param("record") BDeviceStateReturn record, @Param("example") BDeviceStateReturnExample example);

    int updateByPrimaryKeySelective(BDeviceStateReturn record);

    int updateByPrimaryKey(BDeviceStateReturn record);
}