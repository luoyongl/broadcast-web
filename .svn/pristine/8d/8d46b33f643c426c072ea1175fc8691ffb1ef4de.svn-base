package com.wtu.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static ThreadLocal<DateFormat> DEFAULT_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    private static ThreadLocal<DateFormat> yyyyMMddHHmmss_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };
    
    private static ThreadLocal<DateFormat> yyMMddHHmmss_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyMMddHHmmss");
        }
    };
    
    private static ThreadLocal<DateFormat> yyMMddHHmm_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyMMddHHmm");
        }
    };
    
    private static ThreadLocal<DateFormat> MMddHHmmss_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MMddHHmmss");
        }
    };
    
    
    private static ThreadLocal<DateFormat> chinese_style_DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    
    public static Date parse(String dateStr) throws ParseException {
        return DEFAULT_DATE_FORMAT.get().parse(dateStr);
    }
    
    
    public static Date parseYyyyMMddHHmmss(String dateStr)   {
        try {
			return yyyyMMddHHmmss_DATE_FORMAT.get().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null ;
    }
    

    public static String format(Date date) {
        return DEFAULT_DATE_FORMAT.get().format(date);
    }
    
    public static String format(Date date,String format) {
        return new SimpleDateFormat(format).format(date);
    }
    
    /**
     * 获取yyyyMMddHHmmss格式的日期的字符串表示
     * @param date
     * @return
     */
    public static String get_yyyyMMddHHmmss(Date date) {
        return yyyyMMddHHmmss_DATE_FORMAT.get().format(date);
    }
    
    public static String get_yyyyMMddHHmmss() {
        return get_yyyyMMddHHmmss(new Date());
    }
    
    public static String get_yyMMddHHmmss() {
        return yyMMddHHmmss_DATE_FORMAT.get().format(new Date());
    }
    
    public static String get_yyMMddHHmmss(Date date) {
        return yyMMddHHmmss_DATE_FORMAT.get().format(new Date());
    }
    
    public static String get_yyMMddHHmm() {
        return yyMMddHHmm_DATE_FORMAT.get().format(new Date());
    }
    
    public static String get_MMddHHmmss() {
        return MMddHHmmss_DATE_FORMAT.get().format(new Date());
    }
    
    public static Timestamp getSqlTimeStamp() {
        return new Timestamp(new Date().getTime());
    }
    
    
    public static String get_chinese_style_date_format() {
        return chinese_style_DATE_FORMAT.get().format(new Date());
    }
    
    
	public static String getSpecifiedDay(String specifiedDay, int after) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			date = simpleDateFormat.parse(specifiedDay);
			c.setTime(date);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE, day + after);

			String dayAfter = simpleDateFormat.format(c.getTime());
			return dayAfter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}