/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable;

import cn.wtu.broadcast.openapi.ts.Tables.Tools;
import cn.wtu.broadcast.parent.utils.sign.Util;

/**
 * (2)区域码设置
 *
 * @author Administrator
 */
public class AddressSettingCmd extends ConfigureCmd {

    private final ConfigureCmd.CmdTag configureCmdTag;

    private byte terminal_Address_length;
    private byte[] terminal_Address;
    private byte logic_address_length;
    private byte[] logic_address;

    public AddressSettingCmd() {
        this.configureCmdTag = CmdTag.TerminalAddressSetting;
    }

    public void setPhysicalAddress(String PhysicalAddress) {
        terminal_Address =Util.hexStringToBytes(PhysicalAddress);
    }

    public void setLogicAddress(String LogicAddress) {
        if (LogicAddress.length() == 23) {//国标23字符，前4位填充‘0’
            LogicAddress = "0" + LogicAddress;
        }
        logic_address = Tools.StrToBCDBytes(LogicAddress);
    }

    @Override
    public int getSize() {
        int len = 3;
        configureCmdLength = 2;
        terminal_Address_length = 0;
        if (terminal_Address != null) {
            terminal_Address_length = (byte) terminal_Address.length;
            configureCmdLength += terminal_Address_length;
        }
        logic_address_length = 0;
        if (logic_address != null) {
            logic_address_length = (byte) logic_address.length;
            configureCmdLength += logic_address_length;
        }
        len += configureCmdLength;
        return len;
    }

    @Override
    public byte[] convertToBytes() {
        int offSet = 0;

        byte[] data = new byte[getSize()];
        data[offSet++] = configureCmdTag.getValue();
        data[offSet++] = (byte) (configureCmdLength >> 8);
        data[offSet++] = (byte) (configureCmdLength & 0xff);
        data[offSet++] = terminal_Address_length;
        if (terminal_Address != null) {
            System.arraycopy(terminal_Address, 0, data, offSet, terminal_Address.length);
            offSet += terminal_Address.length;
        }
        data[offSet++] = logic_address_length;
        if (logic_address != null) {
            System.arraycopy(logic_address, 0, data, offSet, logic_address.length);
            offSet += logic_address.length;
        }

        return data;
    }

}
