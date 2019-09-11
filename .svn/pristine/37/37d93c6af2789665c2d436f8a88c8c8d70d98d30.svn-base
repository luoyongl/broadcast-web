/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable;

import java.util.Calendar;
import java.util.Date;

/**
 * (1)时钟校准指令
 * @author Administrator
 */
public class TimeSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;
    private short year;
    private byte month;
    private byte day;
    private byte hour;
    private byte minute;
    private byte second;

    public TimeSettingCmd() {
        this.configureCmdTag = CmdTag.TimeSetting;
    }

    public void setTime(Date currTime) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(currTime);
        year = (short) (cal.get(Calendar.YEAR));
        month = (byte) (cal.get(Calendar.MONTH) + 1);
        day = (byte) (cal.get(Calendar.DAY_OF_MONTH));
        hour = (byte) (cal.get(Calendar.HOUR_OF_DAY));
        minute = (byte) (cal.get(Calendar.MINUTE));
        second = (byte) (cal.get(Calendar.SECOND));
    }
    
    @Override
    public int getSize() {
        configureCmdLength = 7;
        return 1 + 2 + configureCmdLength;
    }

    @Override
    public byte[] convertToBytes() {
        int offSet = 0;

        byte[] data = new byte[getSize()];
        data[offSet++] = configureCmdTag.getValue();
        data[offSet++] = (byte) (configureCmdLength >> 8);
        data[offSet++] = (byte) (configureCmdLength & 0xff);
        data[offSet++] = (byte) (year >>8);
        data[offSet++] = (byte) (year & 0xff);
        data[offSet++] = month;
        data[offSet++] = day;
        data[offSet++] = hour;
        data[offSet++] = minute;
        data[offSet++] = second;
        return data;
    }

	@Override
	public String toString() {
		return "TimeSettingCmd [configureCmdTag=" + configureCmdTag + ", year=" + year + ", month=" + month + ", day="
				+ day + ", hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}

}
