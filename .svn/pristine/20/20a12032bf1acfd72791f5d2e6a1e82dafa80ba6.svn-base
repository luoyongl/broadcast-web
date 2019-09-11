/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Administrator
 */
public class Tools {

	public static int toBCD(int val) {
        int res = 0;
        int bit = 0;
        while (val >= 10) {
            res |= (val % 10 << bit);
            val /= 10;
            bit += 4;
        }
        res = res | (val << bit);
        return res;
    }

    public static int fromBCD(int vals) {
        int i = 1, res = 0;

        while (vals >= 16) {
            res = res + (vals % 16) * i;
            vals = vals / 16;
            i = i * 10;
        }
        res = res + vals * i;
        return res;
    }

    public static int crc_Calculate(byte[] data, int StartIndex, int length) {
        int[] ptiTable = new int[256];
        int nData = 0, CRCPloy = 0x04C11DB7;
        int nAccum = 0;

        for (int i = 0; i < 256; i++) {
            nData = i << 24;
            nAccum = 0;
            for (int j = 0; j < 8; j++) {
                if (0 != ((nData ^ nAccum) & 0x80000000)) {
                    nAccum = (nAccum << 1) ^ CRCPloy;
                } else {
                    nAccum <<= 1;
                }
                nData <<= 1;
            }
            ptiTable[i] = nAccum;
        }
        int crc32 = 0xFFFFFFFF;
        int byteCount = 0;
        while (byteCount < length) {
            crc32 = (crc32 << 8) ^ ptiTable[(crc32 >>> 24) ^ (data[StartIndex + byteCount] & 0xFF)];
            byteCount++;
        }

        return crc32;

    }

    /**
     * crc16-ccitt-false
     * @param bytes
     * @param offSet
     * @param len
     * @return 
     */
    public static int crc16(byte[] bytes, int offSet, int len) {
        int crc = 0xFFFF;
        for (; offSet < len; offSet++) {
            crc = ((crc >>> 8) | (crc << 8)) & 0xffff;
            crc ^= (bytes[offSet] & 0xff);
            crc ^= ((crc & 0xff) >> 4);
            crc ^= (crc << 12) & 0xffff;
            crc ^= ((crc & 0xFF) << 5) & 0xffff;
        }
        crc &= 0xffff;
        return crc;
    }
    
    public static int crc16(byte[] bytes){
        return crc16(bytes,0,bytes.length);
    }

    
      /**
     * des加密
     * @param data
     * @param sKey
     * @return 
     */
    public static byte[] desEncrypt(byte[] data, byte[] keyBytes) {
		
		try {
			DESKeySpec keySpec = new DESKeySpec(keyBytes);
			String algorithm =  "DES";//指定使什么样的算法
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
			SecretKey key = keyFactory.generateSecret(keySpec);
			
			String transformation = "DES/ECB/NoPadding"; //
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			byte[] result = cipher.doFinal(data);
		
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

 
    /**
     * 打包成TS格式
     *
     * @param src
     * @param PID
     * @return
     */
    public static byte[] Section2TsBuf(byte[] src, short PID, boolean addZero) {
        return Section2TsBuf(src, PID, addZero, (byte) 0);
    }

    public static byte[] Section2TsBuf(BaseTable table, short PID) {
        byte[] data = new byte[table.getSize() + 1];
        System.arraycopy(table.convertToBytes(), 0, data, 1, table.getSize());
        return Section2TsBuf(data, PID, false);
    }

    /**
     * Add 2019-03-24
     *
     * @param table
     * @param PID
     * @param startContinue_counter
     * @return
     */
    public static byte[] Section2TsBuf(BaseTable table, short PID, byte startContinue_counter) {
        byte[] data = new byte[table.getSize() + 1];
        System.arraycopy(table.convertToBytes(), 0, data, 1, table.getSize());
        return Section2TsBuf(data, PID, false, startContinue_counter);
    }

    /**
     * Add 2019-03-24
     *
     * @param table
     * @param PID
     * @param startContinue_counter
     * @return
     */
    public static byte[] Section2TsBuf(byte[] src, short PID, boolean addZero, byte startContinue_counter) {
        byte[] newData;
        if (addZero) {
            newData = new byte[src.length + 1];
            System.arraycopy(src, 0, newData, 1, src.length);
        } else {
            newData = new byte[src.length];
            System.arraycopy(src, 0, newData, 0, src.length);
        }
        int PackCount = (newData.length % 184 == 0) ? newData.length / 184 : (newData.length / 184) + 1, CopyCount;
        byte[] des = new byte[PackCount * 188];
        //for (int i = 0; i < des.Length;i++ ) des[i] = 0xff;
        int SrcOffSet = 0, DesOffSet = 0;
        byte payload_unit_start_indicator = 0x01, transport_priority = 0x01;
        while (SrcOffSet < newData.length) {
            des[DesOffSet++] = 0x47;
            des[DesOffSet++] = (byte) ((payload_unit_start_indicator << 6) | (transport_priority << 5) | ((PID >> 8) & 0x1f));
            des[DesOffSet++] = (byte) (PID & 0xff);
            des[DesOffSet++] = (byte) (((0x00 & 0x03) << 6) | ((0x01 & 0x03) << 4) | (startContinue_counter & 0x0f));
            CopyCount = newData.length - SrcOffSet >= 184 ? 184 : newData.length - SrcOffSet;

            System.arraycopy(newData, SrcOffSet, des, DesOffSet, CopyCount);
            payload_unit_start_indicator = 0x00;
            startContinue_counter = (byte) ((startContinue_counter + 1) & 0x0f);
            SrcOffSet += CopyCount;
            DesOffSet += CopyCount;
        }
        for (int i = DesOffSet; i < des.length; i++) {
            des[i] = (byte) 0xff;
        }
        return des;
    }

    public static byte[] StrToBCDBytes(String s) {

        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += 2) {
            int high = cs[i] - 48;
            int low = cs[i + 1] - 48;
            bs.write(high << 4 | low);
        }

        byte[] data = bs.toByteArray();
        try {
            bs.close();
        } catch (Exception ex) {

        }
        return data;
    }

    private static final HashMap<Short, Byte> pidContinuerMap = new HashMap<Short, Byte>();

    /*
         
     */

    public static void SendData(byte[] data) throws InterruptedException {
        byte[] buf = null;
        int offSet = 0;
        int bufLen = 188 * 1;
        byte continueValue = 0;
        while (offSet < data.length) {
            if ((data.length - offSet) > bufLen) {
                buf = new byte[bufLen];
            } else {
                buf = new byte[data.length - offSet];
                bufLen = buf.length;
            }
            System.arraycopy(data, offSet, buf, 0, bufLen);

            for (int i = 0; i < bufLen; i += 188) {
                Short pid = (short) (((buf[1 + i] & 0x1f) << 8) | buf[2 + i]);

                if (pidContinuerMap.containsKey(pid)) {

                    continueValue = pidContinuerMap.get(pid);
                    continueValue++;
                    buf[3 + i] = (byte) ((buf[3 + i] & 0xf0) | (continueValue & 0x0f));
                    pidContinuerMap.replace(pid, continueValue);
                } else {
                    continueValue = 0;
                    buf[3 + i] = (byte) ((buf[3 + i] & 0xf0));

                    pidContinuerMap.put(pid, continueValue);
                }

            }
            //自己添加发送代码
            //
            Thread.sleep(2);
            offSet += bufLen;
        }
    }
}
