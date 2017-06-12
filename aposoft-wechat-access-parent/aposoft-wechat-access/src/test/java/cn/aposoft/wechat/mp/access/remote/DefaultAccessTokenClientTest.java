/**
 * 
 */
package cn.aposoft.wechat.mp.access.remote;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AddressConfigFactory;
import cn.aposoft.wechat.access.DemoAccountConfigFactory;
import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.access.remote.AccessTokenResp;
import cn.aposoft.wechat.access.remote.DefaultAccessTokenClient;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * 默认AccessTokenClient 访问测试类
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DefaultAccessTokenClientTest {
	@Ignore
	@Test
	public void testGetMpAccessToken() throws RemoteException, IOException {
		AddressConfig mpconfig = AddressConfigFactory.getMpAddressConfig();
		try (AccessTokenClient client = new DefaultAccessTokenClient(mpconfig);) {
			AccountConfig accountConfig = new DemoAccountConfigFactory().getAccountConfig();
			AccessTokenResp accessToken = client.getAccessToken(accountConfig);
			Assert.assertNotNull(accessToken);
		}
	}
}
