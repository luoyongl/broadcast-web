package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.TDeviceChannelProtocol;
import cn.wtu.broadcast.openapi.model.TDeviceChannelProtocolExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeviceChannelProtocolMapper extends  DBInterface<TDeviceChannelProtocol>{
    int countByExample(TDeviceChannelProtocolExample example);

    int deleteByExample(TDeviceChannelProtocolExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TDeviceChannelProtocol record);

    int insertSelective(TDeviceChannelProtocol record);

    List<TDeviceChannelProtocol> selectByExample(TDeviceChannelProtocolExample example);

    TDeviceChannelProtocol selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TDeviceChannelProtocol record, @Param("example") TDeviceChannelProtocolExample example);

    int updateByExample(@Param("record") TDeviceChannelProtocol record, @Param("example") TDeviceChannelProtocolExample example);

    int updateByPrimaryKeySelective(TDeviceChannelProtocol record);

    int updateByPrimaryKey(TDeviceChannelProtocol record);
}