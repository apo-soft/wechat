/**
 * 
 */
package cn.aposoft.wechat.message.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.mp.message.remote.IndustryConfigClient;

/**
 * @author Jann Liu
 *
 */
public class AposoftIndustryConfigServiceTest {
	static IndustryConfigClient client;
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		client = new IndustryConfigClient();
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		client.close();
		accessTokenService.close();

	}

	@Test
	public void testSetIndustry() throws RemoteException {
		client.setIndustryConfig(accessTokenService.getAccessToken().getAccess_token(), "8", "2");
	}

	@Test
	public void testgetIndustry() throws RemoteException {
		System.out.println(client.getIndustry(accessTokenService.getAccessToken().getAccess_token()));
	}

}
