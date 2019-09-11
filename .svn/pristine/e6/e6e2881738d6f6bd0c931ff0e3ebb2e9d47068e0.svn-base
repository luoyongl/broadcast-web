package cn.wtu.broadcast.openapi.api;

import cn.wtu.broadcast.openapi.vo.EBCTTsDataVO;
import cn.wtu.broadcast.parent.vo.EBCONTParamsVO;
import cn.wtu.broadcast.parent.vo.EBITParamsVO;
import cn.wtu.broadcast.parent.vo.TsDeviceUpdateVo;

public interface TSStreamPackagedService {

	/**
	 * 索引表TS流封装
	 */
	public byte[] getEBITTsData(EBITParamsVO paramsVO,String type);
	
	/**
	 * 内容表TS流封装
	 */
	public EBCTTsDataVO getEBCTTsData(EBITParamsVO paramsVO);
	
	/**
	 * 配置表TS流封装
	 */
	public byte[] getEBCONTTsData(EBITParamsVO paramsVO);
	
	/**
	 * ts方式设备升级
	 * 2019/04/01 lxg
	 * @param uploadUrl  转换为ts文件的路径
	 */
	public void deviceUpdateHandle(TsDeviceUpdateVo tsDeviceUpdateVo, String programRootUrl,String path);
	
	/**
	 * 设备参数配置
	 * 2019/03/05 lxg
	 */
	public byte[] updateDeviceParameter(EBCONTParamsVO eBCONTParamsVO);
	
	/**
	 * ts发送停播指令
	 * 2019/04/05 lxg
	 */
	public byte[] getStopBroadcastData(EBITParamsVO paramsVO);
	
	/**
	 * 获取RDS指令数据
	 * 2019-04-9 lxg 
	 */
	public void getRDSData(EBITParamsVO paramsVO);
	
}
