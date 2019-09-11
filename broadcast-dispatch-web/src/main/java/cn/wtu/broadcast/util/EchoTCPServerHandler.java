package cn.wtu.broadcast.util;

import java.util.Iterator;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

@Component
public class EchoTCPServerHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(EchoTCPServerHandler.class);

	public static EchoTCPServerHandler echoTCPServerHandler;

	/**
	 * 1.正常注入[记得主类也需要使用@Component注解]
	 */
	@Autowired
	private BDeviceInfoService bdeviceInfoService;

	/**
	 * 2.初始化构造方法一定要有
	 */
	public EchoTCPServerHandler() {
	}

	/**
	 * 3.容器初始化的时候进行执行-这里是重点
	 */
	@PostConstruct
	public void init() {
		echoTCPServerHandler = this;
		echoTCPServerHandler.bdeviceInfoService = this.bdeviceInfoService;
	}

	/*
	 * channelAction channel 通道 action 活跃的 当客户端主动链接服务端的链接后，这个通道就是活跃的了
	 * 也就是客户端与服务端建立了通信通道并且可以传输数据
	 *
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " 通道已激活！");
	}

	/*
	 * channelInactive channel 通道 Inactive 不活跃的 当客户端主动断开服务端的链接后，这个通道就是不活跃的
	 * 也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
	 *
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " 通道已断开！");
		ctx.close();
		removeDisconnectCtx(ctx);
	}

	/**
	 * 功能：读取服务器发送过来的信息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (null == ctx || msg == Unpooled.EMPTY_BUFFER) {
			ReferenceCountUtil.release(msg);
			return;
		}
		// 第一种：接收字符串时的处理
		ByteBuf buf = (ByteBuf) msg;
		try {
			byte[] receiveMsgBytes = new byte[buf.readableBytes()];
			buf.readBytes(receiveMsgBytes);
			String answer = UDPUtil.byteToHex(receiveMsgBytes);
			logger.info("服务器收到客服端数据:" + answer);
			// 管理web平台心跳处理
			if ("8888".equals(answer.substring(0, 4))) {
				ctx.channel().writeAndFlush(UDPUtil.hexToByte("8888"));
				// 设备交互相关数据处理
			} else if (answer.length() >= 42) {
				String resourceCode = answer.substring(24, 42);
				ChannelHandlerContext channelHandlerContext = SendIPUtils.ctxMap.get(resourceCode);
				// 第一次心跳进来或者设备心跳断开后重连后要更新map里面的相关值
				if (channelHandlerContext == null
						|| (channelHandlerContext != null && channelHandlerContext.isRemoved())) {
					// 保存设备上下文通道(供页面播放等功能使用)
					SendIPUtils.ctxMap.put(resourceCode, ctx);
					SendIPUtils.answerMap.put(resourceCode, answer);
				}
				Channel channel = SendIPUtils.ctxMap.get(resourceCode).channel();
				// 业务数据类型
				String serviceType = answer.substring(46, 48);
				// 若为心跳，则回复一般应答
				if ("10".equals(serviceType)) {
					SendIPUtils.heartControl(channel, answer);
					String deviceState = answer.substring(52, 54);
					String key = resourceCode;
					// 若缓存中没有该设备状态或者设备状态与缓存中不一样，则更新设备状态
					if (!SendIPUtils.deviceStateMap.containsKey(key) || SendIPUtils.deviceStateMap.get(key) == null
							|| (SendIPUtils.deviceStateMap.get(key) != null
									&& !deviceState.equals(SendIPUtils.deviceStateMap.get(key)))) {
						DeviceStateEnum updateState = null;
						if ("01".equals(deviceState)) {
							updateState = DeviceStateEnum.online;
						} else if ("02".equals(deviceState)) {
							updateState = DeviceStateEnum.broadcasting;
						} else if ("03".equals(deviceState)) {
							updateState = DeviceStateEnum.malfunction;
						}
						// 更新该设备状态
						Boolean updateResult = echoTCPServerHandler.bdeviceInfoService.updateDeviceStateBySourceCode(
								key, Byte.valueOf(String.valueOf(updateState.getCode())));
						logger.info("设备{" + key + "}更新为" + updateState.name() + "处理结果：{" + updateResult + "}");
						SendIPUtils.deviceStateMap.put(key, deviceState);
					}
				}
				// "30" 身份认证请求标识 "01"表示客户端请求标志
				if ("30".equals(serviceType) && answer.substring(16, 18).equals("01")) {
					SendIPUtils.authenticationControl(channel, answer);
				}
				// ip话筒
				if (("49").equals(answer.substring(0, 2))) {
					SendIPUtils.ipMikeAnswer(channel);
					// 封装ipvo并发送开播停播指令
					SendIPUtils.sendIpMikeInfo(answer);
				}
			}
		} finally {
			ReferenceCountUtil.release(buf);
		}

	}

	/**
	 * 功能：读取完毕客户端发送过来的数据之后的操作
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// 第一种方法：写一个空的buf，并刷新写出区域。完成后关闭sock channel连接。
		// ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
		logger.info("服务端接收数据完毕..");
	}

	/**
	 * 可以根据事件类型进行相应的处理 服务端重点关注读超时
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			switch (idleStateEvent.state()) {
			case READER_IDLE:
				ctx.close();
				removeDisconnectCtx(ctx);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 功能：服务端发生异常的操作
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		logger.error("服务端发生异常:" + cause.getMessage() + cause);
		removeDisconnectCtx(ctx);
	}

	private void removeDisconnectCtx(ChannelHandlerContext ctx) {
		Iterator<String> keyIterator = SendIPUtils.ctxMap.keySet().iterator();
		synchronized (keyIterator) {
			while (keyIterator.hasNext()) {
				String key = keyIterator.next();
				ChannelHandlerContext channelHandlerContext = SendIPUtils.ctxMap.get(key);
				// 如果播放列表中对应广播数据已经没有了，证明已经播放完成了，开始执行停播指令
				if (channelHandlerContext.equals(ctx)) {
					keyIterator.remove();
				}
				// 更新该设备为离线状态
				Boolean updateResult = echoTCPServerHandler.bdeviceInfoService.updateDeviceStateBySourceCode(key,
						Byte.valueOf(String.valueOf(DeviceStateEnum.offline.getCode())));
				SendIPUtils.deviceStateMap.remove(key);
				logger.info("设备{}更新为离线处理结果：{}", key, updateResult);
			}
		}
	}
}
