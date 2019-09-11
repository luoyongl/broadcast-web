package cn.wtu.broadcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.BDeviceReturnAudioService;
import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.task.ReceiveOffLineThead;
import cn.wtu.broadcast.task.ReceiveThead;

/**
 * 
    * @ClassName: StartupListener
    * @Description: 启动监听器
    * @author huangjiakui
    * @date 2018年12月04日
    *
 */
@Controller
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>  {
	
	private static Logger logger = LoggerFactory.getLogger(StartupListener.class);
	
	@Autowired
	private BDeviceInfoService bdeviceInfoService;
	
	@Autowired
	private SystemConfigurationService systemConfigurationService;
	
	@Autowired
	private BDeviceReturnAudioService bDeviceReturnAudioService;
	
	@Autowired
	private BBroadcastDeviceService bBroadcastDeviceService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			// 启动回传服务器后自动将所有设备更新为离线状态，后面有回传的再将具体状态更新即可
			bdeviceInfoService.updateAllDeceiveState();
			
			logger.info("-----------UDP回传接受线程启动开始-----------");
			ReceiveThead receiveThead = new ReceiveThead(bdeviceInfoService, systemConfigurationService,
					bDeviceReturnAudioService, bBroadcastDeviceService);
			ReceiveThreadListener listen = new ReceiveThreadListener();
			receiveThead.addObserver(listen);
			new Thread(receiveThead).start();
			logger.info("-----------UDP回传接受线程启动结束-----------");
			
			logger.info("-----------UDP回传离线判断线程启动开始-----------");
			ReceiveOffLineThead receiveOffLineThead = new ReceiveOffLineThead(bdeviceInfoService);
			receiveOffLineThead.addObserver(listen);
			new Thread(receiveOffLineThead).start();
			logger.info("-----------UDP回传离线判断线程启动结束-----------");
	    }
	}
	
}