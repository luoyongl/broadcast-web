package cn.wtu.broadcast.task;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;

public class ReceiveOffLineThead extends Observable implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(ReceiveOffLineThead.class);
	
	private BDeviceInfoService bdeviceInfoService;
	
	public ReceiveOffLineThead (BDeviceInfoService bdeviceInfoService) {
		this.bdeviceInfoService = bdeviceInfoService;
	};
	
	@Override
	public synchronized void run() {
		try {
			while(true){
				Map<String, Date> receiveDateTimeMap = ReceiveThead.receiveDateTimeMap;
				if(receiveDateTimeMap != null){
					Iterator<Map.Entry<String, Date>> iterator = receiveDateTimeMap.entrySet().iterator();
					while(iterator.hasNext()){
			            Map.Entry<String, Date> entry = iterator.next();
			            String key = entry.getKey();
			            Date receiveDate = receiveDateTimeMap.get(key);
						long between = (new Date().getTime() - receiveDate.getTime())/1000;
						// 如果大于10秒，就更新对应的设备为离线
						if(between > 10){
							Boolean updateResult = bdeviceInfoService.updateDeviceStateBySourceCode(key, Byte.valueOf(String.valueOf(DeviceStateEnum.offline.getCode())));
							logger.error("设备{}更新为离线处理结果：{}", key, updateResult);
							iterator.remove();    
						}
			        }
				}
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			doBusiness();
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

}
