package cn.wtu.broadcast.openapi.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * socket 线程类
 * 
 */
public class SocketThread extends Observable implements Runnable {

	public Logger logger = LoggerFactory.getLogger(SocketThread.class);

	private ServerSocket serverSocket = null;

	private Map<String, String> paramsMap;

	public SocketThread(ServerSocket serverScoket, Integer port, Map<String, String> paramsMap) {
		this.paramsMap = paramsMap;
		try {
			if (serverSocket == null) {
				this.serverSocket = new ServerSocket(port);
				logger.info("调控服务器监听正常开启，监听端口为{}", port);
			}
		} catch (Exception e) {
			logger.error("SocketThread创建socket服务出错" + e.getMessage() + e);
			if (serverSocket != null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					logger.error("SocketThread关闭异常");
				}
			}
			doBusiness();
		}

	}

	@Override
	public void run() {
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				if (null != socket && !socket.isClosed()) {
					// 处理接受的数据
					SendIPThread sendIPThread = new SendIPThread(1, socket, paramsMap);
					new Thread(sendIPThread).start();
				}
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}
		}
	}
	
	/**
	 * 此方法一经调用，立马可以通知观察者，在本例中是监听线程
	 */
	private void doBusiness() {
		if (true) {
			super.setChanged();
		}
		notifyObservers();
	}

	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
				logger.info("调控服务器监听正常关闭");
			}
		} catch (IOException e) {
			logger.error(e.getMessage() + e);
		}
	}
}
