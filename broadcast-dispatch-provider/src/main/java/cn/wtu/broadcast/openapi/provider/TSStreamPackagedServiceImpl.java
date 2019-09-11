package cn.wtu.broadcast.openapi.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.TSStreamPackagedService;
import cn.wtu.broadcast.openapi.thread.TsDeviceUpdateThread;
import cn.wtu.broadcast.openapi.ts.Tables.EBCONT;
import cn.wtu.broadcast.openapi.ts.Tables.EBCT;
import cn.wtu.broadcast.openapi.ts.Tables.EBCT.Multilingual_ContentInfo.AuxiliaryDataInfo;
import cn.wtu.broadcast.openapi.ts.Tables.EBIT;
import cn.wtu.broadcast.openapi.ts.Tables.MJDDateTime;
import cn.wtu.broadcast.openapi.ts.Tables.Tools;
import cn.wtu.broadcast.openapi.ts.Tables.UDT;
import cn.wtu.broadcast.openapi.ts.Tables.UMT;
import cn.wtu.broadcast.openapi.ts.Tables.UMT.Upgrade_Descriptor;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.AddressSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.AudioRebackSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.ColumnSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.FreqSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.RDSSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.RebackPeriodSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.RebackTypeAndAddressSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.RecordExtractSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.TerminalInspectSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.TerminalPIDSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.TimeSettingCmd;
import cn.wtu.broadcast.openapi.ts.Tables.ConfigureTable.WorkModeSettingCmd;
import cn.wtu.broadcast.openapi.ts.descriptors.AudioStreamDescriptor;
import cn.wtu.broadcast.openapi.ts.descriptors.CustomDescriptor;
import cn.wtu.broadcast.openapi.ts.descriptors.Descriptors;
import cn.wtu.broadcast.openapi.vo.EBCTTsDataVO;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.BroadcastTypeKeyEnum;
import cn.wtu.broadcast.parent.utils.DateUtil;
import cn.wtu.broadcast.parent.utils.sign.SignatureData;
import cn.wtu.broadcast.parent.utils.sign.Util;
import cn.wtu.broadcast.parent.vo.EBCONTParamsVO;
import cn.wtu.broadcast.parent.vo.EBITParamsVO;
import cn.wtu.broadcast.parent.vo.TsDeviceUpdateVo;

@Service("tsStreamPackagedService")
public class TSStreamPackagedServiceImpl implements TSStreamPackagedService {

	public Logger logger = LoggerFactory.getLogger(TSStreamPackagedServiceImpl.class);

	/**
	 * 索引表TS流封装
	 */
	@Override
	public byte[] getEBITTsData(EBITParamsVO paramsVO, String broadcastType) {
		try {
			/**
			 * 平台资源编码 广西省的要求有72byte,16进制数就是72/4=18位
			 * platformResourceCode直接封装起来,然后再一起转BCD码
			 */
			String platformResourceCode = paramsVO.getPlatformResourceCode();

			EBIT ebit = new EBIT();
			// section_number 每增加一个段就加一 8byte 0-255范围
			ebit.section_number = 0;
			ebit.last_section_number = 0;
			EBIT.EBMInfo ebminfo = new EBIT.EBMInfo(platformResourceCode, paramsVO.getfId(),
					paramsVO.getEBM_start_time());

			ebminfo.EBM_class = paramsVO.getEBM_class();
			ebminfo.EBM_level = paramsVO.getEBM_level();

			// 定时广播的结束时间,特殊处理-默认加10分钟
			// 2019-04-12 lxg
			/**
			 * 0-local 1-UTC lxg 2019-04-04
			 */
			if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 0) {
				ebminfo.EBM_start_time = new MJDDateTime(paramsVO.getEBM_start_time());
				ebminfo.EBM_end_time = new MJDDateTime(paramsVO.getfState() == BroadcastTypeEnum.timing.getCode()
						? new Date(paramsVO.getEBM_start_time().getTime() + 600000) : paramsVO.getEBMEndTime());
			} else if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 1) {
				ebminfo.EBM_start_time = new MJDDateTime(DateUtil.localToUTC(paramsVO.getEBM_start_time()));
				ebminfo.EBM_end_time = new MJDDateTime(
						DateUtil.localToUTC(paramsVO.getfState() == BroadcastTypeEnum.timing.getCode()
								? new Date(paramsVO.getEBM_start_time().getTime() + 600000)
								: paramsVO.getEBMEndTime()));
			}

