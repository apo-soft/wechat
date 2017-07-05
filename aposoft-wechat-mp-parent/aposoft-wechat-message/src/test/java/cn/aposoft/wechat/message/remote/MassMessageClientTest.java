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
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.remote.Filter;
import cn.aposoft.wechat.mp.message.remote.MassMessageClient;
import cn.aposoft.wechat.mp.message.remote.MediaIdHolder;
import cn.aposoft.wechat.mp.message.remote.MessageResp;

/**
 * 群发消息客户端
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClientTest {
	static MassMessageClient client = new MassMessageClient();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
		client.close();
	}

	/**
	 * TODO 功能需要验证 2017/6/8 {"errcode":45028,"errmsg":"has no masssend quota
	 * hint: [x.zOnA0057ge21]"}
	 * <p>
	 * 2017/5/23 {"errcode":45028,"errmsg":"has no masssend quota hint:
	 * [rKd_Da0056ge21]"}
	 * 2017/7/4
	 * {"errcode":45028,"errmsg":"has no masssend quota hint: [BH6ysA0343ge21]"}
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
//	@Ignore
	@Test
	public void testSendNews() throws RemoteException, AccessTokenException {
		Filter filter = new Filter();
		filter.setIs_to_all(false);
		filter.setTag_id(100);
		MediaIdHolder media = new MediaIdHolder("ytupwLlPngh5XdmfFQ_eAslFs6ZDF8KifwWKog2eQU2VXAyMGg5uEF-Ticv5hi_4");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		System.out.println(JSON.toJSONString(
				client.sendMpnews(accessTokenService.getAccessToken().getAccess_token(), filter, media, configs)));
	}

	/**
	 * {"errcode":0,"errmsg":"send job submission
	 * success","msg_data_id":2247483663,"msgid":3147483655}
	 * <p>
	 * {"errcode":0,"errmsg":"send job submission
	 * success","msg_data_id":2247483671,"msgid":3147483656}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testSendOpenIdMpews() throws RemoteException, AccessTokenException {

		MediaIdHolder media = new MediaIdHolder("qN2VrGbthtk9pCbC5zu1gmVq85MCIDBqRUHxNk3S5FACOJTNzPvJZLUGKuUimxTT");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		configs.put("clientmsgid", "100001");
		System.out.println(JSON.toJSONString(client.sendMpnews(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("ojqOLxLh0480oz5gqHqLgzRgCLHM", "ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"), media, configs)));
	}

	// {"errcode":0,"errmsg":"send job submission success","msgid":1000000005}
	// content-test-for all special not exists
	@Ignore
	@Test
	public void testSendText() throws RemoteException, AccessTokenException {
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
	// {"msg_id":"3147483655","msg_status":"SEND_SUCCESS"}
	// <p>
	// {"msg_id":"3147483656","msg_status":"SEND_SUCCESS"}
	@Ignore
	@Test
	public void testGetMessageStatus() throws RemoteException, AccessTokenException {
		System.out.println(JSON.toJSONString(
				client.getMessageStatus(accessTokenService.getAccessToken().getAccess_token(), "3147483656")));
	}

	@Ignore
	@Test
	public void testSendImage() throws RemoteException, AccessTokenException {

		MediaIdHolder media = new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		configs.put("clientmsgid", "100001");
		System.out.println(JSON.toJSONString(client.sendImage(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("ojqOLxLh0480oz5gqHqLgzRgCLHM", "ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"), media, configs)));
	}

	@Ignore
	@Test
	public void testSendImageWithStatus() throws RemoteException, AccessTokenException {

		MediaIdHolder media = new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v");
		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		MessageResp resp = client.sendImage(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("ojqOLxLh0480oz5gqHqLgzRgCLHM", "ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"), media, configs);
		System.out.println(JSON.toJSONString(client.getMessageStatus(
				accessTokenService.getAccessToken().getAccess_token(), String.valueOf(resp.getMsgid()))));
	}

	/**
	 * 
	 * {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteMassMessage() throws RemoteException, AccessTokenException {

		Map<String, Object> configs = new HashMap<>();
		configs.put("send_ignore_reprint", 1);
		WechatResp resp = client.deleteMassMessage(accessTokenService.getAccessToken().getAccess_token(), "3147483655");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testPreview() throws RemoteException, AccessTokenException {

		WechatResp resp = client.preview(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", MsgType.image,
				new MediaIdHolder("RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v"));
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testPreviewText() throws RemoteException, AccessTokenException {

		WechatResp resp = client.preview(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", "发送公众号测试服务文本");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"msgtype":"mpnews","touser":"ojqOLxLh0480oz5gqHqLgzRgCLHM","mpnews":{"media_id":"tFGFFKYObPDMN89ePA09nfX1gJf8Tosq-7YTab5bD6vYe3Poq1e_pQQW0T-MRV8B"}}
	 * <p>
	 * {"errcode":0,"errmsg":"preview success"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
//	@Ignore
	@Test
	public void testPreviewNews() throws RemoteException, AccessTokenException {
		MediaIdHolder media = new MediaIdHolder("ytupwLlPngh5XdmfFQ_eAslFs6ZDF8KifwWKog2eQU2VXAyMGg5uEF-Ticv5hi_4");
		WechatResp resp = client.preview(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", MsgType.mpnews, media);
		System.out.println(JSON.toJSONString(resp));
	}

}
