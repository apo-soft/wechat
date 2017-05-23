/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.MediaEntity;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 * @author Jann Liu
 *
 */
public class MassMaterialClientTest {

	static MassMaterialClient client = new MassMaterialClient();
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		if (!HttpClient.isLogEnabled()) {
			HttpClient.setLogEnabled(true);
		}
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

	/**
	 * 测试群发消息上传缩略图
	 * {"type":"thumb","thumb_media_id":"RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v","created_at":1495512213}
	 * {"type":"thumb","thumb_media_id":"-qsg3xloIj1GMMRGe8BUqGg4KD3VSNCl0af3WVGKHSi4laY8sn5IwCKqqJWptxE4","created_at":1495512213}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testUploadThumb() throws RemoteException, FileNotFoundException, IOException {
		MediaEntity media = new MediaEntity();
		media.setFilename("diamond-404.jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setEntity(data);
		MediaResp resp = client.uploadNewsThumb(accessTokenService.getAccessToken().getAccess_token(), media);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * 添加临时图文素材，用于群体回复
	 * {"created_at":1495515034,"media_id":"HjFqB7Fxo1AlFAR5YZ10qHuqHsem6Pq7MUnCArRcltNep3T0L0VJH499TJw01ASe","type":"news"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testUploadNewsMedia() throws RemoteException, FileNotFoundException, IOException {
		NewsItem news = new NewsItem();
		news.setAuthor("Jann");
		news.setDigest("测试新闻 摘要-2");
		news.setContent("测试新闻内容,这是一件重大的测试新闻.2017-5-23 12:50");
		news.setShow_cover_pic(1);
		news.setTitle("重磅新闻-2");
		news.setThumb_media_id("-qsg3xloIj1GMMRGe8BUqGg4KD3VSNCl0af3WVGKHSi4laY8sn5IwCKqqJWptxE4");
		news.setContent_source_url("https://www.aposoft.cn");
		MediaResp resp = client.uploadNews(accessTokenService.getAccessToken().getAccess_token(), news);
		System.out.println(JSON.toJSONString(resp));
	}

}
