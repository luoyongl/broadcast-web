/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables;

import java.util.ArrayList;

import cn.wtu.broadcast.parent.utils.sign.SignatureData;

/**
 * 应急广播证书授权协议
 * 
 * @author Administrator
 */
@SuppressWarnings("unused")
public class EBCAT extends BaseTable {

	/**
	 * 8bits
	 */
	private final byte tableID = (byte) 0xFC;

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

	private byte reserved3 = (byte) 0xff;

	private byte certAuth_number;

	public ArrayList<CertAuth> CertAuths = new ArrayList<>();

	private byte cert_number;
	public ArrayList<Cert> Certs = new ArrayList<>();

	private short signature_length = 0;

	public ArrayList<SignatureData> signatures = new ArrayList<SignatureData>();
	private int crc32;

	public static class CertAuth {

		private short CertAuth_length;
		public byte[] CertAuth_data;

		public int getSize() {
			int len = 2;
			CertAuth_length = 0;
			if (CertAuth_data != null) {
				CertAuth_length = (short) (CertAuth_data.length);

			}
			return len + CertAuth_length;
		}

		public byte[] converToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;
			data[offSet++] = (byte) (CertAuth_length >> 8);
			data[offSet++] = (byte) (CertAuth_length & 0xff);
			if (CertAuth_data != null) {
				System.arraycopy(CertAuth_data, 0, data, offSet, CertAuth_length);
			}
			return data;
		}
	}

	public static class Cert {

		private short Cert_length;
		public byte[] Cert_data;

		public int getSize() {
			int len = 2;
			Cert_length = 0;
			if (Cert_data != null) {
				Cert_length = (short) (Cert_data.length);

			}
			return len + Cert_length;
		}

		public byte[] converToBytes() {
			byte[] data = new byte[getSize()];
			int offSet = 0;
			data[offSet++] = (byte) (Cert_length >> 8);
			data[offSet++] = (byte) (Cert_length & 0xff);
			if (Cert_data != null) {
				System.arraycopy(Cert_data, 0, data, offSet, Cert_length);
			}
			return data;
		}
	}

	public int getSize() {
		int len = 9;
		certAuth_number = (byte) (CertAuths.size());
		len += 1;
		for (CertAuth item : CertAuths) {
			len += item.getSize();
		}
		cert_number = (byte) (Certs.size());
		len += 1;
		for (Cert item : Certs) {
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
		data[offSet++] = reserved3;
		data[offSet++] = certAuth_number;
		for (CertAuth item : CertAuths) {
			int len = item.getSize();
			System.arraycopy(item.converToBytes(), 0, data, offSet, len);
			offSet += len;
		}
		data[offSet++] = cert_number;
		for (Cert item : Certs) {
			int len = item.getSize();
			System.arraycopy(item.converToBytes(), 0, data, offSet, len);
			offSet += len;
		}
		data[offSet++] = (byte) (signature_length >> 8);
		data[offSet++] = (byte) (signature_length & 0xff);
		srcData = new byte[offSet - 8];
		System.arraycopy(data, 8, srcData, 0, offSet - 8);
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
