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

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.auth.impl.AposoftAccountExchangeService;
import cn.aposoft.wechat.company.common.CompanyAccessTokenClient;
import cn.aposoft.wechat.company.common.WechatCompanyAccessConfig;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;

/**
 * 账号转换接口测试
 * 
 * @author Jann Liu
 *
 */
public class AccountExchangeServiceTest {

	static final AccountExchangeService service = new AposoftAccountExchangeService();
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
	 * {"appid":"wxcde648bcedd955c2","errcode":0,"errmsg":"ok","openid":"owRU_v19INXMUA_rw_jQRBdRbKq8"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testExchangeAccount() throws RemoteException {
		AccountExchangeResp resp = service.convertToOpenId(accessTokenService.getAccessToken().getAccess_token(),
				"liujian", 1);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok","openid":"oCz0RxFBSvXq0-D5_eLRJ7pBLt8c"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testExchangeAccountCorpId() throws RemoteException {
		AccountExchangeResp resp = service.convertToOpenId(accessTokenService.getAccessToken().getAccess_token(),
				"liujian");
		System.out.println(JSON.toJSONString(resp));
	}
}
