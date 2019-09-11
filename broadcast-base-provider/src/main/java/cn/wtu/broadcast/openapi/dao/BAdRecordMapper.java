package cn.wtu.broadcast.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wtu.broadcast.openapi.model.BAdRecord;
import cn.wtu.broadcast.openapi.model.BAdRecordExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;

public interface BAdRecordMapper extends DBInterface<BAdRecord> {
	int countByExample(BAdRecordExample example);

	int deleteByExample(BAdRecordExample example);

	int deleteByPrimaryKey(Integer fId);

	int insert(BAdRecord record);

	int insertSelective(BAdRecord record);

	List<BAdRecord> selectByExample(BAdRecordExample example);

	BAdRecord selectByPrimaryKey(Integer fId);

	int updateByExampleSelective(@Param("record") BAdRecord record, @Param("example") BAdRecordExample example);

	int updateByExample(@Param("record") BAdRecord record, @Param("example") BAdRecordExample example);

	int updateByPrimaryKeySelective(BAdRecord record);

	int updateByPrimaryKey(BAdRecord record);
}