/**
 * 
 */
package cn.aposoft.wechat.mp.csa.impl;

import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AposoftMpAccessTokenClient;
import cn.aposoft.wechat.mp.config.testaccount.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.csa.AgentAccount;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 客服管理服务测试
 * 
 * @author Jann Liu
 *
 */
public class AposoftCustomServiceAgentServiceTest {

	static AposoftCustomServiceAgentService csaService;

	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		csaService = new AposoftCustomServiceAgentService();
		accessTokenClient = new AposoftMpAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, WechatMpConfigFactory.getConfig());
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		csaService.close();
	}

	@Test
	public void testListKf() throws RemoteException {

		List<AgentAccount> list = csaService.getAgentList(accessTokenService.getAccessToken().getAccess_token());

		System.out.println(JSON.toJSONString(list));
	}

	@Ignore
	@Test
	public void testAddKf() throws RemoteException {
		AgentAccount account = new AgentAccount();
		account.setAccount("kf1@pipi668的接口测试号");
		account.setNickname("客服小美");
		account.setPassword("kf1@pipi668");
		WechatResp resp = csaService.add(accessTokenService.getAccessToken().getAccess_token(), account);
		System.out.println(JSON.toJSONString(resp));
		account = new AgentAccount();
		account.setAccount("kf2@pipi668的接口测试号");
		account.setNickname("客服雨燕");
		account.setPassword("kf2@pipi668");
		WechatResp resp2 = csaService.add(accessTokenService.getAccessToken().getAccess_token(), account);
		System.out.println(JSON.toJSONString(resp2));

	}

	@Ignore
	@Test
	public void testUpdateKf() throws RemoteException {
		AgentAccount account = new AgentAccount();
		account.setAccount("kf1@pipi668的接口测试号");
		account.setNickname("客服尤娜");
		account.setPassword("kf1@pipi668");
		WechatResp resp = csaService.update(accessTokenService.getAccessToken().getAccess_token(), account);

		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testDeleteKf() throws RemoteException {
		AgentAccount account = new AgentAccount();
		account.setAccount("kf1@pipi668的接口测试号");
		account.setNickname("客服尤娜");
		account.setPassword("kf1@pipi668");
		WechatResp resp = csaService.delete(accessTokenService.getAccessToken().getAccess_token(), account);

		System.out.println(JSON.toJSONString(resp));
	}
}
