/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.wtu.broadcast.openapi.ts.Tables.Tools;
import cn.wtu.broadcast.parent.utils.sign.Util;

/**
 *
 * @author Administrator
 */
public class RecordExtractSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

    /**
     * 录音文件名称： 文件名为：B或S+开始录音日期时间+行政区域编码+终端编号。 B或S为ASCII码，1字节。
     * 开始录音时间：年月日时分秒其中年为4字节ASCII码，如2014，月日时分秒各为2字节ASCII码，共14字节ASCII字符串。
     * 行政区域编码：9字节的BCD码,例：B20180420153302061245022600000000
     */
    public String record_file_name;

    /**
     * 开始传输包序号：4字节整型数据
     */
    public int Start_package_num = 0;

    /**
     * 1：UDP 2：TCP 3~255：保留
     */
    public byte Audio_reback_mode = 0;

    /**
     * 音频回传服务器地址，4字节十六进制IP地址
     */
    public String Audio_reback_serverip;

    /**
     * 音频回传端口，大端模式
     */
    public short Audio_reback_port;

    /**
     * 要设置的终端编号的地址类型 1: 表示逻辑地址 2：表示物理地址 3~9：保留
     */
    private byte Address_type;

    private byte Terminal_number;

    private byte Address_length;

    private byte[] Terminal_address;

    public void setTermialAddress(byte AddrType, List<String> AddrList) {
        int offSet = 0;
        Address_type = AddrType;
        Terminal_number = (byte) (AddrList.size());
        if (Address_type == 1) {//逻辑地址
            Address_length = 9;
        } else {//物理地址
            Address_length = 1;
            for (String s : AddrList) {
                if (s.length() / 2 > Address_length) {
                    Address_length = (byte) (s.length() / 2);
                }
            }
        }

        byte[] data = new byte[256];
        for (String s : AddrList) {
            if (Address_type == 2) {
                while (s.length() / 2 < Address_length) {
                    s += "00";
                }
            }
            byte[] buf = Util.hexStringToBytes(s);
            System.arraycopy(buf, 0, data, offSet, buf.length);
            offSet += buf.length;
        }
        Terminal_address = new byte[offSet];
        System.arraycopy(data, 0, Terminal_address, 0, offSet);
    }

    public RecordExtractSettingCmd() {
        this.configureCmdTag = ConfigureCmd.CmdTag.RecordExtractSetting;
    }

    @Override
    public int getSize() {
        int len = 3;
        configureCmdLength = 38;
        if (Terminal_address != null) {
            configureCmdLength += Terminal_address.length;
        }
        return len + configureCmdLength;
    }

    @Override
    public byte[] convertToBytes() {
        int offSet = 0;
        try {
            byte[] data = new byte[getSize()];
            data[offSet++] = configureCmdTag.getValue();
            data[offSet++] = (byte) (configureCmdLength >> 8);
            data[offSet++] = (byte) (configureCmdLength & 0xff);
            String s = record_file_name.substring(0, 15);

            byte[] data1 = s.getBytes("US-ASCII");
            System.arraycopy(data1, 0, data, offSet, data1.length);
            offSet += data1.length;
            s = record_file_name.substring(15, record_file_name.length());
            data1 = Tools.StrToBCDBytes(s);
            System.arraycopy(data1, 0, data, offSet, data1.length);
            offSet += data1.length;

            data[offSet++] = (byte) ((Start_package_num >> 24) & 0xff);
            data[offSet++] = (byte) ((Start_package_num >> 16) & 0xff);
            data[offSet++] = (byte) ((Start_package_num >> 8) & 0xff);
            data[offSet++] = (byte) ((Start_package_num) & 0xff);
            data[offSet++] = Audio_reback_mode;
            String[] strs = Audio_reback_serverip.split("\\.");
            for (int i = 0; i < strs.length; i++) {
                data[offSet++] = (byte) Integer.parseInt(strs[i]);
            }
            data[offSet++] = (byte) (Audio_reback_port >> 8);
            data[offSet++] = (byte) (Audio_reback_port & 0xff);
            data[offSet++] = Address_type;
            data[offSet++] = Terminal_number;
            data[offSet++] = Address_length;
            if (Terminal_address != null) {
                System.arraycopy(Terminal_address, 0, data, offSet, Terminal_address.length);
            }
            return data;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RecordExtractSettingCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
