/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.wtu.broadcast.openapi.ts.descriptors.CustomDescriptor;
import cn.wtu.broadcast.openapi.ts.descriptors.Descriptors;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;
import cn.wtu.broadcast.parent.utils.sign.Util;


/**
 * 应急广播索引表
 * 
 * @author Administrator
 */
@SuppressWarnings("unused")
public class EBIT extends BaseTable {

	/**
	 * 8bits
	 */
	private final byte tableID = (byte) 0xFD;

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

	public byte EBM_number = 0;
	public ArrayList<EBMInfo> ebminfos = new ArrayList<EBMInfo>();
	private short signature_length = 0;

	public ArrayList<SignatureData> signatures = new ArrayList<SignatureData>();
	private int crc32;

	@Override
	public int getSize() {
		int len = 10;
		if (ebminfos != null) {
			EBM_number = (byte) (ebminfos.size());
			for (EBMInfo item : ebminfos) {
				len += item.getSize();
			}
		}
		len += 2;
		if (signatures != null) {
			for (SignatureData item : signatures) {
				signature_length += item.getSize();
			}
			len += signature_length;
		}
		len += 4;
		sectionLength = (short) (len - 3);
		return len;
	}

	public static class EBMInfo {

		private short EBM_length;
		private byte[] EBM_id;
		public short EBM_original_network_id = 1;
		public MJDDateTime EBM_start_time;
		public MJDDateTime EBM_end_time;
		private byte[] EBM_type = new byte[5];

		public byte EBM_class;
		public byte EBM_level;
		private byte EBM_resource_number = 0;
		private ArrayList<byte[]> EBM_resource_codes;
		private byte reserved1 = 0x7f;
		public byte details_channel_indicate = 1;

		public short details_channel_transport_stream_id = 1;
		public short details_channel_program_number;
		private byte reserved2 = 0x07;
		public short details_channel_PCR_PID;
		private byte reserved3 = 0x0f;
		private short details_channel_program_info_length;

		/**
		 * DVB-c,DTMB网络描述子，从设备网管中导出
		 */
		public ArrayList<CustomDescriptor> descriptors1 = new ArrayList<CustomDescriptor>();

		private short stream_info_length;

		public ArrayList<StreamInfo> streams = new ArrayList<StreamInfo>();

		public static class StreamInfo {

			public byte stream_type = 3;
			private byte reserved = 0x5;
			public short elementary_PID=1000;//13byte  范围在0-1111111111111之间[0,2^13-1]
			private byte reserved1 = 0x0f;
			private short ES_info_length;
			public ArrayList<Descriptors> descriptors = new ArrayList<Descriptors>();

			public int getSize() {
				int len = 1 + 2 + 2;
				if (descriptors != null) {
					for (Descriptors des : descriptors) {
						len += des.getSize();
					}
				}
				ES_info_length = (short) (len - 5);
				return len;
			}

			public byte[] convertToBytes() {
				byte[] data = new byte[getSize()];
				int offSet = 0;
				int desLen = 0;
				data[offSet++] = stream_type;
				data[offSet++] = (byte) ((reserved << 5) | (elementary_PID >> 8));
				data[offSet++] = (byte) (elementary_PID & 0xff);
				data[offSet++] = (byte) ((reserved1 << 4) | (ES_info_length >> 8));
				data[offSet++] = (byte) (ES_info_length & 0xff);
				if (descriptors != null) {
					for (Descriptors des : descriptors) {
						desLen = des.getSize();
						System.arraycopy(des.convertToBytes(), 0, data, offSet, desLen);
						offSet += desLen;
					}
				}
				return data;

			}
		}

