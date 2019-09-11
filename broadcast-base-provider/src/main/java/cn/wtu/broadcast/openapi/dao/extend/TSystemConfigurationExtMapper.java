package cn.wtu.broadcast.openapi.dao.extend;

import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.vo.EBCONTParamsVO;
import cn.wtu.broadcast.parent.vo.IpVO;

public interface TSystemConfigurationExtMapper extends DBInterface<TSystemConfiguration> {

	/**
	 * 获取平台私钥
	 * @return String
	 */
	EBCONTParamsVO getConfiguration();
	IpVO getPictureAdsConfiguration();
}
