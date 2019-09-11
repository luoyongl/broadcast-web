package cn.wtu.broadcast.openapi.ts.Tables;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.wtu.broadcast.openapi.ts.Tables.EBCT.Multilingual_ContentInfo.AuxiliaryDataInfo;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;

/**
 * 应急广播内容表
 *
 * @author Administrator
 */
public class EBCT extends BaseTable {

	/**
	 * 8bits
	 */
	private final byte tableID = (byte) 0xFE;

	/**
	 * 1bit
	 */
	@SuppressWarnings("unused")
	private final byte sectionSyntaxIndicator = 1;

	/**
	 * 1bit
	 */
	@SuppressWarnings("unused")
	private final byte zero = 0;

	/**
	 * 2bits
	 */
	@SuppressWarnings("unused")
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

	public byte[] EBM_ID;

	private byte reserved3 = 0x0f;

	private byte multilingual_content_number;

	public ArrayList<Multilingual_ContentInfo> multilingual_Contents = new ArrayList<Multilingual_ContentInfo>();

	private short signature_length = 0;

	public ArrayList<SignatureData> signatures = new ArrayList<SignatureData>();
	private int crc32;

	public static class Multilingual_ContentInfo {

		private int multilingual_content_length;
		private byte[] language_code;
		private byte reserved1 = 0x1f;

		/**
		 * 编码字符集 0-GB 2312-1980 1-GB/T 18030-2005（可选）2-GB 13000-2010（可选） 3-GB
		 * 21669-2008（可选） 4-GB 16959-1997（可选）
		 */
		public byte coded_character_set = 0;

		private short message_text_length;

		private byte[] message_text;

		private byte agency_name_length;
		private byte[] agency_name;

		private byte reserved2 = 0x0f;

		private byte auxiliary_data_number;

		public ArrayList<AuxiliaryDataInfo> auxiliaryDataInfos = new ArrayList<AuxiliaryDataInfo>();

		public static class AuxiliaryDataInfo {

			/**
			 * MPEG-1 LayerI/II 音频文件 2 MPEG-1 LayerIII 音频文件 3 DRA 音频文件 4
			 * DRA+音频文件 5～40 预留 41 PNG 图片文件 42 JPEG 图片文件 43 GIF 图片文件 44～60 预留 61
			 * 音视频流
			 */
			public byte auxiliary_data_type;
			private int auxiliary_data_length;
			public byte[] auxiliary_data;

			public int getSize() {
				int len = 1 + 3;
				if (auxiliary_data != null) {
					auxiliary_data_length = auxiliary_data.length;
					len += auxiliary_data_length;
				}
				return len;
			}

			public byte[] converToBytes() {
				byte[] data = new byte[getSize()];
				int offSet = 0;
				data[offSet++] = auxiliary_data_type;
				// data[offSet++] = (byte) ((auxiliary_data_length >> 24) &
				// 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 16) & 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 8) & 0xff);
				data[offSet++] = (byte) ((auxiliary_data_length >> 0) & 0xff);
				System.arraycopy(auxiliary_data, 0, data, offSet, auxiliary_data_length);
				return data;
			}
		}