		public int getSize() {
			int len = 2;
			len += EBM_id.length;
			len += 2;
			len += 15;
			len += 2;
			if (EBM_resource_codes != null) {
				EBM_resource_number = (byte) (EBM_resource_codes.size());

				int codeLength = EBM_resource_codes.get(0).length;
				len += EBM_resource_codes.size() * codeLength;

			}
			len++;
			if (details_channel_indicate == 1) {
				len += 8;
				if (descriptors1 != null) {
					int desLen = 0;
					for (Descriptors des : descriptors1) {
						desLen += des.getSize();
					}
					details_channel_program_info_length = (short) desLen;
					len += desLen;
				} else {
					details_channel_program_info_length = 0;
				}
				len += 2;
				stream_info_length = 0;
				if (streams != null) {

					for (StreamInfo stream : streams) {
						stream_info_length += stream.getSize();
					}
				}
				len += stream_info_length;
			}

			EBM_length = (short) (len - 2);
			return len;
		}

		public byte[] convertToBytes() {
			int offSet = 0;
			byte[] data = new byte[getSize()];
			data[offSet++] = (byte) (EBM_length >> 8);
			data[offSet++] = (byte) (EBM_length & 0xff);
			System.arraycopy(EBM_id, 0, data, offSet, EBM_id.length);
			offSet += EBM_id.length;
			data[offSet++] = (byte) (EBM_original_network_id >> 8);
			data[offSet++] = (byte) (EBM_original_network_id & 0xff);
			System.arraycopy(EBM_start_time.convertToBytes(), 0, data, offSet, 5);
			offSet += 5;
			System.arraycopy(EBM_end_time.convertToBytes(), 0, data, offSet, 5);
			offSet += 5;
			System.arraycopy(EBM_type, 0, data, offSet, 5);
			offSet += 5;
			data[offSet++] = (byte) ((EBM_class << 4) | (EBM_level & 0x0f));
			data[offSet++] = EBM_resource_number;
			if (EBM_resource_codes != null) {
				for (byte[] resource : EBM_resource_codes) {
					System.arraycopy(resource, 0, data, offSet, resource.length);
					offSet += resource.length;
				}
			}
			data[offSet++] = (byte) ((reserved1 << 1) | (details_channel_indicate & 0x01));
			if (details_channel_indicate == 1) {
				data[offSet++] = (byte) (details_channel_transport_stream_id >> 8);
				data[offSet++] = (byte) (details_channel_transport_stream_id & 0xff);

				data[offSet++] = (byte) (details_channel_program_number >> 8);
				data[offSet++] = (byte) (details_channel_program_number & 0xff);

				data[offSet++] = (byte) (reserved2 << 5 | (details_channel_PCR_PID >> 8));
				data[offSet++] = (byte) (details_channel_PCR_PID & 0xff);

				data[offSet++] = (byte) (reserved2 << 4 | (details_channel_program_info_length >> 8));
				data[offSet++] = (byte) (details_channel_program_info_length & 0xff);

				if (descriptors1 != null) {
					for (Descriptors des : descriptors1) {
						System.arraycopy(des.convertToBytes(), 0, data, offSet, des.getSize());
						offSet += des.getSize();
					}
				}
				data[offSet++] = (byte) (stream_info_length >> 8);
				data[offSet++] = (byte) (stream_info_length & 0xff);
				if (streams != null) {

					for (StreamInfo stream : streams) {
						System.arraycopy(stream.convertToBytes(), 0, data, offSet, stream.getSize());
						offSet += stream.getSize();
					}
				}

			}
			return data;
		}

		public static int serialNo = 1;
		public static int LastDate = java.util.Calendar.getInstance().get(Calendar.DATE);

		/**
		 * EBM_id 应急广播消息标识id=平台资源编码(72byte/18位Hex)+yyyymmdd+0000(四位顺序码)
		 * @param PlatformResourceCode 平台资源编码
		 * @since 2019-01-19 lxg
		 */
		public EBMInfo(String PlatformResourceCode,Integer fId, Date startDate) {
			String orderCode="0000";
			// String s=
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMdd");
			/*
			 * 顺序码  小于5位
			 * 2019/02/24  lxg
			 */
			if(fId < 10000){
				 orderCode = String.format("%04d",fId);
			}else{
				//超过四位截取后四位
				 orderCode = fId.toString().substring(fId.toString().length()-4);
			}
			String s = PlatformResourceCode + myFmt.format(startDate) + orderCode;
			EBM_id = Tools.StrToBCDBytes(s);
		}

