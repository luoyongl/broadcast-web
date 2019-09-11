package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceConfig;
import cn.wtu.broadcast.openapi.model.BDeviceConfigExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BDeviceConfigMapper extends DBInterface<BDeviceConfig> {
    int countByExample(BDeviceConfigExample example);

    int deleteByExample(BDeviceConfigExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceConfig record);

    int insertSelective(BDeviceConfig record);

    List<BDeviceConfig> selectByExample(BDeviceConfigExample example);

    BDeviceConfig selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceConfig record, @Param("example") BDeviceConfigExample example);

    int updateByExample(@Param("record") BDeviceConfig record, @Param("example") BDeviceConfigExample example);

    int updateByPrimaryKeySelective(BDeviceConfig record);

    int updateByPrimaryKey(BDeviceConfig record);
}