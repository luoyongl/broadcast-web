package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.model.BBroadcastTemp;
import cn.wtu.broadcast.openapi.vo.BBroadcastTempVO;
import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.service.api.ParentService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created on 11/03/2019 16:09
 *
 * @author LY
 */
public interface BBroadcastTempService extends ParentService<BBroadcastTemp> {

    public PageInfo<BBroadcastTempVO> queryPage(Map<String, Object> paramMap) throws BizException ;
}

