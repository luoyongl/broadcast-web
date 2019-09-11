package cn.wtu.broadcast.controller;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.thread.SocketThread;

/**
 * 观察者模式监听线程是否关闭，如果关闭，重新启动
 * @author Lenovo
 *
 */
public class SocketThreadListener implements Observer {
	
	private static Logger logger = LoggerFactory.getLogger(SocketThreadListener.class);

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof SocketThread){
			logger.info("SocketThread异常退出");
			SocketThread socketThread = (SocketThread)arg0;
			socketThread.addObserver(this);
	        new Thread(socketThread).start();
	        logger.info("SocketThread重启成功");
		}
		
	}
}