import cn.wtu.broadcast.openapi.api.TSStreamPackagedService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TSStreamSendTest {
	
	@Autowired
	private TSStreamPackagedService tsStreamPackagedService;
	
	@Test
	public void testTSStreamSend(){
		//byte[] data = tsStreamPackagedService.getEBITTsData(null);
		//UDPUtil.udpSend(data, "","");
	}
	
}
