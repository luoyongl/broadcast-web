/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable;

import java.util.List;

import cn.wtu.broadcast.parent.utils.sign.Util;

/**
 *
 * @author Administrator
 */
public class AudioRebackSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

 

    /**
     * 1：ON
2：OFF
     */
    public byte kaiguan = 1;

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

    public AudioRebackSettingCmd() {
        this.configureCmdTag = ConfigureCmd.CmdTag.AudioRebackSetting;
    }

    @Override
    public int getSize() {
        int len = 3;
        configureCmdLength = 11;
        if (Terminal_address != null) {
            configureCmdLength += Terminal_address.length;
        }
        return len + configureCmdLength;
    }

    @Override
    public byte[] convertToBytes() {
        int offSet = 0;
        byte[] data = new byte[getSize()];
        data[offSet++] = configureCmdTag.getValue();
        data[offSet++] = (byte) (configureCmdLength >> 8);
        data[offSet++] = (byte) (configureCmdLength & 0xff);
        data[offSet++]=kaiguan;
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
    }

}
