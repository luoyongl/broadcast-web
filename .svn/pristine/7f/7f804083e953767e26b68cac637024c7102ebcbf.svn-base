package cn.wtu.broadcast.openapi.provider;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.TCPUtil2;
import cn.wtu.broadcast.openapi.api.IPStreamPackagedService;
import cn.wtu.broadcast.parent.vo.IpVO;

@Service("iPStreamPackagedService")
public class IPStreamPackagedServiceImpl implements IPStreamPackagedService {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(IPStreamPackagedServiceImpl.class);
	
	@Override
	public void sendIPCommand(String serviceType,IpVO ipvo) {
		try {
			TCPUtil2.send(serviceType, ipvo);
			// 开线程发音频流

			/*new Thread(() -> {
				try {
					FfmpegUtil.play2("123", "123");
					//FfmpegUtil.play();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();*/
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
