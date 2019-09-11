package cn.wtu.broadcast.openapi.dao;

import java.util.List;
import java.util.Map;

import cn.wtu.broadcast.openapi.vo.TransmitterVO;

public interface TransmitterMapper {
	
	List<TransmitterVO> queryAllTransmitterInfo(Map<String, Object> paramMap);
	
	int insertTransmitterInfo(TransmitterVO transmitterVO);
	
	int updateTransmitterInfo(TransmitterVO transmitterVO);
	
	int deleteTransmitterInfo(String transmitterId);

}
