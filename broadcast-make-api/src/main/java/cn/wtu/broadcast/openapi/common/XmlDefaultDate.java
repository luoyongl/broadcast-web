package cn.wtu.broadcast.openapi.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlDefaultDate {

	private static Logger logger = LoggerFactory.getLogger(XmlDefaultDate.class);
	
	public static Date getDefaultDate() {
		Date defaultDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setTime(0);
		try {
			defaultDate = sdf.parse(sdf.format(date));
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

		return defaultDate;
	}
}