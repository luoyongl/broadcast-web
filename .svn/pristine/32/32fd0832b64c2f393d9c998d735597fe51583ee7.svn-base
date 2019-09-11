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

import cn.wtu.broadcast.parent.utils.sign.Util;

/**
 *
 * @author Administrator
 */
public class RebackTypeAndAddressSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

    /**
     * 回传方式 1：短信，地址为11个数字电话号码 2：IP通道，使用UDP协议，固定服务器ip地址回传
     * 3：IP通道，使用UDP协议，域名服务器地址回传 4：IP通道，使用TCP协议，固定服务器ip地址回传
     * 5：IP通道，使用TCP协议，域名服务器地址回传 6：GPRS通道，使用UDP协议，固定服务器ip地址回传
     * 7：GPRS通道，使用UDP协议，域名服务器地址回传 8：GPRS通道，使用TCP协议，固定服务器ip地址回传
     * 9：GPRS通道，使用TCP协议，域名服务器地址回传 10~255：保留
     */
    public byte reback_type;

    /**
     * 回传地址参数长度
     */
    public byte reback_address_length;

    /**
     * reback_type=1时有效，其他值无效，无该字段(采用ASCII字符)
     */
    public String reback_tel_number;

    /**
     * IP地址1，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)
     */
    public String reback_IP_address1;

    /**
     * IP地址1，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)
     */
    public String reback_IP_address2;

    /**
     * 端口号1，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)
     */
    public short reback_IP_port1;

    /**
     * 端口号2，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)
     */
    public short reback_IP_port2;

    /**
     * 域名，reback_type=3时，该字段有效，reback_type为其他值时，无该字段
     */
    public String reback_domain_name;

    /**
     * 端口号，reback_type=3时，该字段有效，reback_type为其他值时，无该字段
     */
    public short reback_domain_nameport;

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
        }
        else {//物理地址
            Address_length=1;
            for(String s:AddrList){
                if(s.length()/2>Address_length){
                   Address_length=(byte) (s.length()/2);
                }
            }
        }
        
        byte[] data = new byte[256];
        for (String s : AddrList) {
            if(Address_type==2){
                while(s.length()/2<Address_length){
                    s+="00";
                }
            }
           byte[] buf = Util.hexStringToBytes(s);
            System.arraycopy(buf, 0, data, offSet, buf.length);
            offSet += buf.length;
        }
        Terminal_address = new byte[offSet];
        System.arraycopy(data, 0, Terminal_address, 0, offSet);
    }


    public RebackTypeAndAddressSettingCmd() {
        this.configureCmdTag = CmdTag.RebackTypeAndAddressSetting;
    }

    @Override
    public int getSize() {
        int len = 3;
        configureCmdLength = 2;
        switch (reback_type) {
            case 1:
                reback_address_length = 11;
                break;
            case 2:
            case 4:
            case 6:
            case 8:
                reback_address_length = 12;
                break;
            case 3:
            case 5:
            case 7:
                try {
                    reback_address_length = (byte) (reback_domain_name.getBytes("US-ASCII").length + 2);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(RebackTypeAndAddressSettingCmd.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            default:
                break;
        }
        reback_address_length+=3;
        if (Terminal_address != null) {
            reback_address_length += Terminal_address.length;
        }
        
        configureCmdLength += reback_address_length;
      //  configureCmdLength += 3;
      //  if (Terminal_address != null) {
      //      configureCmdLength += Terminal_address.length;
       // }
        return len + configureCmdLength;
    }

    @Override
    public byte[] convertToBytes() {
        byte[] data = new byte[getSize()];
        int offSet = 0;
        data[offSet++] = configureCmdTag.getValue();
        data[offSet++] = (byte) (configureCmdLength >> 8);
        data[offSet++] = (byte) (configureCmdLength & 0xff);

        data[offSet++] = reback_type;
        data[offSet++] = reback_address_length;
        switch (reback_type) {
            case 1:
                try {
                    byte[] buf = reback_tel_number.getBytes("US-ASCII");
                    System.arraycopy(buf, 0, data, offSet, buf.length);
                    offSet += buf.length;
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(RebackTypeAndAddressSettingCmd.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case 2:
            case 4:
            case 6:
            case 8:
                String[] strs = reback_IP_address1.split("\\.");
                for (int i = 0; i < strs.length; i++) {
                    data[offSet++] = (byte) Integer.parseInt(strs[i]);
                }   strs = reback_IP_address2.split("\\.");
                for (int i = 0; i < strs.length; i++) {
                    data[offSet++] = (byte) Integer.parseInt(strs[i]);
                }   data[offSet++] = (byte) (reback_IP_port1 >> 8);
                data[offSet++] = (byte) (reback_IP_port1 & 0xff);
                data[offSet++] = (byte) (reback_IP_port2 >> 8);
                data[offSet++] = (byte) (reback_IP_port2 & 0xff);
                break;
            case 3:
            case 5:
            case 7:
                byte[] buf;
                try {
                    buf = reback_domain_name.getBytes("US-ASCII");
                    System.arraycopy(buf, 0, data, offSet, buf.length);
                    offSet += buf.length;
                    data[offSet++] = (byte) (reback_domain_nameport >> 8);
                    data[offSet++] = (byte) (reback_domain_nameport & 0xff);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(RebackTypeAndAddressSettingCmd.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            default:
                break;
        }
        data[offSet++] = Address_type;
        data[offSet++] = Terminal_number;
        data[offSet++] = Address_length;
        if (Terminal_address != null) {
            System.arraycopy(Terminal_address, 0, data, offSet, Terminal_address.length);
        }
        return data;
    }

}
