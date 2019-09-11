package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BDeviceReturnAudio;
import cn.wtu.broadcast.parent.service.api.ParentService;

import java.util.List;

/**
 * Created on 2019/1/22 18:07
 *
 * @author LY
 */
public interface BDeviceReturnAudioService extends ParentService<BDeviceReturnAudio> {
    public List<BDeviceReturnAudio> selectReturnAudio(Integer fId);
    
    /**
     * 音频数据的回填处理
     * @param bDeviceReturnAudio
     */
    public void insertReturnAudio(BDeviceReturnAudio bDeviceReturnAudio);

    public BDeviceReturnAudio selectAudioByte(Integer fId);
}

