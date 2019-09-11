package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.BDeviceParameterSetService;
import cn.wtu.broadcast.openapi.dao.BDeviceParameterSetMapper;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSet;
import cn.wtu.broadcast.openapi.model.BDeviceParameterSetExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/1/26 10:28
 *
 * @author LY
 */
@Service
public class BDeviceParameterSetServiceImpl extends ParentServiceImpl<BDeviceParameterSet> implements BDeviceParameterSetService {

	@Autowired
	BDeviceParameterSetMapper bDeviceParameterSetMapper;

	@Override
	public Boolean updateByResourceId(BDeviceParameterSet bDeviceParameterSet) {
		BDeviceParameterSetExample example = new BDeviceParameterSetExample();
		example.createCriteria().andFDeviceResourceCodeEqualTo(bDeviceParameterSet.getfDeviceResourceCode());
		try {
			if (bDeviceParameterSetMapper.updateByExampleSelective(bDeviceParameterSet, example) > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public Boolean checkConfig(String resourceCode) {
		BDeviceParameterSetExample example = new BDeviceParameterSetExample();
		example.createCriteria().andFDeviceResourceCodeEqualTo(resourceCode);
		int list = bDeviceParameterSetMapper.countByExample(example);
		if (list>0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected DBInterface<BDeviceParameterSet> getDao() {
		return bDeviceParameterSetMapper;
	}
}
