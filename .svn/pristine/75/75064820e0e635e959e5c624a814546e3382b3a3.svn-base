package cn.wtu.broadcast.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import cn.wtu.broadcast.parent.vo.EBCONTParamsVO;
import cn.wtu.broadcast.util.EchoTCPServer;

/**
 * 将socket service随tomcat启动
 *
 */
public class SocketServiceLoader implements ServletContextListener {
	private EchoTCPServer echoTCPServer;
	
	public static Logger logger = LoggerFactory.getLogger(SocketServiceLoader.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if (echoTCPServer == null) {
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
			SystemConfigurationService systemConfigurationService = context.getBean(SystemConfigurationService.class);
			TSystemConfiguration systemConfiguration = systemConfigurationService.selectDataByCName("multicast_ip");
			String ipServerIP = systemConfiguration.getfConfigurationValue();
			TSystemConfiguration tsystemConfiguration = systemConfigurationService.selectDataByCName("platform_resource_code");
			EBCONTParamsVO ebCONTParamsVO = systemConfigurationService.getConfiguration();
			String platformResourceCode = tsystemConfiguration.getfConfigurationValue();
			String privateKey = ebCONTParamsVO.getPrivateKey();
			TSystemConfiguration port = systemConfigurationService.selectDataByCName("transmit_server_port");
			Integer serverPort = Integer.valueOf(port.getfConfigurationValue());
			TSystemConfiguration timeZoneSet = systemConfigurationService.selectDataByCName("timeZone_set");
			String timeZone = timeZoneSet.getfConfigurationValue();
			TSystemConfiguration tsPortSet = systemConfigurationService.selectDataByCName("ts_port");
			String tsPort = tsPortSet.getfConfigurationValue();
			TSystemConfiguration pidSet = systemConfigurationService.selectDataByCName("pid");
			String pid = pidSet.getfConfigurationValue();
			TSystemConfiguration ipMikePlayPortSet = systemConfigurationService.selectDataByCName("unicast_port");
			String ipMikePlayPort = ipMikePlayPortSet.getfConfigurationValue();
			TSystemConfiguration ipProtocalSet = systemConfigurationService.selectDataByCName("protocol_set");
			String ipProtocal = ipProtocalSet.getfConfigurationValue();
			SendIPUtils.paramsCache.put("platformResourceCode", platformResourceCode);
			SendIPUtils.paramsCache.put("privateKey", privateKey);
			SendIPUtils.paramsCache.put("ipServerIP", ipServerIP);
			SendIPUtils.paramsCache.put("timeZone", timeZone);
			SendIPUtils.paramsCache.put("pid", pid);
			SendIPUtils.paramsCache.put("tsPort", tsPort);
			SendIPUtils.paramsCache.put("ipMikePlayPort", ipMikePlayPort);
			SendIPUtils.paramsCache.put("ipProtocalSet", ipProtocal);
			// 新建线程类
			/*socketThread = new SocketThread(null, serverPort, paramsMap);
			SocketThreadListener listen = new SocketThreadListener();
			socketThread.addObserver(listen);
			new Thread(socketThread).start();*/
			try {
				// TODO 该值将设置到数据库中
				Integer readIdleTimeSecond = 15;
				echoTCPServer = new EchoTCPServer(serverPort, readIdleTimeSecond);
				new Thread(echoTCPServer).start();
			} catch (Exception e) {
				logger.error("初始化异常：" + e.getMessage() + e);
			}
		}
	}
}
