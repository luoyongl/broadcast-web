/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable;

/**
 *
 * @author Administrator
 */
public abstract class ConfigureCmd {
    public enum CmdTag {
        /**
         * 时钟校准
         */
        TimeSetting((byte) 0x01),
        /**
         * (区域码设置
         */
        TerminalAddressSetting((byte) 0x02),

        /**
         * (3)工作模式设置
         */
        TerminalworkmodeSetting((byte)0x03),
        
        /**
         * (4)锁定频率设置
         */
        FreqSetting((byte)0x04),
        
        /**
         * (5)设置回传方式及回传地址
         */
        RebackTypeAndAddressSetting((byte)0x05),
        
        /**
         * (6)设置默认音量
         */
        ColumnSetting((byte)0x06),
        
        /**
         * (7)设置回传周期
         */
        RebackPeriodSetting((byte)0x07),
        
        /**
         * (8)终端采用RDS传输方式进行设置
         */
        RDSSetinig((byte)0x08),
        
        /**
         * (9)终端巡检设置
         */
        TerminalInspectSetting((byte)0x09),
        
        /**
         * (10)终端控制PID设置
         */
        TerminalPIDSetting((byte)0x10),
        
        /**
         * (11)录音文件提取
         */
        RecordExtractSetting((byte)0x11),
        
        /**
         * (12)音频实时回传
         */
        AudioRebackSetting((byte)0x12)
        ;
        private CmdTag(byte value) {
            this.value = value;
        }

        private byte value;

        public byte getValue() {

            return this.value;

        }

    }
    protected CmdTag configureCmdTag;
    protected short configureCmdLength;
    
    public abstract int getSize();

    public abstract byte[] convertToBytes();
    
}
