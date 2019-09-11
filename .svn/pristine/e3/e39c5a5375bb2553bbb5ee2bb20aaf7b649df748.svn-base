package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BRegionalFeatures;
import cn.wtu.broadcast.openapi.model.BRegionalFeaturesExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BRegionalFeaturesMapper extends DBInterface<BRegionalFeatures>{
    int countByExample(BRegionalFeaturesExample example);

    int deleteByExample(BRegionalFeaturesExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BRegionalFeatures record);

    int insertSelective(BRegionalFeatures record);

    List<BRegionalFeatures> selectByExampleWithBLOBs(BRegionalFeaturesExample example);

    List<BRegionalFeatures> selectByExample(BRegionalFeaturesExample example);

    BRegionalFeatures selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BRegionalFeatures record, @Param("example") BRegionalFeaturesExample example);

    int updateByExampleWithBLOBs(@Param("record") BRegionalFeatures record, @Param("example") BRegionalFeaturesExample example);

    int updateByExample(@Param("record") BRegionalFeatures record, @Param("example") BRegionalFeaturesExample example);

    int updateByPrimaryKeySelective(BRegionalFeatures record);

    int updateByPrimaryKeyWithBLOBs(BRegionalFeatures record);

    int updateByPrimaryKey(BRegionalFeatures record);
}