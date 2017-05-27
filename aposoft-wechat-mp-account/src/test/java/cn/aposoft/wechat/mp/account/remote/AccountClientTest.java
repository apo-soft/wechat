/**
 * 
 */
package cn.aposoft.wechat.mp.account.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AposoftMpAccessTokenClient;
import cn.aposoft.wechat.mp.config.testaccount.WechatMpConfigFactory;

/**
 * 账户管理测试
 * 
 * @author Jann Liu
 *
 */
public class AccountClientTest {
	static AccountClient client = new AccountClient();
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		if (!HttpClient.isLogEnabled()) {
			HttpClient.setLogEnabled(true);
		}
		accessTokenClient = new AposoftMpAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, WechatMpConfigFactory.getConfig());
		System.out.println(JSON.toJSONString(accessTokenService.getAccessToken()));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		client.close();
	}

	/**
	 * {"expire_seconds":300,"ticket":"gQEl8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyakdHT0ZZZXplYjQxMDRNQmhwMWYAAgTYLiVZAwQsAQAA","url":"http://weixin.qq.com/q/02jGGOFYezeb4104MBhp1f"}
	 * 
	 * 
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testGetSceneAccountQrcode() throws RemoteException {
		System.out.println(JSON.toJSONString(
				client.getSceneAccountQrcode(accessTokenService.getAccessToken().getAccess_token(), 2, 300)));
	}

	/**
	 * {"ticket":"gQFC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyc2d0cEZsZXplYjQxMDAwMHcwM18AAgTGLyVZAwQAAAAA","url":"http://weixin.qq.com/q/02sgtpFlezeb410000w03_"}
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testGetAccountQrcode() throws RemoteException {
		System.out.println(
				JSON.toJSONString(client.getAccountQrcode(accessTokenService.getAccessToken().getAccess_token(), 3)));
	}

	/**
	 * {"ticket":"gQEN8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydl84c0ZtZXplYjQxMDAwMHcwN2kAAgQvKiVZAwQAAAAA",
	 * "url":"http://weixin.qq.com/q/02v_8sFmezeb410000w07i"}
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testGetAccountQrcodeStr() throws RemoteException {
		System.out.println(JSON.toJSONString(
				client.getAccountQrcodeStr(accessTokenService.getAccessToken().getAccess_token(), "test-003")));
	}
}
