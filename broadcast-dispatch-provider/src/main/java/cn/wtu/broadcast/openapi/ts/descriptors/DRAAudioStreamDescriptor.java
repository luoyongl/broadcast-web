/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.descriptors;

// <editor-fold defaultstate="collapsed" desc="DRA_Audio_stream_descriptor"> 
public class DRAAudioStreamDescriptor extends Descriptors{

    @SuppressWarnings("static-access")
	public DRAAudioStreamDescriptor(){
        super.setDescriptorTag(DescriptorTag.Audio_stream_descriptor.DRA_Audio_stream_descriptor);
    }
    @Override
    public int getSize() {
       int len=2+2;
       
       if(text_present_flag==1){
           len+=textinfo.getSize();
       }
       if(language_present_flag==1){
           len+=3;
       }
       if(additional_info!=null){
           len+=additional_info.length;
       }
         super.setDescriptorLength((byte)(len-2));
     // descriptor_length=(byte)(len-2);
       return len;
    }

    @Override
    public byte[] convertToBytes() {
       byte[] data=new byte[getSize()];
       int offSet=0;
        data[offSet++] = (byte) (getDescriptorTag().getValue());
        data[offSet++] = (byte) (getDescriptorLength());
        data[offSet++]=(byte)((sample_rate_index<<4)|(num_normal_channels>>2));
        data[offSet++]=(byte)(((num_normal_channels&0x03)<<6)|(num_lfe_channels<<4)|(dra_version_flag<<3)|(text_present_flag<<2)|(language_present_flag<<1)|Reserved);
        if(text_present_flag==1){
            if(textinfo!=null){
            System.arraycopy(textinfo.convertToBytes(), 0, data, offSet, textinfo.getSize());
            offSet+=textinfo.getSize();
            }
        }
        if(language_present_flag==1){
            if(language!=null){
                System.arraycopy(language, 0, data, offSet, language.length);
                offSet+=language.length;
            }
        }
        if(additional_info!=null){
             System.arraycopy(additional_info, 0, data, offSet, additional_info.length);
        }
        return data;
    }
    
    /**
     * 采样率，8，4bits
     */
    private byte sample_rate_index=8;
    
    /**
     * 6bits
     */
    private byte num_normal_channels=1;
    
    /**
     * 2bits
     */
    private byte num_lfe_channels =1;
    
    /**
     * 1bit
     */
    private byte dra_version_flag=0;
    
    /**
     * 1bit
     */
    public byte text_present_flag;
    
    /**
     * 1bit
     */
    public byte language_present_flag;
    
    /**
     * 1bit
     */
    private byte Reserved=1;
    
    public TextInfo textinfo;
    public char[] language;
    public byte[] additional_info;
    
    public  class TextInfo{
        private byte text_length;
        public short[] text;
        
        public int getSize(){
            if(text!=null){
                text_length=(byte)(text.length);
            }else
            {
                text_length=0;
            }
            return 1+text_length*2;
        }
        public byte[] convertToBytes(){
            byte[] data=new byte[getSize()];
            int offSet=0;
            data[offSet++]=text_length;
            if(text!=null){
                for(int i=0;i<text.length;i++){
                    data[offSet++]=(byte)(text[i]>>8);
                    data[offSet++]=(byte)(text[i]&0xff);
                }
            }
            return data;
        }
    }
    
}

// </editor-fold>  
