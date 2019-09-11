package cn.wtu.broadcast.openapi.ts.Tables;

import java.util.ArrayList;
import java.util.List;

import cn.wtu.broadcast.openapi.ts.descriptors.CustomDescriptor;

@SuppressWarnings("unused")
public class UMT  extends BaseTable{
	  /**
     * 8bits
     */
    private final byte tableID = (byte) 0xC3;

    /**
     * 1bit
     */
    private final byte sectionSyntaxIndicator = 1;

    /**
     * 1bit
     */
    private final byte zero = 0;

    /**
     * 2bits
     */
    private final byte reserverd1 = 0x01;

    /**
     * 12bits
     */
    private short sectionLength;

    private short table_id_extension = 0;

    private byte reserved2 = 0x03;

    public byte versionnumber = 0;

    private byte current_next_indicator = 1;

    public byte section_number;

    public byte last_section_number;
    
    private short descriptors_number;
    
    public ArrayList<Upgrade_Descriptor> UpgradeDescriptors=new  ArrayList<Upgrade_Descriptor>();
    
    public static  class  Upgrade_Descriptor{
       private byte  descriptor_tag =(byte) 0xCE;
       private short descriptor_length;
        private byte EBM_resource_number = 0;
        private ArrayList<byte[]> EBM_resource_codes=new ArrayList<byte[]>();
       private byte pack_number;
       
        public ArrayList<PackInfo> packInfos=new ArrayList<PackInfo>();
       public static class PackInfo{
           /**
            * 厂商编号
            */
           public short Manufaturer_number;
           
           public short hardware_version ;
           
            public byte[] software_version ;
            
            public int getSize(){
                return 2+2+4;
            }
            public byte[] convertToBytes(){
                int offSet=0;
                byte[] data=new byte[getSize()];
             data[offSet++]=(byte)(Manufaturer_number>>8);
             data[offSet++]=(byte)(Manufaturer_number&0xff);
             data[offSet++]=(byte)(hardware_version>>8);
             data[offSet++]=(byte)(hardware_version&0xff);
              if(software_version!=null){
                  System.arraycopy(software_version, 0, data, offSet, software_version.length);
              }
              return data;
            }
       }
        
       /**
        * 升级方式:
0普通升级，升级流中软件版本号比终端当前版本号高才会升级。
1强制升级，无论升级流中软件版本号是否高于终端当前版本号都会升级。
        */
       public byte update_type; 
       
       /**
        * 传输系统标识符,8位字段，delivery_system=0，表示有线传送系统；delivery_system=1，表示地面传送系统。
        */
       public byte delivery_system;
       
       /**
        * 调制描述子 0-DVB-C 1-DTMB
        */
       public CustomDescriptor modulationDescriptor;
       private byte usTableIDOfUDT=(byte)0xc7;
       
       /**
        * 升级流的PID
        */
       public short usPidOfUDT;
       
       
       /**
        * 升级文件大小
        */
       public int uiFileLength;
       
       public int getSize(){
            descriptor_length=11;
            EBM_resource_number=(byte)(EBM_resource_codes.size());
            int codeLength = EBM_resource_codes.get(0).length;
            descriptor_length += EBM_resource_codes.size() * codeLength;
            pack_number=(byte)(packInfos.size());
            for(PackInfo item :packInfos){
                descriptor_length+=item.getSize();
            }
            descriptor_length+=modulationDescriptor.getSize();
            return descriptor_length+3;
       }
       
       
       public byte[] convertToBytes(){
           int offSet=0;
           byte[] data=new byte[getSize()];
           int len;
           data[offSet++]=descriptor_tag ;
           data[offSet++]=(byte)(descriptor_length>>8);
           data[offSet++]=(byte)(descriptor_length&0xff);
           data[offSet++]=EBM_resource_number ;
           for(byte[] item :EBM_resource_codes){
               System.arraycopy(item, 0, data, offSet, item.length);
               offSet+=item.length;
           } 
           data[offSet++]=pack_number;
          
           for(PackInfo item:packInfos){
              len=item.getSize();
              System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
               offSet+=len; 
           }
           data[offSet++]=update_type;
           data[offSet++]=delivery_system;
           
           len=modulationDescriptor.getSize();
           System.arraycopy(modulationDescriptor.convertToBytes(), 0, data, offSet, len);
           offSet+=len;
           
           data[offSet++]=usTableIDOfUDT;
           
           data[offSet++]=(byte)(usPidOfUDT>>8);
           data[offSet++]=(byte)(usPidOfUDT&0xff);
           
            data[offSet++]=(byte)(uiFileLength>>24);
            data[offSet++]=(byte)(uiFileLength>>16);
            data[offSet++]=(byte)(uiFileLength>>8);
           data[offSet++]=(byte)(uiFileLength&0xff); 
           return data; 
       }
         /**
         * 设置资源编码
         *
         * @param resourceCodeList 资源编码字符串
         */
        public void setResourceCodes(List<String> resourceCodeList) {
            EBM_resource_number = (byte) resourceCodeList.size();
            EBM_resource_codes = new ArrayList<byte[]>();
            for (String s : resourceCodeList) {
                if (s.length() == 23) {//国标23字符，前4位填充‘0’
                    s = "0" + s;
                }
                byte[] data = Tools.StrToBCDBytes(s);
                EBM_resource_codes.add(data);
            }
        }
    }
    
    private int crc32;
    
    public int getSize(){
        int len=10;
        descriptors_number=(short)(UpgradeDescriptors.size());
        for(Upgrade_Descriptor item :UpgradeDescriptors){
            len+=item.getSize();
        }
        len+=4;
        sectionLength=(short)(len-3);
        return len;
    }
    
    public byte[] convertToBytes(){
        byte[] data = new byte[getSize()];
        int len=0;
        int offSet = 0;
        data[offSet++] = tableID;
        data[offSet++] = (byte) (0xB0 | (sectionLength >> 8));
        data[offSet++] = (byte) (sectionLength & 0xff);
        data[offSet++] = (byte) (table_id_extension >> 8);
        data[offSet++] = (byte) (table_id_extension & 0xff);
        data[offSet++] = (byte) (reserved2 << 6 | versionnumber << 1 | current_next_indicator);
        data[offSet++] = section_number;
        data[offSet++] = last_section_number;
        data[offSet++] = (byte) (descriptors_number >> 8);
        data[offSet++] = (byte) (descriptors_number & 0xff); 
        for(Upgrade_Descriptor item :UpgradeDescriptors){
            len=item.getSize();
            System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
            offSet+=len;
        } 
        crc32 = Tools.crc_Calculate(data, 0, offSet);
        data[offSet++] = (byte) ((crc32 >> 24) & 0xff);
        data[offSet++] = (byte) ((crc32 >> 16) & 0xff);
        data[offSet++] = (byte) ((crc32 >> 8) & 0xff);
        data[offSet++] = (byte) (crc32 & 0xff);
        return data;
    }
}
