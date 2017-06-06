/**
 * 
 */
package cn.aposoft.wechat.company.access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.common.CompanyAccessTokenClient;
import cn.aposoft.wechat.company.common.WechatCompanyConfig;
import cn.aposoft.wechat.mp.access.remote.AccessTokenResp;

/**
 * 测试读取企业号access_token
 * 
 * @author Jann Liu
 *
 */
public class CompanyAccessTokenClientTest {
	/**
	 * 
	 * @throws RemoteException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void testGetCompanyAccessToken() throws RemoteException, FileNotFoundException, IOException {
		try (CompanyAccessTokenClient client = new CompanyAccessTokenClient();) {
			WechatCompanyConfig companyConfig = getTestCompanyConfig();
			AccessTokenResp accessToken = client.getAccessToken(companyConfig.toAccessTokenConfig());
			System.out.println(JSON.toJSONString(accessToken));
		}
	}

	//
	private static WechatCompanyConfig getTestCompanyConfig() throws FileNotFoundException, IOException {
		WechatCompanyConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream("../../config/gome-ops-key.txt"), StandardCharsets.UTF_8),
				WechatCompanyConfig.class);
		return config;
	}
}
