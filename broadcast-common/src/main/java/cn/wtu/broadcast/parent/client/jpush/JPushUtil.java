package cn.wtu.broadcast.parent.client.jpush;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import io.netty.handler.codec.http.HttpMethod;

public class JPushUtil {
    protected static final Logger LOG = LoggerFactory.getLogger(JPushUtil.class);

    // demo App defined in resources/jpush-api.conf 
    protected static final String APP_KEY ="4bc99dd5b8f7d68312ea15f4";
    protected static final String MASTER_SECRET = "971bdfe75496962f29ed6337";
    protected static final String GROUP_PUSH_KEY = "73f2e088eac64b6a709a109f";
    protected static final String GROUP_MASTER_SECRET = "15add4399886e1eeb7222c77";
    
    public static final String TITLE = "Test from API example";
    public static final String ALERT = "Test from API Example - alert";
    public static final String MSG_CONTENT = "Test from API Example - msgContent";
    public static final String REGISTRATION_ID = "0900e8d85ef";
    public static final String TAG = "tag_api";
    public static long sendCount = 0;
    public static boolean apnsProduction = "1".equals(PropertiesUtil.getProperty("jpush.apnsProduction"))?true:false;
    
    
    /**
     * 通过别名推送，点对点
     * 
     * @param alias 别名
     * @param alert 通知显示内容
     * @param title 标题
     * @param BIZType 推送的业务类型（待定义）
     * @param extrasMap
     */
    public  static void sendAlias_android_and_ios(String alias,String alert,String title, String BIZType,Map<String,String> extrasMap) {
    	try {
            PushPayload payload = buildAlias_android_and_ios(alias, alert, title, BIZType, extrasMap);
//          sendPushWithCallback(payload);
            sendPush(payload);
		} catch (Exception e) {
            LOG.info("sendAlias_android_and_ios: " + e.getMessage());
		}
    }
    
    /**
     * 通过标签推送，群发
     * @param tag 标签
     * @param alert 通知显示内容
     * @param title 标题
     * @param BIZType 推送的业务类型（待定义）
     * @param extrasMap
     */
    public  void sendTag_android_and_ios(String tag,String alert,String title, String BIZType,Map<String,String> extrasMap) {
        PushPayload payload = buildTag_android_and_ios(tag, alert, title, BIZType, extrasMap);
//        sendPushWithCallback(payload);
        sendPush(payload);
    }


    // 异步接口发送请求
    @SuppressWarnings("unused")
    private  void sendPushWithCallback(PushPayload payload) {
        ClientConfig clientConfig = ClientConfig.getInstance();
        String host = (String) clientConfig.get(ClientConfig.PUSH_HOST_NAME);
        final NettyHttpClient client = new NettyHttpClient(ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET),
                null, clientConfig);
        try {
            URI uri = new URI(host + clientConfig.get(ClientConfig.PUSH_PATH));
            client.sendRequest(HttpMethod.POST, payload.toString(), uri, new NettyHttpClient.BaseCallback() {
                @Override
                public void onSucceed(ResponseWrapper responseWrapper) {
                    LOG.info("Got result: " + responseWrapper.responseContent);
                }
            });
        } catch (URISyntaxException e) {
            LOG.error(e.getMessage(),e);
        }
    }

    private static void sendPush(PushPayload payload) {
        ClientConfig clientConfig = ClientConfig.getInstance();
        final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            System.out.println(result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
    }
    
    public  void testSendPush() {
        ClientConfig clientConfig = ClientConfig.getInstance();
        final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        Map<String,String> map = new HashMap<>();
        map.put("wwwww", "1");
        map.put("notShowNoticeBoard","1");
        final PushPayload payload = buildAlias_android_and_ios("197", "alert123", "title456", "follow", map);
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            System.out.println(result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
    }
    
    /**
     * 组装推送内容
     * 
     * @param alias
     * @param alert
     * @param title
     * @param BIZType
     * @param extrasMap
     * @return
     */
    private static  PushPayload buildAlias_android_and_ios(String alias,String alert,String title, String BIZType,Map<String,String> extrasMap) {
    	if(alert.length()>50)
    	{
    		alert = alert.substring(0,50)+"...";
    	}
    	if(title.length()>50)
    	{
    		title = title.substring(0,50)+"...";
    	}
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("BIZType", BIZType);
        
        JsonObject noti = new JsonObject();
        noti.addProperty("title", title);
        noti.addProperty("body", alert);
        
        if(null != extrasMap && extrasMap.size() > 0){
            extras.putAll(extrasMap);
            String notShowNoticeBoard = extrasMap.get("notShowNoticeBoard");
            //如果notShowNoticeBoard有值，就不在通知栏显示
            if(StringUtils.isNotBlank(notShowNoticeBoard)){
                alert = "";
                noti = new JsonObject();
            }
        }
        
        Audience audience = null;
        if("ALL".equals(alias)){
            audience = Audience.all();
        }else{
            audience = Audience.alias(alias);
        }
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(audience)
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .addExtras(extras).build())
                        .addPlatformNotification(IosNotification.newBuilder().setAlert(noti)
                                .addExtras(extras).build())
                        .build())
                .setOptions(Options.newBuilder()
                                .setApnsProduction(apnsProduction)
                                .build())
                .build();
    }
    
    private  PushPayload buildTag_android_and_ios(String tag,String alert,String title, String BIZType,Map<String,String> extrasMap) {
    	if(alert.length()>50)
    	{
    		alert = alert.substring(0,50)+"...";
    	}
    	if(title.length()>50)
    	{
    		title = title.substring(0,50)+"...";
    	}
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("BIZType", BIZType);
        JsonObject noti = new JsonObject();
        noti.addProperty("title", title);
        noti.addProperty("body", alert);
        if(null != extrasMap && extrasMap.size() > 0){
            extras.putAll(extrasMap);
            String notShowNoticeBoard = extrasMap.get("notShowNoticeBoard");
            //如果notShowNoticeBoard有值，就不在通知栏显示
            if(StringUtils.isNotBlank(notShowNoticeBoard)){
                alert = "";
                noti = new JsonObject();
            }
        }
        Audience audience = null;
        if("ALL".equals(tag)){
            audience = Audience.all();
        }else{
            audience = Audience.tag(tag);
        }
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(audience)
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .addExtras(extras).build())
                        .addPlatformNotification(IosNotification.newBuilder().setAlert(noti)
                                .incrBadge(1)
                                .addExtras(extras).build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(apnsProduction)
                        .build())
                .build();
    }
    
    
    public static void main(String[] args) {
        JPushUtil JPushService = new JPushUtil();
//      testSendPushWithCustomConfig();
//      testSendIosAlert();
        JPushService.testSendPush();
//      testGetCidList();
//      testSendPushes();
//      testSendPush_fromJSON();
//      testSendPushWithCallback();
  }


}

