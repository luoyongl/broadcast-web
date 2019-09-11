package cn.wtu.broadcast.openapi.ts.Tables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class UDT extends BaseTable {
	 /**
     * 8bits
     */
    private final byte tableID = (byte) 0xC7;

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

    public short block_number;

    public byte[] srcData;

    private int crc32;

    public int getSize() {
        int len = 10;
        if (srcData != null) {
            len += srcData.length;
        }
        len += 4;
        sectionLength = (short) (len - 3);
        return len;
    }

    public byte[] convertToBytes() {
        byte[] data = new byte[getSize()];
        int offSet = 0;
        data[offSet++] = tableID;
        data[offSet++] = (byte) (0xB0 | (sectionLength >> 8));
        data[offSet++] = (byte) (sectionLength & 0xff);
        data[offSet++] = (byte) (table_id_extension >> 8);
        data[offSet++] = (byte) (table_id_extension & 0xff);
        data[offSet++] = (byte) (reserved2 << 6 | versionnumber << 1 | current_next_indicator);
        data[offSet++] = section_number;
        data[offSet++] = last_section_number;
        data[offSet++] = (byte) (block_number >> 8);
        data[offSet++] = (byte) (block_number & 0xff);
        if (srcData != null) {
            System.arraycopy(srcData, 0, data, offSet, srcData.length);
            offSet += srcData.length;
        }
        crc32 = Tools.crc_Calculate(data, 0, offSet);
        data[offSet++] = (byte) ((crc32 >> 24) & 0xff);
        data[offSet++] = (byte) ((crc32 >> 16) & 0xff);
        data[offSet++] = (byte) ((crc32 >> 8) & 0xff);
        data[offSet++] = (byte) (crc32 & 0xff);
        return data;
    }

    
    /**
     * 将升级文件打包成TS包
     * @param upgradeDataFileName 升级文件名
     * @param upgradePID 升级PID
     * @param tsFileName 指定生成的TS文件名
     * @return
     * @throws IOException 
     */
    public static boolean createUpdateTSFile(String upgradeDataFileName, short upgradePID, String tsFileName) throws IOException {
        FileInputStream readfs = null;
        FileOutputStream writefs = null;

        int sectionCount = 0;
        int sectionIndex = 0;
        byte continuer = 0;
        try {
            readfs = new FileInputStream(upgradeDataFileName);
            writefs = new FileOutputStream(tsFileName);
            long fileSize = readfs.getChannel().size();
            byte bytes[] = new byte[1024];
           // int len = 0;
            sectionCount = (int) (fileSize % 1024 == 0 ? fileSize / 1024 : fileSize / 1024 + 1);//每个段封装1K数据
            UDT udt = new UDT();
            while ( readfs.read(bytes) != -1) {
                udt.section_number = (byte) (sectionIndex & 0xff);
                if (sectionCount - sectionIndex > 255) {
                    udt.last_section_number = (byte) (0xff);
                } else {
                    udt.last_section_number = (byte) ((sectionCount&0xff)-1);
                }
                udt.block_number = (short) (sectionIndex / 256);
                udt.srcData = bytes;
                byte[] buf = Tools.Section2TsBuf(udt, upgradePID, continuer);
                writefs.write(buf, 0, buf.length);
                continuer = (byte) ((continuer + 6) & 0x0f);//1024打包成6个TS包
                sectionIndex++;
            }
            writefs.flush();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;

        } finally {
            readfs.close();
            writefs.close();;
        }
    }

}
