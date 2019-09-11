/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.descriptors;

public class CustomDescriptor extends Descriptors{

    private byte[] CustomData;
    public void setCustomData(byte[] data){
        CustomData=data;
    }
    @Override
    public int getSize() {
        setDescriptorLength((byte)CustomData.length);
        return 2+getDescriptorLength();
    }

    @Override
    public byte[] convertToBytes() {
        byte[] data=new byte[getSize()];
        int offSet=0;
        data[offSet++]=(byte)(getDescriptorTag().getValue());
        data[offSet++]=(byte)(getDescriptorLength());
        System.arraycopy(CustomData, 0, data, offSet, CustomData.length);
        return data;
        
    }
    
}