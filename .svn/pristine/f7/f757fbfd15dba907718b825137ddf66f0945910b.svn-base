/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables;

import java.util.ArrayList;

import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.ConfigureCmd;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;

/**
 * 应急广播管理配置表
 * 
 * @author Administrator
 */
@SuppressWarnings("unused")
public class EBCONT extends BaseTable {

	/**
	 * 8bits
	 */
	private final byte tableID = (byte) 0xFB;
 
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

	private byte Configure_cmd_number;

	public ArrayList<ConfigureCmd> Configure_Cmds = new ArrayList<>();

	private short signature_length = 0;

	public ArrayList<SignatureData> signatures = new ArrayList<SignatureData>();
	private int crc32;

	public int getSize() {
		int len = 9;
		Configure_cmd_number = (byte) (Configure_Cmds.size());

		for (ConfigureCmd item : Configure_Cmds) {
			len += item.getSize();
		}

		len += 2;
		signature_length = 0;
		for (SignatureData item : signatures) {
			signature_length += item.getSize();
		}
		len += signature_length;
		len += 4;
		sectionLength=(short)(len-3);
		return len;
	}

	public byte[] convertToBytes() {
		byte[] data = new byte[getSize()];
		byte[] srcData = null;
		int offSet = 0;
		data[offSet++] = tableID;
		data[offSet++] = (byte) (0xB0 | (sectionLength >> 8));
		data[offSet++] = (byte) (sectionLength & 0xff);
		data[offSet++] = (byte) (table_id_extension >> 8);
		data[offSet++] = (byte) (table_id_extension & 0xff);
		data[offSet++] = (byte) (reserved2 << 6 | versionnumber << 1 | current_next_indicator);
		data[offSet++] = section_number;
		data[offSet++] = last_section_number;

		data[offSet++] = Configure_cmd_number;
		for (ConfigureCmd item : Configure_Cmds) {
			int len = item.getSize();
			System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
			offSet += len;
		}
		srcData = new byte[offSet - 8];
		System.arraycopy(data, 8, srcData, 0, offSet - 8);
		data[offSet++] = (byte) (signature_length >> 8);
		data[offSet++] = (byte) (signature_length & 0xff);
		
		
		for (SignatureData item : signatures) {
			item.setSrcData(srcData);

			int len = item.getSize();
			System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
			offSet += len;
		}
		crc32 = Tools.crc_Calculate(data, 0, offSet);
		data[offSet++] = (byte) ((crc32 >> 24) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 16) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 8) & 0xff);
		data[offSet++] = (byte) (crc32 & 0xff);
		return data;
	}
}
