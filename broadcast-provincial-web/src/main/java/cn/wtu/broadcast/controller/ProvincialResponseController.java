package cn.wtu.broadcast.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wtu.broadcast.openapi.api.BBroadcastDeviceService;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.DispatchHttpclientService;
import cn.wtu.broadcast.openapi.api.ThirdBroadcastDataService;
import cn.wtu.broadcast.openapi.model.BBroadcastDevice;
import cn.wtu.broadcast.openapi.vo.ebm.EBDXmlModel;
import cn.wtu.broadcast.parent.enums.BroadcastTypeEnum;
import cn.wtu.broadcast.parent.enums.EBDTypeEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.utils.PropertiesUtil;
import cn.wtu.broadcast.parent.vo.EBITParamsVO;
import cn.wtu.broadcast.util.EBFileUtil;
import cn.wtu.broadcast.util.EBHttpURLConnectionUtil;
import cn.wtu.broadcast.util.EBTarUtil;
import cn.wtu.broadcast.util.EBXMConvertUtil;
import cn.wtu.broadcast.util.TtsUtil;
import ws.schild.jave.MultimediaObject;

@Controller
@RequestMapping("provincial")
public class ProvincialResponseController {

	@Autowired
	ThirdBroadcastDataService thirdBroadcastDataService;
    @Autowired
    private DispatchHttpclientService dispatchHttpclientService;
    @Autowired
    private BDeviceInfoService deviceInfoService;
	@Autowired
	private BBroadcastDeviceService broadcastDeviceService;
    
    @Value("${dispatch.server.tomcat.port}")
    private String dispatchServerTomcatPort;

	private String uploadPrefixUrl = PropertiesUtil.getProperty("upload.prefix.url");

	private static Logger logger = LoggerFactory.getLogger(ProvincialResponseController.class);

