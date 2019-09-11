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
public class RDSSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

    /**
     * 需要设置的终端类型：
		1：应急广播适配器
		2：收扩机
		3：音柱
		4：应急广播适配器 + 收扩机 + 音柱
		4~9：保留
     */
    public byte Terminal_rds_set;

    /**
     * RDS指令长度
     */
    private byte Terminal_rds_length;
    
    /**
     * RDS编码指令数据
     */
    public byte[] Terminal_rds_data;
    
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

    public RDSSettingCmd() {
        this.configureCmdTag = ConfigureCmd.CmdTag.RDSSetinig;
    }

    @Override
    public int getSize() {
        int len = 3;
        configureCmdLength = 5;
        
        Terminal_rds_length=0;
        if(Terminal_rds_data!=null){
           Terminal_rds_length=(byte)(Terminal_rds_data.length); 
           configureCmdLength+=Terminal_rds_length;
        }
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
        data[offSet++]=Terminal_rds_set;
        data[offSet++]=Terminal_rds_length;
        if(Terminal_rds_data!=null){
           System.arraycopy(Terminal_rds_data,0,data,offSet,Terminal_rds_length);
           offSet+=Terminal_rds_length;
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
