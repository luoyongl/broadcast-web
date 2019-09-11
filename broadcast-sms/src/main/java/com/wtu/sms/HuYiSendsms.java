package com.wtu.sms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.wtu.util.HttpUtil;

public class HuYiSendsms {
    public static String sendMessage(String phone, String mobile_code) {
        String url = "http://api.isms.ihuyi.com/webservice/isms.php?method=Submit";
        String account ="I36851878";
        String password = "af5d924070222cb3adb613ccc02c23a6";
        String result = "";
        SimpleDateFormat datetampFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = datetampFormat.format(new Date());
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("timestamp", timestamp));
        nameValuePairs.add(new BasicNameValuePair("account", account));
        nameValuePairs.add(new BasicNameValuePair("password", password));
        nameValuePairs.add(new BasicNameValuePair("mobile", phone));
        nameValuePairs.add(new BasicNameValuePair("content", "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"));
        System.out.println("=======================================start send");
        result = HttpUtil.post(url, nameValuePairs, "GBK");
        System.out.println("response:" + result);
        System.out.println("=======================================over send " );
        return result;
    }

}