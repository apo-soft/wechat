/**
 * 
 */
package cn.aposoft.wechat.company.auth;

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
import cn.aposoft.wechat.company.auth.impl.AposoftAccountExchangeService;
import cn.aposoft.wechat.config.CompanyAccountConfig;
import cn.aposoft.wechat.mp.config.testaccount.WechatAccountConfigFactory;

/**
 * 账号转换接口测试
 * 
 * @author Jann Liu
 *
 */
public class AccountExchangeServiceTest {

	static final AccountExchangeService service = new AposoftAccountExchangeService();
	static final AccessTokenClient accessTokenClient = AccessTokenClientFactory.getCompanyAccessTokenClient();
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		CompanyAccountConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream("../config/gome-ops-key.txt"), StandardCharsets.UTF_8),
				CompanyAccountConfig.class);
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, config, WechatAccountConfigFactory.getRefreshConfig());
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenClient.close();
	}

	/**
	 * {"appid":"wxcde648bcedd955c2","errcode":0,"errmsg":"ok","openid":"owRU_v19INXMUA_rw_jQRBdRbKq8"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testExchangeAccount() throws RemoteException, AccessTokenException {
		AccountExchangeResp resp = service.convertToOpenId(accessTokenService.getAccessToken().getAccess_token(),
				"liujian", 1);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok","openid":"oCz0RxFBSvXq0-D5_eLRJ7pBLt8c"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testExchangeAccountCorpId() throws RemoteException, AccessTokenException {
		AccountExchangeResp resp = service.convertToOpenId(accessTokenService.getAccessToken().getAccess_token(),
				"liujian");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * "oCz0RxFBSvXq0-D5_eLRJ7pBLt8c"
	 * {"errcode":0,"errmsg":"ok","userid":"liujian"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testExchangeAccountUserId() throws RemoteException, AccessTokenException {
		AccountExchangeResp resp = service.convertToUserId(accessTokenService.getAccessToken().getAccess_token(),
				"oCz0RxFBSvXq0-D5_eLRJ7pBLt8c");
		System.out.println(JSON.toJSONString(resp));
	}
}
