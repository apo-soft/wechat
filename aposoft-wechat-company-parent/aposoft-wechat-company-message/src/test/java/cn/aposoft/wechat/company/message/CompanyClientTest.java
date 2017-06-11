/**
 * 
 */
package cn.aposoft.wechat.company.message;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenClientFactory;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.company.message.impl.AposoftCompanyMessageService;

/**
 * 企业客户端测试
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class CompanyClientTest {

	static final CompanyMessageService service = new AposoftCompanyMessageService();
	static final AccessTokenClient accessTokenClient = AccessTokenClientFactory.getCompanyAccessTokenClient();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		HttpClient.setLogEnabled(true);
		accessTokenService = AccessTokenServiceFactory.getCompanyAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenClient.close();
	}

	@Ignore
	@Test
	public void testSendText() throws RemoteException, AccessTokenException {
		RequestConfig config = new RequestConfig();
		config.setAgentid(1);
		config.setTouser(new String[] { "liujian" });
		config.setSafe(1);

		service.sendText(accessTokenService.getAccessToken().getAccess_token(), config, "发送测试报警消息,请忽略！");
	}
}
