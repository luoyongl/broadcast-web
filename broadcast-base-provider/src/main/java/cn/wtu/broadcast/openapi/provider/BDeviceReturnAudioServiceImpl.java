package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.BDeviceReturnAudioService;
import cn.wtu.broadcast.openapi.dao.BDeviceReturnAudioMapper;
import cn.wtu.broadcast.openapi.model.BDeviceReturnAudio;
import cn.wtu.broadcast.openapi.model.BDeviceReturnAudioExample;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/1/22 18:11
 *
 * @author LY
 */

@Service
public class BDeviceReturnAudioServiceImpl extends ParentServiceImpl<BDeviceReturnAudio> implements BDeviceReturnAudioService {

    @Autowired
    private BDeviceReturnAudioMapper bDeviceReturnAudioMapper;

    @Override
    public List<BDeviceReturnAudio> selectReturnAudio(Integer fId) {
        BDeviceReturnAudioExample example=new BDeviceReturnAudioExample();
        example.createCriteria().andFDeviceIdEqualTo(fId);
        return bDeviceReturnAudioMapper.selectByExample(example);
    }

    @Override
    protected DBInterface<BDeviceReturnAudio> getDao() {
        return bDeviceReturnAudioMapper;
    }

	@Override
	public void insertReturnAudio(BDeviceReturnAudio bDeviceReturnAudio) {
		bDeviceReturnAudioMapper.insertSelective(bDeviceReturnAudio);
	}

    @Override
    public BDeviceReturnAudio selectAudioByte(Integer fId) {
        return bDeviceReturnAudioMapper.selectByPrimaryKey(fId);
    }
}
