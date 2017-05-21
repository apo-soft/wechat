/**
 * 
 */
package org.aposoft.wechat.message.remote;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.message.TemplateMessage;
import cn.aposoft.wechat.mp.message.TemplateMessage.TemplateParam;
import cn.aposoft.wechat.mp.message.remote.MessageResp;
import cn.aposoft.wechat.mp.message.remote.TemplateMessageClient;

/**
 * @author Jann Liu
 *
 */
public class TemplateMessageClientTest {
	static TemplateMessageClient client = new TemplateMessageClient();
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		client.close();
	}

	@Test
	public void testgetTemplateList() throws RemoteException {
		System.out.println(client.getTemplateList(accessToken.getAccess_token()));
	}

	@Test
	public void testSendTemplateMessage() throws RemoteException {
		TemplateMessage msg = new TemplateMessage();
		msg.setTouser("ojqOLxLh0480oz5gqHqLgzRgCLHM");
		msg.setTemplate_id("zw9lgptQReQQpJoofaPucstJSFi7bUmJ_26I1rBAgkk");
		Map<String, TemplateParam> data = new HashMap<>();
		data.put("first", new TemplateParam("系统运行报警通知", "#173177"));
		data.put("business", new TemplateParam("美借", "#173177"));
		data.put("system", new TemplateParam("JIE-API", "#173177"));
		data.put("ip", new TemplateParam("10.143.92.93", "#173177"));
		data.put("performance", new TemplateParam("调用闪银接口连续报错.", "#173177"));
		data.put("time", new TemplateParam(new Date().toString(), "#173177"));
		data.put("remark", new TemplateParam("请联系相关人员处理！", "#FF0000"));
		// msg.setUrl(null);
		msg.setData(data);
		MessageResp resp = client.sendTemplateMessage(accessTokenService.getAccessToken().getAccess_token(), msg);
		System.out.println(JSON.toJSONString(resp));
	}
}
