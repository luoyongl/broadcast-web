package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BVideoAds;
import cn.wtu.broadcast.openapi.model.BVideoAdsExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BVideoAdsMapper extends DBInterface<BVideoAds>{
    int countByExample(BVideoAdsExample example);

    int deleteByExample(BVideoAdsExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BVideoAds record);

    int insertSelective(BVideoAds record);

    List<BVideoAds> selectByExample(BVideoAdsExample example);

    BVideoAds selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BVideoAds record, @Param("example") BVideoAdsExample example);

    int updateByExample(@Param("record") BVideoAds record, @Param("example") BVideoAdsExample example);

    int updateByPrimaryKeySelective(BVideoAds record);

    int updateByPrimaryKey(BVideoAds record);
}