		/**
		 * 广西标准调用方法，设置EBM_ID，国标调用构造函数
		 * 
		 * @param serialNo
		 */
		public void setEBMid(String serialNo) {
			EBM_id = Util.hexStringToBytes(serialNo);
			// EBM_id[0]=(byte)((serialNo>>24)&0xff);
			// EBM_id[1]=(byte)((serialNo>>16)&0xff);
			// EBM_id[2]=(byte)((serialNo>>8)&0xff);
			// EBM_id[3]=(byte)((serialNo>>0)&0xff);
		}

		private byte[] getEMBid() {
			return EBM_id;
		}

		/**
		 * 设置资源编码
		 * 
		 * @param resourceCodeList
		 *            资源编码字符串
		 */
		public void setResourceCodes(List<String> resourceCodeList) {
			EBM_resource_number = (byte) resourceCodeList.size();
			EBM_resource_codes = new ArrayList<byte[]>();
			for (String s : resourceCodeList) {
				if (s.length() == 23) {// 国标23字符，前4位填充‘0’
					s = "0" + s;
				}
				byte[] data = Tools.StrToBCDBytes(s);
				EBM_resource_codes.add(data);
			}
		}
/*		public void setResourceCodes(ArrayList<String> resourceCodeList) {
			EBM_resource_number = (byte) resourceCodeList.size();
			EBM_resource_codes = new ArrayList<byte[]>();
			for (String s : resourceCodeList) {
				if (s.length() == 23) {// 国标23字符，前4位填充‘0’
					s = "0" + s;
				}
				byte[] data = Tools.StrToBCDBytes(s);
				EBM_resource_codes.add(data);
			}
		}*/

		/**
		 * 设置
		 * 
		 * @param EBMTypeStr
		 *            类型文本 国家应急平台体系信息资源分类与编码规范 5个字符
		 * @throws Exception
		 */
		public void setEBMType(String EBMTypeStr) throws Exception {
			if (EBMTypeStr.length() != 5) {
				throw new Exception("必须是5个字符!");
			}
			EBM_type = EBMTypeStr.getBytes("US-ASCII");
		}

	}

    /**
    *
    * @return
    */
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
       data[offSet++] = reserved3;
       data[offSet++] = EBM_number;
       if (ebminfos != null) {
           for (EBMInfo item : ebminfos) {
               System.arraycopy(item.convertToBytes(), 0, data, offSet, item.getSize());
               offSet += item.getSize();
           }
       }
        srcData = new byte[offSet - 8];
       data[offSet++] = (byte) (signature_length >> 8);
       data[offSet++] = (byte) (signature_length & 0xff);
      
       for (SignatureData item : signatures) {
           int len = item.getSize();
           System.arraycopy(data, 8, srcData, 0, srcData.length);
           item.setSrcData(srcData);
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
/*	public byte[] convertToBytes() {
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
		data[offSet++] = EBM_number;
		if (ebminfos != null) {
			for (EBMInfo item : ebminfos) {
				System.arraycopy(item.convertToBytes(), 0, data, offSet, item.getSize());
				offSet += item.getSize();
			}
		}
		data[offSet++] = (byte) (signature_length >> 8);
		data[offSet++] = (byte) (signature_length & 0xff);
		srcData = new byte[offSet - 8];
		for (SignatureData item : signatures) {
			int len = item.getSize();
			System.arraycopy(data, 8, srcData, 0, offSet - 8);
			item.setSrcData(srcData);
			System.arraycopy(item.convertToBytes(), 0, data, offSet, len);
			offSet += len;
		}
		crc32 = Tools.crc_Calculate(data, 0, offSet);
		data[offSet++] = (byte) ((crc32 >> 24) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 16) & 0xff);
		data[offSet++] = (byte) ((crc32 >> 8) & 0xff);
		data[offSet++] = (byte) (crc32 & 0xff);
		return data;
	}*/
	
}
