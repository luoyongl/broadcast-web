package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.TRegionalFeatures;
import cn.wtu.broadcast.openapi.model.TRegionalFeaturesExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface TRegionalFeaturesMapper extends DBInterface<TRegionalFeatures>{
    int countByExample(TRegionalFeaturesExample example);

    int deleteByExample(TRegionalFeaturesExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TRegionalFeatures record);

    int insertSelective(TRegionalFeatures record);

    List<TRegionalFeatures> selectByExample(TRegionalFeaturesExample example);

    TRegionalFeatures selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TRegionalFeatures record, @Param("example") TRegionalFeaturesExample example);

    int updateByExample(@Param("record") TRegionalFeatures record, @Param("example") TRegionalFeaturesExample example);

    int updateByPrimaryKeySelective(TRegionalFeatures record);

    int updateByPrimaryKey(TRegionalFeatures record);
}