		public Multilingual_ContentInfo() {
			String s = "zho";
			try {
				language_code = s.getBytes("US-ASCII");
			} catch (UnsupportedEncodingException ex) {
				Logger.getLogger(EBCT.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		/**
		 * 设置语言编码
		 *
		 * @param s
		 *            语言编码字符串
		 */
		public void setLanguageCode(String s) {
			try {
				language_code = s.getBytes("US-ASCII");
			} catch (UnsupportedEncodingException ex) {
				Logger.getLogger(EBCT.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		public int getSize() {
			int len = 4 + 3 + 1 + 2 + 1 + 1;
			if (message_text != null) {
				message_text_length = (short) message_text.length;
				len += message_text_length;
			}
			if (agency_name != null) {
				agency_name_length = (byte) agency_name.length;
				len += agency_name_length;
			}
			for (AuxiliaryDataInfo item : auxiliaryDataInfos) {
				len += item.getSize();
			}
			auxiliary_data_number = (byte) auxiliaryDataInfos.size();
			multilingual_content_length = len - 4;
			return len;
		}

		public void setMessageText(String text) throws UnsupportedEncodingException {
			if (coded_character_set == 0) {
				message_text = text.getBytes("GB2312");
			} else if (coded_character_set == 1) {
				message_text = text.getBytes("GB18030");
			} else {
				message_text = text.getBytes("GBK");
			}
		}

		public void setAgencyName(String AgencyName) throws UnsupportedEncodingException {
			if (coded_character_set == 0) {
				agency_name = AgencyName.getBytes("GB2312");
			} else if (coded_character_set == 1) {
				agency_name = AgencyName.getBytes("GB18030");
			} else {
				agency_name = AgencyName.getBytes("GBK");
			}
		}

		public byte[] convertToBytes() {
			int offSet = 0;
			byte[] data = new byte[getSize()];
			data[offSet++] = (byte) ((multilingual_content_length >> 24) & 0xff);
			data[offSet++] = (byte) ((multilingual_content_length >> 16) & 0xff);
			data[offSet++] = (byte) ((multilingual_content_length >> 8) & 0xff);
			data[offSet++] = (byte) ((multilingual_content_length) & 0xff);
			System.arraycopy(language_code, 0, data, offSet, 3);
			offSet += 3;
			data[offSet++] = (byte) (reserved1 << 3 | coded_character_set);

			data[offSet++] = (byte) ((message_text_length >> 8) & 0xff);
			data[offSet++] = (byte) ((message_text_length) & 0xff);

			System.arraycopy(message_text, 0, data, offSet, message_text_length);
			offSet += message_text_length;

			data[offSet++] = agency_name_length;
			System.arraycopy(agency_name, 0, data, offSet, agency_name_length);
			offSet += agency_name_length;

			data[offSet++] = (byte) (reserved2 << 4 | auxiliary_data_number);

			for (AuxiliaryDataInfo item : auxiliaryDataInfos) {
				int size = item.getSize();
				System.arraycopy(item.converToBytes(), 0, data, offSet, size);
				offSet += size;
			}
			return data;
		}
	}

	@Override
	public int getSize() {
		int len = 8;
		len += EBM_ID.length;
		len += 1;
		multilingual_content_number = (byte) multilingual_Contents.size();
		for (Multilingual_ContentInfo item : multilingual_Contents) {
			len += item.getSize();
		}
		len += 2;
		signature_length = 0;
		for (SignatureData item : signatures) {
			signature_length += item.getSize();
		}
		len += signature_length;
		len += 4;
		sectionLength = (short) (len - 3);
		return len;
	}

	@Override
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

		System.arraycopy(EBM_ID, 0, data, offSet, EBM_ID.length);
		offSet += EBM_ID.length;

		data[offSet++] = (byte) (reserved3 << 4 | multilingual_content_number);

		for (Multilingual_ContentInfo item : multilingual_Contents) {
			int len = item.getSize();
			System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
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

	public static ArrayList<EBCT> createEBCTSections(byte[] EBM_ID, String messageText, String agencyName,
			List<AuxiliaryDataInfo> auxiliaryDatas, SignatureData sign) throws UnsupportedEncodingException {
		ArrayList<EBCT> list = new ArrayList<>();

		int sectionNumber = 0, offSet = 0;
		int len = 0;
		AuxiliaryDataInfo currItem = null, auxiliaryDataInfoItem = null;
		ArrayList<AuxiliaryDataInfo> auxiliaryDataList = new ArrayList<>();
		for (int i = 0; i < auxiliaryDatas.size(); i++) {
			currItem = auxiliaryDatas.get(i);
			len += currItem.auxiliary_data.length;
			if (len <= 3800) {
				auxiliaryDataList.add(currItem);
			} else {
				if (auxiliaryDataList.isEmpty()) {// 第一个辅助数据长度大于3800
					offSet = 0;
					while (len > offSet) {
						EBCT ebct = new EBCT();
						ebct.EBM_ID = EBM_ID;
						ebct.section_number = (byte) (sectionNumber);
						Multilingual_ContentInfo contentInfo = new Multilingual_ContentInfo();
						contentInfo.setAgencyName(agencyName);
						contentInfo.setMessageText(messageText);
						contentInfo.auxiliary_data_number = (byte) (auxiliaryDatas.size());
						auxiliaryDataInfoItem = new AuxiliaryDataInfo();
						auxiliaryDataInfoItem.auxiliary_data_type = currItem.auxiliary_data_type;

						if (len - offSet >= 3800) {
							auxiliaryDataInfoItem.auxiliary_data = new byte[3800];
						} else {
							auxiliaryDataInfoItem.auxiliary_data = new byte[len - offSet];
						}
						System.arraycopy(currItem.auxiliary_data, offSet, auxiliaryDataInfoItem.auxiliary_data, 0,
								auxiliaryDataInfoItem.auxiliary_data.length);
						offSet += auxiliaryDataInfoItem.auxiliary_data.length;

						ebct.multilingual_Contents.add(contentInfo);
						list.add(ebct);
						sectionNumber++;
					}
				} else {
					EBCT ebct = new EBCT();
					ebct.EBM_ID = EBM_ID;
					ebct.section_number = (byte) (sectionNumber);
					Multilingual_ContentInfo contentInfo = new Multilingual_ContentInfo();
					contentInfo.setAgencyName(agencyName);
					contentInfo.setMessageText(messageText);
					contentInfo.auxiliary_data_number = (byte) (auxiliaryDatas.size());
					contentInfo.auxiliaryDataInfos.addAll(auxiliaryDataList);

					ebct.multilingual_Contents.add(contentInfo);
					list.add(ebct);
					sectionNumber++;
					i--;
				}
				len = 0;
				auxiliaryDataList.clear();
			}

		}
		if (auxiliaryDataList.size() > 0) {
			EBCT ebct = new EBCT();
			ebct.EBM_ID = EBM_ID;
			ebct.section_number = (byte) (sectionNumber);
			Multilingual_ContentInfo contentInfo = new Multilingual_ContentInfo();
			contentInfo.setAgencyName(agencyName);
			contentInfo.setMessageText(messageText);
			contentInfo.auxiliary_data_number = (byte) (auxiliaryDatas.size());
			contentInfo.auxiliaryDataInfos.addAll(auxiliaryDataList);

			ebct.multilingual_Contents.add(contentInfo);

			list.add(ebct);
		} else {
			EBCT ebct = new EBCT();
			ebct.EBM_ID = EBM_ID;
			ebct.section_number = (byte) (0);
			ebct.last_section_number = 0;
			Multilingual_ContentInfo contentInfo = new Multilingual_ContentInfo();
			contentInfo.setAgencyName(agencyName);
			contentInfo.setMessageText(messageText);
			contentInfo.auxiliary_data_number = 0;

			ebct.multilingual_Contents.add(contentInfo);
			// contentInfo.auxiliaryDataInfos.addAll(auxiliaryDataList);

			list.add(ebct);
		}

		list.forEach((item) -> {
			item.last_section_number = (byte) (list.size() - 1);
		});

		list.get(list.size() - 1).signatures.add(sign);// 最后一个段加签名
		return list;
	}

}
