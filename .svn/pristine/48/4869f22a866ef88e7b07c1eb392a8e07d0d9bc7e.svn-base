package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.parent.vo.EBITParamsVO;
import cn.wtu.broadcast.parent.vo.IpVO;

/**
 * 广播数据表和定时广播表统一业务层service
 * @author lxg
 * @date 2019/1/14
 */
public interface ThirdBroadcastDataService {

    /**
     *根据广播类型和广播Id查询数据
     *
     * @param Integer broadcastType,Integer fId
     * @return EBITParamsVO
     */
	EBITParamsVO getModelByBroadcastTypeAndId(Integer broadcastType,Integer fId);
	
	IpVO getIpModelByBroadcastTypeAndId(Integer broadcastType,Integer fId);
	int insertProvincialEBM(EBITParamsVO paramsVO);
}
