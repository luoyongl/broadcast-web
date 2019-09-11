/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.descriptors;

/**
 *
 * @author Administrator
 */
public abstract class Descriptors {

    public enum DescriptorTag {
        /**
         * DTMB描述子
         */
        Terrestrial_Delivery_System_Descriptor((byte) 0x5A),
        /**
         * DVB-c有线描述子
         */
        Cable_Delivery_System_Descriptor((byte) 0x44),

        /**
         * 应急音频流描述
         */
        Audio_stream_descriptor((byte)3),
        
        /**
         * 
         */
        DRA_Audio_stream_descriptor((byte)0xA0),
        ;
        private DescriptorTag(byte value) {
            this.value = value;
        }

        private byte value;

        public byte getValue() {

            return this.value;

        }

    }

    public void setDescriptorTag(DescriptorTag descriptorTag) {
        this.descriptorTag = descriptorTag;
    }
    protected DescriptorTag getDescriptorTag(){
        return descriptorTag;
    }

    private DescriptorTag descriptorTag;
    
    private byte descriptorLength;
    protected void setDescriptorLength(byte value) {
        this.descriptorLength = value;
    }
    protected byte getDescriptorLength(){
        return descriptorLength;
    }
    
    public abstract int getSize();

    public abstract byte[] convertToBytes();
}
