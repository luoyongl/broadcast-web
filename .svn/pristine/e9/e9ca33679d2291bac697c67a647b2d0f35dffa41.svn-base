package cn.wtu.broadcast.openapi.provider;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.wtu.broadcast.openapi.dao.TransmitterMapper;
import cn.wtu.broadcast.openapi.api.TransmitterService;
import cn.wtu.broadcast.openapi.vo.TransmitterVO;

@Service
public class TransmitterServiceImpl implements TransmitterService{

	public static Logger logger=LoggerFactory.getLogger(TransmitterServiceImpl.class);
	@Autowired
	private TransmitterMapper TransmitterMapper;
	@Override
	public PageInfo<TransmitterVO> queryAllTransmitterInfo(Map<String, Object> paramMap) {
		List<TransmitterVO> list=null;
 		try {
 			PageHelper.startPage((Integer) paramMap.get("pageNumber"),(Integer) paramMap.get("pageSize"));
	 		list =TransmitterMapper.queryAllTransmitterInfo(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        return new PageInfo<TransmitterVO>(list);
	}

	@Override
	public int insertTransmitterInfo(TransmitterVO transmitterVO) {
		int rsInt = TransmitterMapper.insertTransmitterInfo(transmitterVO);
		return rsInt;
	}

	@Override
	public int updateTransmitterInfo(TransmitterVO transmitterVO) {
		int rsInt = TransmitterMapper.updateTransmitterInfo(transmitterVO);
		return rsInt;
	}

	@Override
	public int deleteTransmitterInfo(String transmitterId) {
		int rsInt = TransmitterMapper.deleteTransmitterInfo(transmitterId);
		return rsInt;
	}

}
