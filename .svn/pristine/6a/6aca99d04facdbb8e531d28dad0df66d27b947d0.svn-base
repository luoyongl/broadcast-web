package com.wtu.sms;

public enum SMSSceneEnum {   
    // 商家认证成功短信模板
    merchant_authentication_succ_cn(5, "whddzm905"),
	merchant_authentication_succ_en(6, "whddzm906");

	private int key;
	private String tplCode;

	private SMSSceneEnum(int key, String tplCode) {
		this.setKey(key);
		this.setTplCode(tplCode);
	}
	
	public static String getTplCodeByKey(int key) {
		for (SMSSceneEnum c : SMSSceneEnum.values()) {
			if (c.getKey() == key) {
				return c.tplCode;
			}
		}
		return null;
	}
	
	public String getTplCode() {
		return tplCode;
	}

	public void setTplCode(String tplCode) {
		this.tplCode = tplCode;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
