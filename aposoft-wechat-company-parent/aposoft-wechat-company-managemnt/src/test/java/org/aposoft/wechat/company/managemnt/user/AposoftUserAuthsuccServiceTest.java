/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.aposoft.wechat.company.managemnt.user.impl.AposoftUserAuthsuccService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.common.CompanyAccessTokenClient;
import cn.aposoft.wechat.company.common.WechatCompanyAccessConfig;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * @author Jann Liu
 *
 */
public class AposoftUserAuthsuccServiceTest {
	static final AposoftUserAuthsuccService service = new AposoftUserAuthsuccService();
	static final CompanyAccessTokenClient accessTokenClient = new CompanyAccessTokenClient();
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		WechatCompanyAccessConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream("../config/gome-ops-key.txt"), StandardCharsets.UTF_8),
				WechatCompanyAccessConfig.class);
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, config);
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenClient.close();
	}

	/**
	 * {"errcode":50004,"errmsg":"user status invalid"}
	 * 
	 * @throws RemoteException
	 */
	// @Ignore
	@Test
	public void testGetAgentList() throws RemoteException {
		WechatResp resp = service.authsucc(accessTokenService.getAccessToken().getAccess_token(), "liujian");
		System.out.println(JSON.toJSONString(resp));
	}
}
