/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.IOException;
import java.util.Arrays;
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
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.remote.Filter;
import cn.aposoft.wechat.mp.message.remote.MassMessageClient;
import cn.aposoft.wechat.mp.message.remote.MediaIdHolder;
import cn.aposoft.wechat.mp.message.remote.MessageResp;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 批量发送客户端测试
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClientTest {
	static MassMessageClient client = new MassMessageClient();
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
	public void testSendNews() throws RemoteException {
		Filter filter = new Filter();
		filter.setIs_to_all(false);
		filter.setTag_id(2);
		MediaIdHolder media = new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		System.out.println(JSON.toJSONString(
				client.sendMpnews(accessTokenService.getAccessToken().getAccess_token(), filter, media, configs)));
	}

	// {"errcode":0,"errmsg":"send job submission success","msgid":1000000004}
	// content-test-for all special

	// {"errcode":0,"errmsg":"send job submission success","msgid":1000000005}
	// content-test-for all special not exists
	@Test
	public void testSendText() throws RemoteException {
		Filter filter = new Filter();
		filter.setIs_to_all(false);
		filter.setTag_id(100);

		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		System.out.println(JSON.toJSONString(client.sendText(accessTokenService.getAccessToken().getAccess_token(),
				filter, "content-test-for all special not exists", configs)));
	}
	//

	// 1000000000 {}
	// {"msg_id":"1000000001","msg_status":"SEND_SUCCESS"}
	// {"msg_id":"1000000002","msg_status":"SEND_SUCCESS"}
	// {"msg_id":"1000000003","msg_status":"SEND_SUCCESS"}
	// {"msg_id":"3147483654","msg_status":"SEND_SUCCESS"}

	@Test
	public void testGetMessageStatus() throws RemoteException {
		System.out.println(JSON.toJSONString(
				client.getMessageStatus(accessTokenService.getAccessToken().getAccess_token(), "3147483654")));
	}

	@Test
	public void testSendImage() throws RemoteException {

		MediaIdHolder media = new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		configs.put("clientmsgid", "100001");
		System.out.println(JSON.toJSONString(client.sendImage(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("ojqOLxLh0480oz5gqHqLgzRgCLHM", "ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"), media, configs)));
	}

	@Test
	public void testSendImageWithStatus() throws RemoteException {

		MediaIdHolder media = new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		MessageResp resp = client.sendImage(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("ojqOLxLh0480oz5gqHqLgzRgCLHM", "ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"), media, configs);
		System.out.println(JSON.toJSONString(client.getMessageStatus(
				accessTokenService.getAccessToken().getAccess_token(), String.valueOf(resp.getMsgid()))));
	}

	@Test
	public void testDeleteMassMessage() throws RemoteException {

		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		WechatResp resp = client.deleteMassMessage(accessTokenService.getAccessToken().getAccess_token(), "3147483654");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testPreview() throws RemoteException {

		WechatResp resp = client.preview(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", MsgType.image,
				new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v"));
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testPreviewText() throws RemoteException {

		WechatResp resp = client.preview(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", "今天发布了美女的屏保，请欣赏！");
		System.out.println(JSON.toJSONString(resp));
	}
}
