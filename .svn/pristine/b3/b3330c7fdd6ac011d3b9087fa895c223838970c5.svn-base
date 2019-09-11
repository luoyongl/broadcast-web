/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.descriptors;
// <editor-fold defaultstate="collapsed" desc="Audio_stream_descriptor">   

/**
 *
 * @author Administrator
 */
public class AudioStreamDescriptor extends Descriptors {

    /**
     * 1bit
     */
    private byte Free_format_flag = 1;

    /**
     * 1bit
     */
    private byte ID = 0;

    /**
     * 2bits
     */
    public byte Layer = 1;

    /**
     * 1bit
     */
    private byte Variable_rate_audio_indicator = 0;

    /**
     * 3bits
     */
    private byte Reserved = 0x7;

    @Override
    public int getSize() {
        super.setDescriptorLength((byte)1);
        return 3;
    }

    public AudioStreamDescriptor() {
        super.setDescriptorTag(Descriptors.DescriptorTag.Audio_stream_descriptor);
    }

    @Override
    public byte[] convertToBytes() {
        byte[] data = new byte[getSize()];
        int offSet = 0;
        data[offSet++] = (byte) (getDescriptorTag().getValue());
        data[offSet++] = (byte) (getDescriptorLength());
        data[offSet++] = (byte) (Free_format_flag << 7 | ID << 6 | Layer << 4 | Variable_rate_audio_indicator << 3 | Reserved);
        return data;
    }
}
// </editor-fold>  

