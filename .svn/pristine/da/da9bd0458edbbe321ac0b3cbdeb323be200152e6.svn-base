package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BDeviceStateReturnHistory;
import cn.wtu.broadcast.openapi.model.BDeviceStateReturnHistoryExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BDeviceStateReturnHistoryMapper extends DBInterface<BDeviceStateReturnHistory>{
    int countByExample(BDeviceStateReturnHistoryExample example);

    int deleteByExample(BDeviceStateReturnHistoryExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceStateReturnHistory record);

    int insertSelective(BDeviceStateReturnHistory record);

    List<BDeviceStateReturnHistory> selectByExampleWithBLOBs(BDeviceStateReturnHistoryExample example);

    List<BDeviceStateReturnHistory> selectByExample(BDeviceStateReturnHistoryExample example);

    BDeviceStateReturnHistory selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceStateReturnHistory record, @Param("example") BDeviceStateReturnHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") BDeviceStateReturnHistory record, @Param("example") BDeviceStateReturnHistoryExample example);

    int updateByExample(@Param("record") BDeviceStateReturnHistory record, @Param("example") BDeviceStateReturnHistoryExample example);

    int updateByPrimaryKeySelective(BDeviceStateReturnHistory record);

    int updateByPrimaryKeyWithBLOBs(BDeviceStateReturnHistory record);

    int updateByPrimaryKey(BDeviceStateReturnHistory record);
}