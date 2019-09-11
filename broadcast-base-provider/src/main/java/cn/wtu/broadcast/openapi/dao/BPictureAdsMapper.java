package cn.wtu.broadcast.openapi.dao;

import cn.wtu.broadcast.openapi.model.BPictureAds;
import cn.wtu.broadcast.openapi.model.BPictureAdsExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BPictureAdsMapper extends DBInterface<BPictureAds>{
    int countByExample(BPictureAdsExample example);

    int deleteByExample(BPictureAdsExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(BPictureAds record);

    int insertSelective(BPictureAds record);

    List<BPictureAds> selectByExample(BPictureAdsExample example);

    BPictureAds selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") BPictureAds record, @Param("example") BPictureAdsExample example);

    int updateByExample(@Param("record") BPictureAds record, @Param("example") BPictureAdsExample example);

    int updateByPrimaryKeySelective(BPictureAds record);

    int updateByPrimaryKey(BPictureAds record);
}