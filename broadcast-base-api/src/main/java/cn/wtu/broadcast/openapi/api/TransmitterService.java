package cn.wtu.broadcast.openapi.api;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import cn.wtu.broadcast.openapi.vo.TransmitterVO;

public interface TransmitterService {
	
	
	PageInfo<TransmitterVO> queryAllTransmitterInfo(Map<String, Object> paramMap);
	
	int insertTransmitterInfo(TransmitterVO transmitterVO);
	
	int updateTransmitterInfo(TransmitterVO transmitterVO);
	
	int deleteTransmitterInfo(String transmitterId);

}
