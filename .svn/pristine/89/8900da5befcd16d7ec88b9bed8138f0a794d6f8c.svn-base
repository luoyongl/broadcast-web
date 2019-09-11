package cn.wtu.broadcast.openapi.provider;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.AdRecordService;
import cn.wtu.broadcast.openapi.dao.BAdRecordMapper;
import cn.wtu.broadcast.openapi.model.BAdRecord;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;

@Service("adRecordService")
public class AdRecordServiceImpl extends ParentServiceImpl<BAdRecord> implements AdRecordService {
	@Autowired
	private BAdRecordMapper bAdRecordMapper;
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AdRecordServiceImpl.class);

	@Override
	public boolean insertAdRecord(BAdRecord adRecord) {
		boolean result = false;
		TUser sessionUser = getSessionUser();
		Date time = new Date();
		try {

			adRecord.setfCreateId(sessionUser.getfId());
			adRecord.setfDeleteFlag(false);
			adRecord.setfCreateTime(time);
			adRecord.setfState((byte)0); //0代表停止
			if (bAdRecordMapper.insertSelective(adRecord) == 1) {
				result = true;
				insertLog(OperationLogTypeEnum.INSERT, "新增图文广告", "成功");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	protected DBInterface<BAdRecord> getDao() {
		return bAdRecordMapper;
	}

}
