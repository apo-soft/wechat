/**
 * 
 */
package cn.aposoft.wechat.mp.account.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.wechat.RemoteException;

/**
 * 微信公众号账号管理
 * 
 * @author Jann Liu
 *
 */
public class AccountClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	// 请求二维码参数
	static final String QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * *
	 * 
	 * <pre>
	 *  <xml><ToUserName><![CDATA[gh_0f504b63df22]]></ToUserName>
	<FromUserName><![CDATA[ojqOLxLh0480oz5gqHqLgzRgCLHM]]></FromUserName>
	<CreateTime>1495609091</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[SCAN]]></Event>
	<EventKey><![CDATA[2]]></EventKey>
	<Ticket><![CDATA[gQEl8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyakdHT0ZZZXplYjQxMDRNQmhwMWYAAgTYLiVZAwQsAQAA]]></Ticket>
	</xml>
	 * </pre>
	 * 
	 * @param accessToken
	 *            {@link AccessToken}
	 * @param sceneId
	 *            场景ID
	 * @return
	 * @throws RemoteException
	 */
	public QrcodeResp getSceneAccountQrcode(final String accessToken, final int sceneId) throws RemoteException {
		int finalSceneId = sceneId >= 1 && sceneId <= 100000 ? sceneId : 100000;
		JSONObject jobj = new JSONObject().fluentPut("action_name", "QR_SCENE")//
				.fluentPut("action_info", //
						new JSONObject().fluentPut("scene", //
								new JSONObject().fluentPut("scene_id", finalSceneId)));
		return HttpClient.execute(HttpClient.jsonPost(getQrcodeUrl(accessToken), jobj), QrcodeResp.class, httpClient);
	}

	/**
	 * 
	 * @param accessToken
	 *            {@link AccessToken}
	 * @param sceneId
	 *            场景ID
	 * @return
	 * @throws RemoteException
	 */
	public QrcodeResp getSceneAccountQrcode(final String accessToken, final int sceneId, final Integer expires)
			throws RemoteException {
		int expire_seconds = expires == null ? 3600 : Math.min(2592000, expires);
		int finalSceneId = sceneId >= 1 && sceneId <= 100000 ? sceneId : 100000;
		JSONObject jobj = new JSONObject().fluentPut("expire_seconds", expire_seconds)
				.fluentPut("action_name", "QR_SCENE")//
				.fluentPut("action_info", //
						new JSONObject().fluentPut("scene", //
								new JSONObject().fluentPut("scene_id", finalSceneId)));
		return HttpClient.execute(HttpClient.jsonPost(getQrcodeUrl(accessToken), jobj), QrcodeResp.class, httpClient);
	}

	/**
	 * 生成二维码
	 * 
	 * <pre>
	 * <xml>
	 * 		<ToUserName><![CDATA[gh_0f504b63df22]]></ToUserName>
			<FromUserName><![CDATA[ojqOLxLh0480oz5gqHqLgzRgCLHM]]></FromUserName>
			<CreateTime>1495609319</CreateTime>
			<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[SCAN]]></Event>
			<EventKey><![CDATA[3]]></EventKey>
			<Ticket><![CDATA[gQFC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyc2d0cEZsZXplYjQxMDAwMHcwM18AAgTGLyVZAwQAAAAA]]></Ticket>
		</xml>
	 * </pre>
	 * 
	 * @param accessToken
	 *            {@link AccessToken}
	 * @param sceneId
	 *            场景ID
	 * @return {"ticket":"gQFC8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyc2d0cEZsZXplYjQxMDAwMHcwM18AAgTGLyVZAwQAAAAA","url":"http://weixin.qq.com/q/02sgtpFlezeb410000w03_"}
	 * 
	 * @throws RemoteException
	 */
	public QrcodeResp getAccountQrcode(final String accessToken, final int sceneId) throws RemoteException {
		int finalSceneId = sceneId >= 1 && sceneId <= 100000 ? sceneId : 100000;
		JSONObject jobj = new JSONObject().fluentPut("action_name", "QR_LIMIT_SCENE")//
				.fluentPut("action_info", //
						new JSONObject().fluentPut("scene", //
								new JSONObject().fluentPut("scene_id", finalSceneId)));
		return HttpClient.execute(HttpClient.jsonPost(getQrcodeUrl(accessToken), jobj), QrcodeResp.class, httpClient);
	}

	/**
	 * <pre>
	 * <xml> 
		  <ToUserName><![CDATA[gh_0f504b63df22]]></ToUserName>
		  <FromUserName><![CDATA[ojqOLxLh0480oz5gqHqLgzRgCLHM]]></FromUserName>
		  <CreateTime>1495607904</CreateTime> 
		  <MsgType><![CDATA[event]]></MsgType>
		  <Event><![CDATA[SCAN]]></Event> 
		  <EventKey><![CDATA[test-003]]></EventKey>
		  <Ticket><![CDATA[gQEN8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydl84c0ZtZXplYjQxMDAwMHcwN2kAAgQvKiVZAwQAAAAA]]></Ticket>
	 * </xml>
	 * 
	 * </pre>
	 * 
	 * @param accessToken
	 *            {@link AccessToken}
	 * @param sceneStr
	 *            场景ID
	 * @return {"ticket":"gQEN8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydl84c0ZtZXplYjQxMDAwMHcwN2kAAgQvKiVZAwQAAAAA",
	 *         "url":"http://weixin.qq.com/q/02v_8sFmezeb410000w07i"}
	 * @throws RemoteException
	 */
	public QrcodeResp getAccountQrcodeStr(final String accessToken, final String sceneStr) throws RemoteException {
		JSONObject jobj = new JSONObject().fluentPut("action_name", "QR_LIMIT_STR_SCENE")//
				.fluentPut("action_info", //
						new JSONObject().fluentPut("scene", //
								new JSONObject().fluentPut("scene_str", sceneStr)));
		return HttpClient.execute(HttpClient.jsonPost(getQrcodeUrl(accessToken), jobj), QrcodeResp.class, httpClient);
	}

	private String getQrcodeUrl(String accessToken) {
		return QR_CODE_URL + accessToken;
	}
}
