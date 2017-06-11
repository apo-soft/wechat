/**
 * 
 */
package cn.aposoft.wechat.company.message;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenClientFactory;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.company.common.WechatCompanyConfig;
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
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		WechatCompanyConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream("../config/gome-ops-key.txt"), StandardCharsets.UTF_8),
				WechatCompanyConfig.class);
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, config, null);
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
