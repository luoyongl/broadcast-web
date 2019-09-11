package cn.wtu.broadcast.controller;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.task.ReceiveOffLineThead;
import cn.wtu.broadcast.task.ReceiveThead;

/**
 * 观察者模式监听回传线程是否关闭，如果关闭，重新启动
 * @author Lenovo
 *
 */
public class ReceiveThreadListener implements Observer {
	
	private static Logger logger = LoggerFactory.getLogger(ReceiveThreadListener.class);

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof ReceiveThead){
			logger.info("ReceiveThead异常退出");
			ReceiveThead receiveThead = (ReceiveThead)arg0;
			receiveThead.addObserver(this);
	        new Thread(receiveThead).start();
	        logger.info("ReceiveThead重启成功");
		} else if (arg0 instanceof ReceiveOffLineThead) {
			logger.info("ReceiveOffLineThead异常退出");
			ReceiveOffLineThead receiveOffLineThead = (ReceiveOffLineThead)arg0;
			receiveOffLineThead.addObserver(this);
	        new Thread(receiveOffLineThead).start();
	        logger.info("ReceiveOffLineThead重启成功");
		}
		
	}
}