	/**
	 * 测试用： 模拟省级平台主动发送文件（为了切合模拟工具）
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sendProvincialTar", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult sendProvincialTar(@RequestParam("upfile") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		// 服务器上传tar文件保存测试
		String path = EBFileUtil.saveProvincialTar(file);
		// 服务器上传tar文件解压测试
		List<String> compressFilePaths = EBTarUtil.unCompressTar(path);
		// 本地生成文件压缩测试
		EBTarUtil.compressTar(compressFilePaths, file.getOriginalFilename(), "C:/compressTest/");
		// 上传tar文件到省级平台测试（同时测试回传结果）
		String result = EBHttpURLConnectionUtil.sendTarToProvince(path);
		System.out.println(result);

		return BroadcastResult.ok();
	}

	/**
	 * 测试用： 模拟省级平台接受tar包同时回传tar包
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/provincialTest", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult provincialTest(HttpServletRequest request, HttpServletResponse response) {
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = multipartRequest.getFiles("upfile");
			System.out.println(files);
		}

		// 使用Apache文件上传组件处理文件上传步骤
		try {
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				System.out.println("没有文件上传");
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			System.out.println(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return BroadcastResult.ok();
	}

	/**
	 * 测试工具模拟省级平台主动推送文件测试
	 * 
	 * @param request
	 *            注意测试工具里面上传文件的key为"upfile"
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getProvincialTar", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult getProvincialTar(@RequestParam("upfile") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			
			EBITParamsVO paramsVO = new EBITParamsVO();
			// 多种模式获取文件方式。目前采用CommonsMultipartFile
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				List<MultipartFile> files = multipartRequest.getFiles("upfile");
				if (files != null && files.size() > 0) {
					System.out.println(files);
				}
			}
			// 服务器上传tar文件保存同时返回保存的地址
			String path = EBFileUtil.saveProvincialTar(file);
			String filename = file.getOriginalFilename();
			String preUrl = path.replace(filename, "");
			// 服务器上传tar文件解压测试
			List<String> compressFilePaths = EBTarUtil.unCompressTar(path);
			if (compressFilePaths != null && compressFilePaths.size() > 0) {
				for (String filePath : compressFilePaths) {
					try {
						if (filePath.endsWith(".xml") && !filePath.contains("EBDS")) {
							String ebdType = EBXMConvertUtil.getNodeValue(filePath, "EBDType");
							String classType = EBDTypeEnum.getEnumByCode(ebdType).getXmlModelType();
							// 应急广播业务数据解析同时插入数据库
							EBDXmlModel model = null;
							if (classType != null && classType.contains("EBDXmlModel")) {
								model = (EBDXmlModel) EBXMConvertUtil.xmlConvertToModel(filePath, classType);
							}
							
							paramsVO.setEBM_type(model.getEbm().getMsgBasicInfo().getEventType());//消息类型
							paramsVO.setEBM_level((byte)Integer.parseInt(model.getEbm().getMsgBasicInfo().getSeverity()));//消息级别
//							paramsVO.setEBM_start_time(model.getEbm().getMsgBasicInfo().getStartTime());//开始时间
//							paramsVO.setEBMEndTime(model.getEbm().getMsgBasicInfo().getEndTime());//结束时间
							paramsVO.setEBM_start_time(new Date());//开始时间
							paramsVO.setEBMEndTime(new Date(new Date().getTime() + 600000));//结束时间
							
							String[] areaCode2 = model.getEbm().getMsgContent().getAreaCode().split(",");
							
							String name = model.getEbm().getMsgContent().getAuxiliary().getAuxiliaryDesc();
							String fileUrl = preUrl + name;
							File oldFile = new File(preUrl + File.separator + name);
						    File source = oldFile;
						    MultimediaObject multimediaObject = new MultimediaObject(source);
						    System.out.println(multimediaObject.getInfo().getAudio().getBitRate());
						    MultipartFile multipartFile =null;
						    if(multimediaObject.getInfo().getAudio().getBitRate()<128){
						    	File newFile = new File(preUrl + File.separator + "new"+name);
								TtsUtil.changeBitRate(oldFile, newFile);
								multipartFile = new MockMultipartFile(name, new FileInputStream(preUrl + File.separator + "new" + name));
						    }else{
								// File sourceFile=new File(fileUrl);//本地源文件
								 multipartFile = new MockMultipartFile(name, new FileInputStream(preUrl + File.separator + name));
						    }
							String audioPath = "upload/EBM/audio/" + name;
							FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
									new File(request.getSession().getServletContext().getRealPath("/") + audioPath));
							String mysqlUrl = uploadPrefixUrl + audioPath;
							paramsVO.setAudioUrl(mysqlUrl);//音频url
							paramsVO.setVolume((byte)100);//音量

							String platformId = model.getDest().getEbrID();
							String areaCode = platformId.substring(1, 13);
							String resourceTypeCode = platformId.substring(13, 17);
							String resourceTypeOrderCode = platformId.substring(17, 19);
							String platformResourceCode = resourceTypeCode + areaCode + resourceTypeOrderCode;
							paramsVO.setTermialDevice(platformId.substring(21,23));//控制设备
							
							//1.广播类型  应急4 
							paramsVO.setEBM_class((byte)4);
							
							int broadcastId  = thirdBroadcastDataService.insertProvincialEBM(paramsVO);
							paramsVO.setfId(broadcastId);
						};
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
			
			//获取所有的设备(正在广播,在线) (0,1)
			List<Integer> deviceIds = deviceInfoService.getAllDevices();
			//遍历,插入到b_broadcast_device
			if(deviceIds.size() > 0){
				for (Integer deviceId : deviceIds) {
					BBroadcastDevice broadcastDevice = new BBroadcastDevice();
					broadcastDevice.setfBroadcastId(paramsVO.getfId());
					broadcastDevice.setfDeviceId(deviceId);
					broadcastDevice.setfIsTimingBroadcast(false);
					broadcastDevice.setfBroadcastSendTime(new Date());
					broadcastDeviceService.insert(broadcastDevice);
				}
			}
			
            //播控服务器 音频播放
            BroadcastResult result = dispatchHttpclientService.sendBroadcast(dispatchServerTomcatPort,
            		"25", BroadcastTypeEnum.emergency.getCode(), paramsVO.getfId());
                
                return result;
			} catch (Exception e) {
				logger.error(e.getMessage() + e);
			}

		return BroadcastResult.ok();
	}
}
