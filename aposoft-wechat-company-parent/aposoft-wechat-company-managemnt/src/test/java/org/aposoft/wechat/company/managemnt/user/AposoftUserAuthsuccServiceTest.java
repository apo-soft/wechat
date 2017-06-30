/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import java.io.IOException;

import org.aposoft.wechat.company.managemnt.user.impl.AposoftUserAuthsuccService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;

/**
 * @author Jann Liu
 *
 */
public class AposoftUserAuthsuccServiceTest {
	static final AposoftUserAuthsuccService service = new AposoftUserAuthsuccService();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		HttpClient.setLogEnabled(true);
		accessTokenService = AccessTokenServiceFactory.getCompanyAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenService.close();
	}

	/**
	 * HTTP 404 {"errcode":50004,"errmsg":"user status invalid"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetAgentList() throws RemoteException, AccessTokenException {
		WechatResp resp = service.authsucc(accessTokenService.getAccessToken().getAccess_token(), "liujian");
		System.out.println(JSON.toJSONString(resp));
	}
}