			/**
			 * 这部分参数根据平台编码设备参数据实设置
			 */
			ebminfo.details_channel_PCR_PID = paramsVO.getDetails_channel_PCR_PID();
			ebminfo.EBM_original_network_id = 1;
			ebminfo.details_channel_indicate = 1;// 标识 有详情通道
			ebminfo.details_channel_program_number = paramsVO.getDetails_channel_program_number();
			ebminfo.details_channel_transport_stream_id = paramsVO.getTs_id();

			/**
			 * 加入有线DVB-C描述子 0x44 13btye 26位hex 440B03000000FFF00287500000 去掉440B
			 */
			if (broadcastType.equals(BroadcastTypeKeyEnum.DVBC.getDesc())) {
				CustomDescriptor desDVBC = new CustomDescriptor();
				desDVBC.setDescriptorTag(Descriptors.DescriptorTag.Cable_Delivery_System_Descriptor);
				byte[] customDesData = hexStringToByte(paramsVO.getDVBC_parameter());
				desDVBC.setCustomData(customDesData);
				ebminfo.descriptors1.add(desDVBC);
			}

			/**
			 * 加入地面DTMB描述子 0x5A 13btye 26位hex 5A0B05000000141113FFFFFFFF 去掉5A0B
			 */
			if (broadcastType.equals(BroadcastTypeKeyEnum.DTMB.getDesc())) {
				CustomDescriptor desDVBC = new CustomDescriptor();
				desDVBC.setDescriptorTag(Descriptors.DescriptorTag.Terrestrial_Delivery_System_Descriptor);
				byte[] customDesData = hexStringToByte(paramsVO.getDTMB_parameter());
				desDVBC.setCustomData(customDesData);
				ebminfo.descriptors1.add(desDVBC);
			}

			/**
			 * 音频流信息
			 */
			EBIT.EBMInfo.StreamInfo stream = new EBIT.EBMInfo.StreamInfo();
			/**
			 * PID 1500 0x05DC可以 0x5DC可以 1500可以 不用转码
			 */
			stream.elementary_PID = paramsVO.getElementary_PID();// 从系统中相关设备中获取，由用户输入
			stream.stream_type = paramsVO.getMediaType();
			stream.descriptors.add(new AudioStreamDescriptor());
			ebminfo.streams.add(stream);

			/**
			 * 突发事件
			 */
			ebminfo.setEBMType(paramsVO.getEBM_type()); // error 必须是5个字符

			// 区域编码的list
			ebminfo.setResourceCodes(paramsVO.getResourceCodeList());
			ebit.ebminfos.add(ebminfo);

			List<String> privateKeys = new ArrayList<String>();
			// 县平台证书私钥
			privateKeys.add(paramsVO.getPrivateKey());

			SignatureData sign = new SignatureData(privateKeys);
			ebit.signatures.add(sign);

			byte[] data = ebit.convertToBytes();
			byte[] tsPakage = null;
			/**
			 * 如果是县级广播,21;如果是镇或者村级广播，22
			 */
			if (paramsVO.getResourceCodeList()
					.contains(paramsVO.getAdapterPrefix() + paramsVO.getCountyResourceCode() + "00")) {
				tsPakage = Tools.Section2TsBuf(data, (short) 0x21, true);
			} else {
				tsPakage = Tools.Section2TsBuf(data, (short) 0x22, true);
			}
			return tsPakage;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}

	/**
	 * 发广播时 配置表中只需要 时钟校验配置 配置表TS流封装 字段全部封装在 索引表中 EBITParamsVO paramsVO
	 * 
	 * @author lxg
	 * @since 2019-01-25
	 */
	@Override
	public byte[] getEBCONTTsData(EBITParamsVO paramsVO) {
		try {
			// 配置表
			EBCONT ebcont = new EBCONT();
			// 1.时钟校准指令
			TimeSettingCmd timeSettingCmd = new TimeSettingCmd();

			Date date = null;
			/**
			 * 0-local 1-UTC lxg 2019-04-04
			 */
			if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 0) {
				date = new Date();
			} else if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 1) {
				date = DateUtil.localToUTC(new Date());
			}
			timeSettingCmd.setTime(date);
			ebcont.Configure_Cmds.add(timeSettingCmd);

			ColumnSettingCmd columnCmd = new ColumnSettingCmd();
			columnCmd.setTermialAddress((byte) 1, paramsVO.getTermialResourceCodeList());

			// 音量8bit 100   2019-04-13 lxg
			//这样写会有问题的  90-5a  58-3a  "3a"java.lang.NumberFormatException: For input string: "3a"
			// columnCmd.column = paramsVO.getVolume();
