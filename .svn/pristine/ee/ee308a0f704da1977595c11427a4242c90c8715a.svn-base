package cn.wtu.broadcast.openapi.thread;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.utils.FfmpegUtil;

/**
 * 采用2个线程进行，一个发送umtTsPack,一个发送udtTsFileName文件数据，发送一包umt数据，发10包udt数据
 * @author lxg
 *
 */
public class TsDeviceUpdateThread implements Runnable {
	
	  public Logger logger = LoggerFactory.getLogger(TsDeviceUpdateThread.class);
	  
		/**
		 * 1:发送umtTsPack的线程 2：udtTsFileName文件数据的线程
		 */
		private int type;

		/**
		 * umtTs包
		 * @author lxg
		 * @since 2019-04-03
		 */
		private byte[] umtTsPackage;
		
		/**
		 * udtUrlSuffix   ts设备升级文件  http://......
		 * @author lxg
		 * @since 2019-04-03
		 */
		private String udtUrlSuffix;
		

		public TsDeviceUpdateThread(int type,byte[] umtTsPackage) {
			this.type = type;
			this.umtTsPackage=umtTsPackage;
		};
		
		public TsDeviceUpdateThread(int type,String udtUrlSuffix) {
			this.type = type;
			this.udtUrlSuffix=udtUrlSuffix;
		};
		

		@Override
		public synchronized void run() {
			
			if (type == 1) {
				    //发送umtTs包
					try {
						UDPUtil.udpSend(umtTsPackage, umtTsPackage.length, "10.177.3.164",8888);
					} catch (IOException e) {
						logger.error(e.getMessage() + e);
					} catch (InterruptedException e) {
						logger.error(e.getMessage() + e);
					}

				}else if (type == 2) {
					for (int i=0;i<10;i++) {
						//System.out.println("type == 2-------------------------");
						//TODO 发送udtTsFileName文件数据
						FfmpegUtil.sendTsUploadFile(udtUrlSuffix);
					}
			}
		}
		
/*		public synchronized void run() {
			
			if (type == 1) {
				    //发送umtTs包
					System.out.println("type == 1-------------------------");
				}else if (type == 2) {
					for (int i=0;i<10;i++) {
						//发送udtTsFileName文件数据
						System.out.println("type == 2-------------------------");
					}
			}
		}*/
}
