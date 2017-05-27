/**
 *   Copyright  :  www.aposoft.cn
 */
package org.aposoft.wechat.simple.site;

import java.nio.charset.StandardCharsets;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;

/**
 * @author Jann Liu
 * @date 2016年10月15日
 * 
 */
public class MessageServletTest {

	final String messagePath = "/wx/?signature=6ebde78a265df2559dc931d01521848b1a76f2e8&timestamp=1476523223&nonce=1467734216&openid=ojqOLxLh0480oz5gqHqLgzRgCLHM";
	final String prefix = "http://localhost";
	final String messageUrl = prefix + messagePath;

	final String messageContent = "<xml><ToUserName><![CDATA[gh_0f504b63df22]]></ToUserName>"
			+ "<FromUserName><![CDATA[ojqOLxLh0480oz5gqHqLgzRgCLHM]]></FromUserName>"
			+ "<CreateTime>1476523223</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
			+ "<Content><![CDATA[我]]></Content>" + "<MsgId>6341618955014860869</MsgId>" + "</xml>";

	private static CloseableHttpClient httpClient;

	@BeforeClass
	public static void init() {
		httpClient = HttpClientFactory.createDefault();
	}

	@AfterClass
	public static void destroy() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 接收，自动回复
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testReceiveAndAutoReply() throws RemoteException {
		Assume.assumeTrue(false);
		HttpPost httpPost = new HttpPost(messageUrl);
		StringEntity entity = new StringEntity(messageContent, ContentType.create("text/xml", StandardCharsets.UTF_8));
		httpPost.setEntity(entity);

		String respMessage = HttpClient.execute(httpPost, httpClient);
		System.out.println(respMessage);
	}

}