//			columnCmd.column = Byte.parseByte(Integer.toHexString(paramsVO.getVolume()));
//			ebcont.Configure_Cmds.add(columnCmd);

			// 8.终端采用RDS传输方式进行设置 2019-03-27 lxg
			// RDSSettingCmd rDSSettingCmd = new RDSSettingCmd();
			// 终端设备类型
			// rDSSettingCmd.setTermialAddress((byte) 1,
			// paramsVO.getTermialResourceCodeList());
			// // 4：应急广播适配器+收扩机+音柱
			// rDSSettingCmd.Terminal_rds_set =
			// eBCONTParamsVO.getfTerminalRdsSet(); //
			// rDSSettingCmd.Terminal_rds_data =
			// eBCONTParamsVO.getfTerminalRdsData().getBytes();
			// ebcont.Configure_Cmds.add(rDSSettingCmd);

			// 添加签名
			List<String> privateKeys = new ArrayList<String>();
			// 县平台证书私钥
			privateKeys.add(paramsVO.getPrivateKey());

			SignatureData sign = new SignatureData(privateKeys);

			ebcont.signatures.add(sign);

			byte[] tsConfPakage = null;
			/**
			 * 如果是县级广播,21;如果是镇或者村级广播，22
			 */
			if (paramsVO.getResourceCodeList()
					.contains(paramsVO.getAdapterPrefix() + paramsVO.getCountyResourceCode() + "00")) {
				tsConfPakage = Tools.Section2TsBuf(ebcont, (short) 0x21);
			} else {
				tsConfPakage = Tools.Section2TsBuf(ebcont, (short) 0x22);
			}
			return tsConfPakage;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}
	
	/**
	 * 停播指令
	 */
	@Override
	public byte[] getStopBroadcastData(EBITParamsVO paramsVO) {

		try {
			// 配置表
			EBCONT ebcont = new EBCONT();
			// 1.时钟校准指令
			TimeSettingCmd timeSettingCmd = new TimeSettingCmd();

			Date date = null;
			/**
			 * 0-local 1-UTC lxg 2019-04-04
			 */
			if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 0) {
				date = new Date();
			} else if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 1) {
				date = DateUtil.localToUTC(new Date());
			}
			timeSettingCmd.setTime(date);
			ebcont.Configure_Cmds.add(timeSettingCmd);

			// 3.工作模式设置
			WorkModeSettingCmd workModeSettingCmd = new WorkModeSettingCmd();
			workModeSettingCmd.Terminal_wordmode = 2;
			workModeSettingCmd.setTermialAddress((byte) 1, paramsVO.getTermialResourceCodeList());
			ebcont.Configure_Cmds.add(workModeSettingCmd);

			// 添加签名
			List<String> privateKeys = new ArrayList<String>();
			// 县平台证书私钥
			privateKeys.add(paramsVO.getPrivateKey());

			SignatureData sign = new SignatureData(privateKeys);

			ebcont.signatures.add(sign);

			byte[] tsConfPakage = null;
			/**
			 * 如果是县级广播,21;如果是镇或者村级广播，22
			 */
			if (paramsVO.getResourceCodeList()
					.contains(paramsVO.getAdapterPrefix() + paramsVO.getCountyResourceCode() + "00")) {
				tsConfPakage = Tools.Section2TsBuf(ebcont, (short) 0x21);
			} else {
				tsConfPakage = Tools.Section2TsBuf(ebcont, (short) 0x22);
			}
			return tsConfPakage;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}

	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static int toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	// String platformResourceCode = "23400000000000101010101";
	// ebminfo.setEBMid("010145022600000000201812240001"); //这条记录重复了
	// ebminfo.EBM_class = 1;
	// ebminfo.EBM_level = 1;
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// ebminfo.EBM_start_time = new MJDDateTime(sdf.parse("2019-12-17
	// 10:00:00"));
	// ebminfo.EBM_end_time = new MJDDateTime(sdf.parse("2019-12-17 20:00:00"));
	// Date startTime=new Date();
	// ebminfo.EBM_start_time = new MJDDateTime(startTime);
	// ebminfo.EBM_end_time = new MJDDateTime(new Date(startTime.getTime() +
	// 300000));
	// ebminfo.details_channel_PCR_PID = 0x1ffe;
	// ebminfo.details_channel_program_number = 16;
	// byte[] customDesData = new byte[] { 0x12, 0x22, 0x33, 0x33 };//
	// 从系统中相关设备中获取，由用户输入
	// stream.elementary_PID = 1500; //对应1500 范围在[16-3840]之间 从系统中相关设备中获取，由用户输入
	// ebminfo.setEBMType("20000");
	// 区域编码 静态方式
	// ArrayList<String> resourceCodeList = new ArrayList<>();
	// String s = "061215231002000314";// 第一个资源编码
	// resourceCodeList.add(s);
	// s = "061252300000003140";// 第二个
	// resourceCodeList.add(s);//
	// 区域编码 方式1
	// String[] arrayResourceCodes =
	// paramsVO.getEBM_resource_codes().split(",");
	// //String[]转list
	// List<String> resourceCodeList = Arrays.asList(arrayResourceCodes);
	// ebminfo.setResourceCodes(resourceCodeList);

	// SignatureData sign = new SignatureData();
	// ebit.signatures.add(sign);

	/*
	 * 有效期限为 创建时间+5/10min 即为结束时间
	 */
	// Date end_Time = new Date(paramsVO.getEBM_start_time().getTime() +
	// 600000);

	// ebminfo.EBM_end_time = new MJDDateTime(end_Time);

	// if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 0) {
	// ebminfo.EBM_start_time = new MJDDateTime(paramsVO.getEBM_start_time());
	// ebminfo.EBM_end_time = new MJDDateTime(paramsVO.getEBMEndTime());
	// } else if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 1) {
	// ebminfo.EBM_start_time = new
	// MJDDateTime(DateUtil.localToUTC(paramsVO.getEBM_start_time()));
	// ebminfo.EBM_end_time = new MJDDateTime(
	// DateUtil.localToUTC(paramsVO.getEBMEndTime()));
	// }

	/**
	 * 内容表TS流封装
	 */
	@Override
	public EBCTTsDataVO getEBCTTsData(EBITParamsVO paramsVO) {
		EBCTTsDataVO ebCTTsDataVO = new EBCTTsDataVO();
		Map<Object, Object> m1 = new HashMap<Object, Object>();
		m1.put(0, "保留");
		m1.put(1, "MPEG-1 LayerI/II音频文件");
		m1.put(2, "MPEG-1 LayerIII音频文件");
		m1.put(0x15, "MPEG-2编码音视频文件");
		m1.put(0x16, "H.264编码音视频文件(可选)");
		m1.put(0x17, "AVS+编码音视频文件(可选)");
		m1.put(0x29, "PNG图片文件");
		m1.put(0x2a, "JPEG图片文件");
		m1.put(0x2b, "GIF图片文件(可选)");
		m1.put(0x2c, "终端升级");
		m1.put(0x2d, "RDS数据透传");
		// 辅助数据
		List<String> privateKeys = new ArrayList<String>();
		// 县平台证书私钥
		privateKeys.add(paramsVO.getPrivateKey());

		ArrayList<EBCT.Multilingual_ContentInfo.AuxiliaryDataInfo> auxiliaryDatas = new ArrayList<EBCT.Multilingual_ContentInfo.AuxiliaryDataInfo>();
		AuxiliaryDataInfo auxiliaryDataInfo = new AuxiliaryDataInfo();
		/*
		 * auxiliaryDataInfo.auxiliary_data_type = 0;
		 * auxiliaryDataInfo.auxiliary_data = new byte[] { 0x11, 0x22, 0x33 };
		 * auxiliaryDatas.add(auxiliaryDataInfo);
		 * 
		 * auxiliaryDataInfo = new AuxiliaryDataInfo();
		 * auxiliaryDataInfo.auxiliary_data_type = 0x16;
		 * auxiliaryDataInfo.auxiliary_data = new byte[] { 0x1a, 0x2b, 0x3c,
		 * (byte) 0xe0 }; auxiliaryDatas.add(auxiliaryDataInfo);
		 */

		// rds透传
		auxiliaryDataInfo.auxiliary_data_type = (byte) 0x2d;
		// TODO rds数据
		auxiliaryDataInfo.auxiliary_data = new byte[] { 0x11, 0x22, 0x33 };
		auxiliaryDatas.add(auxiliaryDataInfo);

		byte[] EBM_ID = Util.hexStringToBytes("01020304050607080a0b0c0d0e0f01");// 广西15字节
		String messageText = "这是一个应急广播测试内容";
		String agencyName = "湖北博远智家";
		try {
			// ArrayList<EBCT> ebctList = EBCT.createEBCTSections(EBM_ID,
			// messageText, agencyName, auxiliaryDatas);
			/**
			 * 由于 县平台私钥 是 动态获取的 ;而内容表中需要封装 数据签名 改动 lxg 2019-02-21
			 */
			SignatureData sign = new SignatureData(privateKeys);
			ArrayList<EBCT> ebctList = EBCT.createEBCTSections(EBM_ID, messageText, agencyName, auxiliaryDatas, sign);
			byte[] tsBuf = new byte[1024 * 1024 * 8];
			int offSet = 0;
			for (EBCT item : ebctList) {
				byte[] data = item.convertToBytes();
				data = Tools.Section2TsBuf(data, (short) 0x21, true);
				System.arraycopy(data, 0, tsBuf, offSet, data.length);
				offSet += data.length;
			}
			ebCTTsDataVO.setData(tsBuf);
			ebCTTsDataVO.setLength(offSet);
			return ebCTTsDataVO;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}

	/**
	 * 设备参数配置 跟广播无关 用来给设备 发送配置表 修改设备相关参数
	 * 
	 * @param BeBCONTParamsVO
	 *            eBCONTParamsVO
	 * @author lxg
	 * @since 2019-01-25
	 */
	@Override
	public byte[] updateDeviceParameter(EBCONTParamsVO eBCONTParamsVO) {

		// 获取 设备资源编码 0612122,06122133,.........
		/*
		 * String resourceCodes = eBCONTParamsVO.getfDeviceResourceCode();
		 * String[] strings = resourceCodes.split(","); List<String>
		 * termialResourceCodeList = Arrays.asList(strings);
		 */
		List<String> termialResourceCodeList = Arrays.asList(eBCONTParamsVO.getfDeviceResourceCode().split(","));

		try {
			// 配置表
			EBCONT ebcont = new EBCONT();
			// 1.时钟校准指令
			TimeSettingCmd timeSettingCmd = new TimeSettingCmd();
			timeSettingCmd.setTime(new Date());
			ebcont.Configure_Cmds.add(timeSettingCmd);

			// 2.区域码设置
			if (eBCONTParamsVO.getfAddressSettingCmd()) {
				AddressSettingCmd addressSettingCmd = new AddressSettingCmd();
				// 物理地址 6字节 12hex
				addressSettingCmd.setPhysicalAddress(eBCONTParamsVO.getfPhysicalAddress());
				// 终端逻辑编码地址 72bit 18位Hex
				addressSettingCmd.setLogicAddress(eBCONTParamsVO.getfLogicDdress());
				ebcont.Configure_Cmds.add(addressSettingCmd);
			}

			// 3.工作模式设置
			if (eBCONTParamsVO.getfWorkmodeSettingCmd()) {
				WorkModeSettingCmd workModeSettingCmd = new WorkModeSettingCmd();
				workModeSettingCmd.Terminal_wordmode = eBCONTParamsVO.getfWorkmode();
				workModeSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				ebcont.Configure_Cmds.add(workModeSettingCmd);
			}

			// 4.锁定频率设置
			if (eBCONTParamsVO.getfFreqSettingCmd()) {
				FreqSettingCmd freqSettingCmd = new FreqSettingCmd();
				freqSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				if (eBCONTParamsVO.getfDtmb()) {
					freqSettingCmd.DTMBorDVBC = 1;
					// TODO 符号率(KBPS)(采用十六进制) 和 Freq ???
					freqSettingCmd.Freq = Integer.parseInt(eBCONTParamsVO.getfDtmbFreq());
					freqSettingCmd.SymbolRate = Integer.parseInt(eBCONTParamsVO.getfDtmbSymbolrate());
					freqSettingCmd.QAM = eBCONTParamsVO.getfDtmbQam();
				}
				if (eBCONTParamsVO.getfDvbc()) {
					freqSettingCmd.DTMBorDVBC = 2;
					freqSettingCmd.Freq = Integer.parseInt(eBCONTParamsVO.getfDvbcFreq());
					freqSettingCmd.SymbolRate = Integer.parseInt(eBCONTParamsVO.getfDvbcSymbolrate());
					freqSettingCmd.QAM = eBCONTParamsVO.getfDvbcQam();
				}
				ebcont.Configure_Cmds.add(freqSettingCmd);
			}

			// 5.设置回传方式及回传地址 2019/03/04
			/**
			 * 回传方式 1：短信，地址为11个数字电话号码 2：IP通道，使用UDP协议，固定服务器ip地址回传
			 * 3：IP通道，使用UDP协议，域名服务器地址回传 4：IP通道，使用TCP协议，固定服务器ip地址回传
			 * 5：IP通道，使用TCP协议，域名服务器地址回传 6：GPRS通道，使用UDP协议，固定服务器ip地址回传
			 * 7：GPRS通道，使用UDP协议，域名服务器地址回传 8：GPRS通道，使用TCP协议，固定服务器ip地址回传
			 * 9：GPRS通道，使用TCP协议，域名服务器地址回传 10~255：保留
			 */
			if (eBCONTParamsVO.getfRebacktypeAndAddressCmd()) {
				RebackTypeAndAddressSettingCmd rebackTypeAndAddressSettingCmd = new RebackTypeAndAddressSettingCmd();
				rebackTypeAndAddressSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				rebackTypeAndAddressSettingCmd.reback_type = eBCONTParamsVO.getfRebackType();
				// 电话短信
				if (rebackTypeAndAddressSettingCmd.reback_type == 1) {
					// reback_tel_number(采用ASCII字符)
					rebackTypeAndAddressSettingCmd.reback_tel_number = eBCONTParamsVO.getfRebackTelNumber();
				} else if (rebackTypeAndAddressSettingCmd.reback_type == 2) {
					// 16进制数
					rebackTypeAndAddressSettingCmd.reback_IP_address1 = eBCONTParamsVO.getfRebackIpAddress1();
					rebackTypeAndAddressSettingCmd.reback_IP_address2 = eBCONTParamsVO.getfRebackIpAddress2();
					rebackTypeAndAddressSettingCmd.reback_IP_port1 = Short
							.parseShort(eBCONTParamsVO.getfRebackIpPort1());
					rebackTypeAndAddressSettingCmd.reback_IP_port2 = Short
							.parseShort(eBCONTParamsVO.getfRebackIpPort2());
				} else if (rebackTypeAndAddressSettingCmd.reback_type == 3) {
					rebackTypeAndAddressSettingCmd.reback_domain_name = eBCONTParamsVO.getfRebackDomainName();
					rebackTypeAndAddressSettingCmd.reback_domain_nameport = Short
							.parseShort(eBCONTParamsVO.getfRebackDomainNameport());
				}

				ebcont.Configure_Cmds.add(rebackTypeAndAddressSettingCmd);
			}

			// 6.设置音量
			if (eBCONTParamsVO.getfColumnSettingCmd()) {
				ColumnSettingCmd columnCmd = new ColumnSettingCmd();
				columnCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				// 音量8bit 100
				columnCmd.column = eBCONTParamsVO.getfColumn();
				ebcont.Configure_Cmds.add(columnCmd);
			}

			// 7.设置回传周期
			if (eBCONTParamsVO.getfRebackPeriodSettingCmd()) {
				RebackPeriodSettingCmd rebackPeriodSettingCmd = new RebackPeriodSettingCmd();
				rebackPeriodSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				// 回传周期统一换算为秒，1天=86400秒 默认1天回传
				rebackPeriodSettingCmd.reback_period = eBCONTParamsVO.getfRebackPeriod();
				ebcont.Configure_Cmds.add(rebackPeriodSettingCmd);
			}

			// 8.终端采用RDS传输方式进行设置
			if (eBCONTParamsVO.getfRdsSettingCmd()) {
				RDSSettingCmd rDSSettingCmd = new RDSSettingCmd();
				rDSSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				// 终端设备类型 4：应急广播适配器 + 收扩机 + 音柱
				rDSSettingCmd.Terminal_rds_set = eBCONTParamsVO.getfTerminalRdsSet();
				rDSSettingCmd.Terminal_rds_data = eBCONTParamsVO.getfTerminalRdsData().getBytes();
				ebcont.Configure_Cmds.add(rDSSettingCmd);
			}

			// 9.终端巡检设置
			if (eBCONTParamsVO.getfTerminalInspectSettingCmd()) {
				TerminalInspectSettingCmd terminalInspectSettingCmd = new TerminalInspectSettingCmd();
				terminalInspectSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				terminalInspectSettingCmd.Terminal_Reback_type = eBCONTParamsVO.getfTerminalRebackType();
				terminalInspectSettingCmd.reback_period = eBCONTParamsVO.getfRebackPeriod();
				ebcont.Configure_Cmds.add(terminalInspectSettingCmd);
			}

			// 10.终端控制PID设置
			if (eBCONTParamsVO.getfTerminalPidSettingCmd()) {
				TerminalPIDSettingCmd terminalPIDSettingCmd = new TerminalPIDSettingCmd();
				terminalPIDSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				terminalPIDSettingCmd.Terminal_PID_set = (byte) Integer.parseInt(eBCONTParamsVO.getfTerminalPidSet());
				ebcont.Configure_Cmds.add(terminalPIDSettingCmd);
			}

			// 11.录音文件提取 暂时放着 2019/03/04 lxg
			if (eBCONTParamsVO.getfRecordExtractSettingCmd()) {
				RecordExtractSettingCmd recordExtractSettingCmd = new RecordExtractSettingCmd();
				recordExtractSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				recordExtractSettingCmd.Audio_reback_mode = eBCONTParamsVO.getfAudioRebackMode();
				recordExtractSettingCmd.Audio_reback_port = Short.parseShort(eBCONTParamsVO.getfAudioRebackPort());
				recordExtractSettingCmd.Audio_reback_serverip = eBCONTParamsVO.getfAudioRebackServerip();
				recordExtractSettingCmd.record_file_name = eBCONTParamsVO.getfRecordFileName();
				recordExtractSettingCmd.Start_package_num = Integer.parseInt(eBCONTParamsVO.getfStartPackageNum());
				ebcont.Configure_Cmds.add(recordExtractSettingCmd);
			}

			// 12.音频实时回传
			if (eBCONTParamsVO.getfAudioRebackSettingCmd()) {
				AudioRebackSettingCmd audioRebackSettingCmd = new AudioRebackSettingCmd();
				audioRebackSettingCmd.setTermialAddress((byte) 1, termialResourceCodeList);
				audioRebackSettingCmd.kaiguan = (byte) (eBCONTParamsVO.getfKaiguan() == true ? 1 : 0);
				// 1：UDP 2：TCP
				audioRebackSettingCmd.Audio_reback_mode = eBCONTParamsVO.getfAudioRebackMode2();
				audioRebackSettingCmd.Audio_reback_serverip = eBCONTParamsVO.getfAudioRebackServerip2();
				audioRebackSettingCmd.Audio_reback_port = Short.parseShort(eBCONTParamsVO.getfAudioRebackPort2());
				ebcont.Configure_Cmds.add(audioRebackSettingCmd);
			}

			// 添加签名
			List<String> privateKeys = new ArrayList<String>();
			// 县平台证书私钥
			privateKeys.add(eBCONTParamsVO.getPrivateKey());
			SignatureData sign = new SignatureData(privateKeys);
			ebcont.signatures.add(sign);

			return Tools.Section2TsBuf(ebcont, (short) 0x21);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			return null;
		}
	}

	/**
	 * 将ip转换为16进制
	 * 
	 * @param ipString
	 * @return
	 */
	public static String ipToHex(String ip) {
		String ipHex = "";
		String[] strings = ip.split("\\.");
		for (String string : strings) {
			String string2 = Integer.toHexString(Integer.parseInt(string));
			// string2 需要有两位 2hex
			if (string2.length() == 1) {
				string2 = "0" + string2;
			}
			ipHex += string2;
		}
		return ipHex;
	}

	public static void main(String[] args) {
//		Date date = DateUtil.localToUTC(new Date());
//		System.out.println(date);// Thu Apr 04 09:35:51 CST 2019
		// System.out.println(ipToHex("192.168.23.15"));
		TimeSettingCmd timeSettingCmd = new TimeSettingCmd();
		timeSettingCmd.setTime(new Date());
		System.out.println(timeSettingCmd);
	}

	// 2019-01-20 平时测试 适配器(设备资源编码) 061245140210220301
	// List<String> termialResourceCodeList = new ArrayList<>();
	// termialResourceCodeList.add("061245140210220301");// 第一个
	// columnCmd.setTermialAddress((byte) 1, termialResourceCodeList);
	// columnCmd.column = 100;
	// SignatureData sign = new SignatureData();
	// ebcont.signatures.add(sign);

	public void deviceUpdateHandle(TsDeviceUpdateVo tsDeviceUpdateVo, String programRootUrl, String path) {
		UMT umt = new UMT();
		Upgrade_Descriptor upgradeDes = new Upgrade_Descriptor();
		upgradeDes.update_type = 1;// 强制升级

		upgradeDes.delivery_system = 1;// DTMB
		upgradeDes.modulationDescriptor = new CustomDescriptor();
		upgradeDes.modulationDescriptor
				.setDescriptorTag(Descriptors.DescriptorTag.Terrestrial_Delivery_System_Descriptor);
		byte[] customDesData = new byte[] { 0x04, 0x74, 0x00, 0x00, 0x04, 0x10, 0x03, (byte) 0xff, (byte) 0xff,
				(byte) 0xff, (byte) 0xff };// 从系统中相关设备中获取，由用户输入
		upgradeDes.modulationDescriptor.setCustomData(customDesData);

		// ArrayList<String> resourceCodeList = new ArrayList<String>();
		// String s = "061245108110000000";//第一个资源编码
		// resourceCodeList.add(s);//可添加多个资源编码
		upgradeDes.setResourceCodes(tsDeviceUpdateVo.getDeviceResourceCodes());

		Upgrade_Descriptor.PackInfo packInfo = new Upgrade_Descriptor.PackInfo();// 版本信息
		packInfo.Manufaturer_number = Short.parseShort(tsDeviceUpdateVo.getfManufacturerNumber());
		packInfo.hardware_version = Short.parseShort(tsDeviceUpdateVo.getfHardwareVersion());
		// packInfo.software_version=new byte[]{0,0,0,1};//TODO 16 26 该怎样表示呢 0 0
		// 0 16/F
		packInfo.software_version = new byte[] { 0, 0, 0,
				(byte) Integer.parseInt(tsDeviceUpdateVo.getfOldSoftwareVersion()) };
		upgradeDes.packInfos.add(packInfo);

		String upgradeBinFileName = tsDeviceUpdateVo.getfFileAddress();// 升级文件名
		File file = new File(upgradeBinFileName);
		upgradeDes.uiFileLength = (int) (file.length());

		upgradeDes.usPidOfUDT = 0x1501;// 升级PID

		umt.UpgradeDescriptors.add(upgradeDes);// 添加一个描述子，如果有多个版本的升级流同时下发，添加多个描述子

		byte[] umtTsPack = Tools.Section2TsBuf(umt, (short) 0x21);// 生成UMT升级包

		// TODO 这里设置为 项目相对路径下,然后再用http方式访问

		// String udtTsFileName="c:\\a.ts";
		String udtTsFileName = programRootUrl + path;
		try {
			UDT.createUpdateTSFile(upgradeBinFileName, upgradeDes.usPidOfUDT, udtTsFileName);// 考虑到升级文件可能比较大，先生成文件，发送时，每次从文件里读取188字节发送
		} catch (IOException e) {
			logger.error(e.getMessage() + e);
		}

		// 建议发送采用2个线程进行，一个发送umtTsPack,一个发送udtTsFileName文件数据，发送一包umt数据，发10包udt数据

		try {
			Thread test1 = new Thread(new TsDeviceUpdateThread(1, umtTsPack));
			test1.start();

			Thread test2 = new Thread(new TsDeviceUpdateThread(2, path));
			test2.start();
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	/**
	 * 获取RDS指令数据 lxg 2019-04-9
	 */
	public void getRDSData(EBITParamsVO paramsVO) {
		/*
		 * 1、准备指令内容，如设置频点 02 01 01 01 5B A8 02 02 01 A1 F8 2、数据包内容 00 23 01 06
		 * 12 45 14 02 10 22 03 00 指令内容、UTC、签名、CRC16
		 * 3、签名：(指令内容+UTC)的CRC16再填充6字节0，DES加密 4、CRC16是对帧序号、指令内容、填充字的校验
		 * 5、分包发送，每帧8字节RDS数据：来源级别、数据报ID、数据帧总数、当前帧序号、有效信息数据、CRC8 校验
		 * 
		 * 透传的是每帧8字节RDS数据
		 */
		// 准备指令内容
		String commandContent = "020101015BA8020201A1F8";

		// 数据包内容
		// 数据包头部
		String head = "002301061245140210220300";

		StringBuilder sb = new StringBuilder(head);
		sb.append(commandContent);

		// UTC时间
		Date date = null;
		/**
		 * 0-local 1-UTC lxg 2019-04-04
		 */
		if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 0) {
			date = new Date();
		} else if (Integer.parseInt(paramsVO.getTimeZoneSet()) == 1) {
			date = DateUtil.localToUTC(new Date());
		}
		sb.append(date);
	}
}
