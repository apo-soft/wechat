/**
 * 
 */
package cn.aposoft.wechat.mp.account.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.access.AccessTokenClient;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;

/**
 * 账户管理测试
 * 
 * @author Jann Liu
 *
 */
public class AccountClientTest {
	static AccountClient client = new AccountClient();
	static AccessTokenClient accessTokenClient;
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		if (!HttpClient.isLogEnabled()) {
			HttpClient.setLogEnabled(true);
		}
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
	}

	/**
	 * {"expire_seconds":300,"ticket":"gQEl8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyakdHT0ZZZXplYjQxMDRNQmhwMWYAAgTYLiVZAwQsAQAA","url":"http://weixin.qq.com/q/02jGGOFYezeb4104MBhp1f"}
	 * 
	 * 
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Test
	public void testGetSceneAccountQrcode() throws RemoteException, AccessTokenException {
		System.out.println(JSON.toJSONString(
				client.getSceneAccountQrcode(accessTokenService.getAccessToken().getAccess_token(), 2, 300)));
	}

	/**
	 * {"ticket":"gQFC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyc2d0cEZsZXplYjQxMDAwMHcwM18AAgTGLyVZAwQAAAAA","url":"http://weixin.qq.com/q/02sgtpFlezeb410000w03_"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Test
	public void testGetAccountQrcode() throws RemoteException, AccessTokenException {
		System.out.println(
				JSON.toJSONString(client.getAccountQrcode(accessTokenService.getAccessToken().getAccess_token(), 3)));
	}

	/**
	 * {"ticket":"gQEN8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydl84c0ZtZXplYjQxMDAwMHcwN2kAAgQvKiVZAwQAAAAA",
	 * "url":"http://weixin.qq.com/q/02v_8sFmezeb410000w07i"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Test
	public void testGetAccountQrcodeStr() throws RemoteException, AccessTokenException {
		System.out.println(JSON.toJSONString(
				client.getAccountQrcodeStr(accessTokenService.getAccessToken().getAccess_token(), "test-003")));
	}
}
