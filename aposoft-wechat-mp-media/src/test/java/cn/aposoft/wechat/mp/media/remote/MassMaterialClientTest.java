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
import cn.aposoft.wechat.mp.access.impl.BasicAccessConfigFactory;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AposoftMpAccessTokenClient;
import cn.aposoft.wechat.mp.config.testaccount.WechatMpConfigFactory;
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
		accessTokenClient = new AposoftMpAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient,
				BasicAccessConfigFactory.getInstance(WechatMpConfigFactory.getConfig()).getAccessConfig());
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
	 * 测试群发消息上传缩略图
	 * {"type":"thumb","thumb_media_id":"iEhKvMtP5yXO8HVayUXqHr4wvGYWXKozjeyPKqV3Ar0kPxW-XUsj_7CP6cwtQ_s7","created_at":1495548585}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testUploadThumb1() throws RemoteException, FileNotFoundException, IOException {
		MediaEntity media = new MediaEntity();
		media.setFilename("art_temptation (16).jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(
				new FileInputStream("F:/LiuJian/Documents/Pictures/beauties/euro america/art_temptation (16).jpg"));
		media.setEntity(data);
		MediaResp resp = client.uploadNewsThumb(accessTokenService.getAccessToken().getAccess_token(), media);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 测试群发消息上传缩略图
	 * {"type":"thumb","thumb_media_id":"UenwhUK8tgy27idDdJdQ5g5r6dLteXnq5kW1g4gly4O1ZDwHbPfK2J1R--u2rvQo","created_at":1495548765}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testUploadThumb2() throws RemoteException, FileNotFoundException, IOException {
		MediaEntity media = new MediaEntity();
		media.setFilename("beauty art girl (1).jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(
				new FileInputStream("F:/LiuJian/Documents/Pictures/beauties/seduce/beauty art girl (1).jpg"));
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

	/**
	 * 
	 * 添加临时图文素材，用于群体回复
	 * {"created_at":1495549016,"media_id":"iaffeMn3NedzpZXDOSyIdnNg7Vgrbe7vfItVnNRwsGa032HQ0Yg_2LMWFF5TU5G9","type":"news"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testUploadNewsMedia1() throws RemoteException, FileNotFoundException, IOException {
		NewsItem news = new NewsItem();
		news.setAuthor("Jann");
		news.setDigest("测试美女缩略图，摘要");
		news.setContent("测试美女缩略图,这是一件重大的测试新闻.2017-5-23 12:50");
		news.setShow_cover_pic(1);
		news.setTitle("重磅新闻-Night");
		news.setThumb_media_id("iEhKvMtP5yXO8HVayUXqHr4wvGYWXKozjeyPKqV3Ar0kPxW-XUsj_7CP6cwtQ_s7");
		news.setContent_source_url("https://www.aposoft.cn");
		NewsItem news2 = new NewsItem();
		news2.setAuthor("Jann");
		news2.setDigest("测试美女缩略图2，摘要");
		news2.setContent("测试美女缩略图2,这是一件重大的测试新闻.2017-5-23 12:50");
		news2.setShow_cover_pic(1);
		news2.setTitle("重磅新闻-Day");
		news2.setThumb_media_id("UenwhUK8tgy27idDdJdQ5g5r6dLteXnq5kW1g4gly4O1ZDwHbPfK2J1R--u2rvQo");
		news2.setContent_source_url("https://www.aposoft.cn");
		MediaResp resp = client.uploadNews(accessTokenService.getAccessToken().getAccess_token(), news, news2);
		System.out.println(JSON.toJSONString(resp));
	}
	// "iEhKvMtP5yXO8HVayUXqHr4wvGYWXKozjeyPKqV3Ar0kPxW-XUsj_7CP6cwtQ_s7"

}
