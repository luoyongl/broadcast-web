package com.wtu.sms;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;

import com.wtu.util.HttpUtil;
import com.wtu.util.Md5Util;

public class SendMsg {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(SendMsg.class);
	
	private static SimpleDateFormat datetampFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static void sendMessage(String phone,String no) throws UnsupportedEncodingException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String url = "http://120.55.193.51:8098/smtp/http/smsTemplate";
				String timestamp = datetampFormat.format(new Date());
				String userName = "whddzm";
				String pwd = "MMGxAnPSD807";
				String serviceCode = "whddzm";
				String proxyServiceCode = "";
				String sendTime = "" ;
				String mhtMsgIds = RandomStringUtils.randomAlphabetic(1);
				buildHttpParamasAndSend(url, timestamp, userName, pwd, serviceCode,sendTime, proxyServiceCode, phone, mhtMsgIds,no);
			}
		}).start();
		//String url = ConfigUtil.getConfig("msgUrl");
		
	}
	
	/**
	 * @Title: sendMessage @Description: 通过短信模板发送短信 @param @param
	 * tplCode @param @param phone @param @param
	 * paramMap @param @return @param @throws UnsupportedEncodingException
	 * 参数 @return String 返回类型 @throws
	 */
	public static String sendMessage(String tplCode, String phone, Map<String, String> paramMap)
			throws UnsupportedEncodingException {
		String url = "http://120.55.193.51:8098/smtp/http/smsTemplate";
		String timestamp = datetampFormat.format(new Date());
		String userName = "whddzm";
		String pwd = "MMGxAnPSD807";
		String serviceCode = "whddzm";
		String proxyServiceCode = "";
		String sendTime = "";
		String mhtMsgIds = RandomStringUtils.randomAlphabetic(1);

		return buildHttpParamasAndSend(tplCode, url, timestamp, userName, pwd, serviceCode, sendTime, proxyServiceCode,
				phone, mhtMsgIds, paramMap);
	}
	
	private static String buildHttpParamasAndSend(String url, String timestamp, String userName, String pwd, String serviceCode,String sendTime, String proxyServiceCode, String phones,
			String mhtMsgIds,String no) {
		        String result = "";
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("timestamp", timestamp));
			nameValuePairs.add(new BasicNameValuePair("userName", userName));
			nameValuePairs.add(new BasicNameValuePair("sign", Md5Util.getMd5String(pwd + timestamp)));
			nameValuePairs.add(new BasicNameValuePair("serviceCode", serviceCode));
			if (StringUtils.isNotBlank(proxyServiceCode)) {
				nameValuePairs.add(new BasicNameValuePair("proxyServiceCode", proxyServiceCode));
			}
			nameValuePairs.add(new BasicNameValuePair("phone", phones));
			nameValuePairs.add(new BasicNameValuePair("mhtMsgId", mhtMsgIds));
			nameValuePairs.add(new BasicNameValuePair("sendTime", sendTime));
			nameValuePairs.add(new BasicNameValuePair("priority", "5"));
			nameValuePairs.add(new BasicNameValuePair("orgCode", "test"));
			nameValuePairs.add(new BasicNameValuePair("msgType", "msgTyp"));
			nameValuePairs.add(new BasicNameValuePair("reportFlag", "1"));
			nameValuePairs.add(new BasicNameValuePair("tplCode", "whddzm781"));
			nameValuePairs.add(new BasicNameValuePair("tplParam", "code|"+no));

			result = HttpUtil.post(url, nameValuePairs, "GBK");
			System.out.println("response:" + result);
		} catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
		}
		logger.error("result:",result);
		return result;
	}
	
	/**
	 * @Title: buildHttpParamasAndSend @Description: 组装map到模板并发送短信 @param @param
	 * tplCode @param @param url @param @param timestamp @param @param
	 * userName @param @param pwd @param @param serviceCode @param @param
	 * sendTime @param @param proxyServiceCode @param @param
	 * phones @param @param mhtMsgIds @param @param paramMap @param @return
	 * 参数 @return String 返回类型 @throws
	 */
	private static String buildHttpParamasAndSend(String tplCode, String url, String timestamp, String userName,
			String pwd, String serviceCode, String sendTime, String proxyServiceCode, String phones, String mhtMsgIds,
			Map<String, String> paramMap) {
		String result = "";
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("timestamp", timestamp));
			nameValuePairs.add(new BasicNameValuePair("userName", userName));
			nameValuePairs.add(new BasicNameValuePair("sign", Md5Util.getMd5String(pwd + timestamp)));
			nameValuePairs.add(new BasicNameValuePair("serviceCode", serviceCode));
			if (StringUtils.isNotBlank(proxyServiceCode)) {
				nameValuePairs.add(new BasicNameValuePair("proxyServiceCode", proxyServiceCode));
			}
			nameValuePairs.add(new BasicNameValuePair("phone", phones));
			nameValuePairs.add(new BasicNameValuePair("mhtMsgId", mhtMsgIds));
			nameValuePairs.add(new BasicNameValuePair("sendTime", sendTime));
			nameValuePairs.add(new BasicNameValuePair("priority", "5"));
			nameValuePairs.add(new BasicNameValuePair("orgCode", "test"));
			nameValuePairs.add(new BasicNameValuePair("msgType", "msgTyp"));
			nameValuePairs.add(new BasicNameValuePair("reportFlag", "1"));
			nameValuePairs.add(new BasicNameValuePair("tplCode", tplCode));
			StringBuffer sb = new StringBuffer();
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				sb.append(",");
				sb.append(entry.getKey() + "|" + entry.getValue());
			}
			String tplParam = sb.substring(1, sb.length());

			nameValuePairs.add(new BasicNameValuePair("tplParam", tplParam));

			result = HttpUtil.post(url, nameValuePairs, "GBK");
			System.out.println("response:" + result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	public static void main(String[] args) {
	    try {
            sendMessage("15600060201333","123456" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
