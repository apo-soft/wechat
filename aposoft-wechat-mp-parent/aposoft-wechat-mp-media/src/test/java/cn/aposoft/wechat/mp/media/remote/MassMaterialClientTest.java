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

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 * @author Jann Liu
 *
 */
public class MassMaterialClientTest {

	static MassMaterialClient client = new MassMaterialClient();
	static AccessToken accessToken;
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
		client.close();
	}

	/**
	 * 测试群发消息上传缩略图
	 * {"type":"thumb","thumb_media_id":"RFxNjzEygtLFVwgNKc_J9WxGtoSWqHrccgLE-5nudyFSVC5R4vMg9UULRukKsn1v","created_at":1495512213}
	 * {"type":"thumb","thumb_media_id":"-qsg3xloIj1GMMRGe8BUqGg4KD3VSNCl0af3WVGKHSi4laY8sn5IwCKqqJWptxE4","created_at":1495512213}
	 * <p>
	 * 2017/7/4
	 * {"type":"thumb","thumb_media_id":"HquHH8FscPVMHmSG_SPLKBQmu3wpOawEImk-0UMdh-80g69Qh1NG-xhYvehwfD_S","created_at":1499148654}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
	// @Ignore
	@Test
	public void testUploadThumb() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
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
	 * <p>
	 * {"created_at":1496899869,"thumb_media_id":"N51ogak1GO0fz2Yr2P_EVDT_-dgBI8Rymq2P9beJkQJT4slVmh1L4iE1qVe3JUkk","type":"thumb"}
	 * <p>
	 * 2017/7/4
	 * {"type":"thumb","thumb_media_id":"M-DNcJ1z2IxNZ8hhOq_K2AEEvXHqGrPhaKiPqcUYKJPlkzelx2-LWRnkQtJXCDau","created_at":1499148707}
	 * {"type":"thumb","thumb_media_id":"BWKeaHF4T1pb-rbXNK04fEIeF33X7yWfy2TbEJ8O0R7Tdyo3HjGRtNbJcEKY2CQc","created_at":1499149214}
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
	// @Ignore
	@Test
	public void testUploadThumb1() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MediaEntity media = new MediaEntity();
		media.setFilename("名模木口亚矢很美的一组性感玉照(15).jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(
				new FileInputStream("F:/LiuJian/Documents/Pictures/beauties/seduce/名模木口亚矢很美的一组性感玉照 (16).jpg"));
		media.setEntity(data);
		MediaResp resp = client.uploadNewsThumb(accessTokenService.getAccessToken().getAccess_token(), media);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 测试群发消息上传缩略图
	 * {"type":"thumb","thumb_media_id":"UenwhUK8tgy27idDdJdQ5g5r6dLteXnq5kW1g4gly4O1ZDwHbPfK2J1R--u2rvQo","created_at":1495548765}
	 * {"created_at":1496030621,"thumb_media_id":"ix85FlJSkZFfYbKljsNRSREkhcI3LyYjhH0cNxeKORWB2li_vup-9G9lTs2K4nPf","type":"thumb"}
	 * <p>
	 * {"created_at":1496899922,"thumb_media_id":"01Y_Efkq5oUMhKzD0LNEKGojpIZSxtUKSC95ArUqlBiA4vC43EeduT9xKkaHmFID","type":"thumb"}
	 * <p>2017/7/4
	 * {"type":"thumb","thumb_media_id":"-hQLgzoAVYQDNMP7vS536ACoAmQer_APTY_CAhS9PD_DbWjgj72TdV-LIs6vfegl","created_at":1499148987}
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
//	@Ignore
	@Test
	public void testUploadThumb2() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
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
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testUploadNewsMedia() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		NewsItem news = new NewsItem();
		news.setAuthor("Jann");
		news.setDigest("今天就我要测试群发，这是重大新闻");
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
	 * <p>
	 * 2017/5/29
	 * {"created_at":1496030648,"media_id":"qN2VrGbthtk9pCbC5zu1gmVq85MCIDBqRUHxNk3S5FACOJTNzPvJZLUGKuUimxTT","type":"news"}
	 * <p>
	 * 2018/6/8
	 * {"type":"news","media_id":"tFGFFKYObPDMN89ePA09nfX1gJf8Tosq-7YTab5bD6vYe3Poq1e_pQQW0T-MRV8B","created_at":1496899964}
	 * {"created_at":1496899964,"media_id":"tFGFFKYObPDMN89ePA09nfX1gJf8Tosq-7YTab5bD6vYe3Poq1e_pQQW0T-MRV8B","type":"news"}
	 * <p>
	 * 2017/7/4
	 * {"type":"news","media_id":"CL9n_oEINPnzYezeKSSc0Yx-Esw7QNQG3U_85hH4c3oSocU0iSCGkgF9Hfkq8Ygx","created_at":1499148762}
	 * {"type":"news","media_id":"ytupwLlPngh5XdmfFQ_eAslFs6ZDF8KifwWKog2eQU2VXAyMGg5uEF-Ticv5hi_4","created_at":1499149279}
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
	// @Ignore
	@Test
	public void testUploadNewsMedia1()
			throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		NewsItem news = new NewsItem();
		news.setAuthor("Jann");
		news.setDigest("测试美女-Hotspot");
		news.setContent("美女缩略图,这是一件重大的测试新闻.2017-7-4 12:50");
		news.setShow_cover_pic(1);
		news.setTitle("重磅新闻-Night");
		news.setThumb_media_id("BWKeaHF4T1pb-rbXNK04fEIeF33X7yWfy2TbEJ8O0R7Tdyo3HjGRtNbJcEKY2CQc");
		news.setContent_source_url("https://www.aposoft.cn");
		NewsItem news2 = new NewsItem();
		news2.setAuthor("Jann");
		news2.setDigest("测试美女");
		news2.setContent("美女缩略图,这是一件重大的测试新闻.2017-7-4 17:50");
		news2.setShow_cover_pic(1);
		news2.setTitle("重磅新闻-Day");
		news2.setThumb_media_id("-hQLgzoAVYQDNMP7vS536ACoAmQer_APTY_CAhS9PD_DbWjgj72TdV-LIs6vfegl");
		news2.setContent_source_url("https://www.aposoft.cn");
		MediaResp resp = client.uploadNews(accessTokenService.getAccessToken().getAccess_token(), news, news2);
		System.out.println(JSON.toJSONString(resp));
	}
	// "iEhKvMtP5yXO8HVayUXqHr4wvGYWXKozjeyPKqV3Ar0kPxW-XUsj_7CP6cwtQ_s7"

}
