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
public class FreqSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

    public FreqSettingCmd() {
        this.configureCmdTag = CmdTag.FreqSetting;
    }
/**
 * 1: DTMB
2: DVB-C
 */
    public byte DTMBorDVBC;
    
    /**
     * 单位：KHZ
     */
    public int Freq;
    
    /**
     * 符号率(KBPS)(采用十六进制)
     */
    public int SymbolRate;
    
    /**
     * QAM值:  
0: QAM16 
1: QAM32 
2: QAM64 
3: QAM128 
4: QAM256 
     */
    public byte QAM;
    
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

    public int getSize() {
         int len = 3;
        configureCmdLength = 13;
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
        data[offSet++] = DTMBorDVBC;
        data[offSet++] = (byte)((Freq>>24)&0xff);
        data[offSet++] = (byte)((Freq>>16)&0xff);
        data[offSet++] = (byte)((Freq>>8)&0xff);
        data[offSet++] = (byte)((Freq)&0xff); 
        data[offSet++] = (byte)((SymbolRate>>24)&0xff);
        data[offSet++] = (byte)((SymbolRate>>16)&0xff);
        data[offSet++] = (byte)((SymbolRate>>8)&0xff);
        data[offSet++] = (byte)((SymbolRate)&0xff); 
        data[offSet++] = QAM; 
        data[offSet++] = Address_type;
        data[offSet++] = Terminal_number;
        data[offSet++] = Address_length;
        if (Terminal_address != null) {
            System.arraycopy(Terminal_address, 0, data, offSet, Terminal_address.length);
        }
        return data;
    }
}
