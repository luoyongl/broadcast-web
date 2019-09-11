package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BDeviceReturnAudio;
import cn.wtu.broadcast.openapi.model.BDeviceReturnAudioExample;
import java.util.List;

import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.apache.ibatis.annotations.Param;

public interface BDeviceReturnAudioMapper extends DBInterface<BDeviceReturnAudio> {
    int countByExample(BDeviceReturnAudioExample example);

    int deleteByExample(BDeviceReturnAudioExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BDeviceReturnAudio record);

    int insertSelective(BDeviceReturnAudio record);

    List<BDeviceReturnAudio> selectByExampleWithBLOBs(BDeviceReturnAudioExample example);

    List<BDeviceReturnAudio> selectByExample(BDeviceReturnAudioExample example);

    BDeviceReturnAudio selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BDeviceReturnAudio record, @Param("example") BDeviceReturnAudioExample example);

    int updateByExampleWithBLOBs(@Param("record") BDeviceReturnAudio record, @Param("example") BDeviceReturnAudioExample example);

    int updateByExample(@Param("record") BDeviceReturnAudio record, @Param("example") BDeviceReturnAudioExample example);

    int updateByPrimaryKeySelective(BDeviceReturnAudio record);

    int updateByPrimaryKeyWithBLOBs(BDeviceReturnAudio record);

    int updateByPrimaryKey(BDeviceReturnAudio record);
}