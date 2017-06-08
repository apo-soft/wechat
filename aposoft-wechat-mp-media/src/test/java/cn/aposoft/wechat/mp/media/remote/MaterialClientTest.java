package cn.aposoft.wechat.mp.media.remote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.MediaEntity;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenClientFactory;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.impl.BasicAccessConfigFactory;
import cn.aposoft.wechat.mp.config.testaccount.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.media.MediaType;
import cn.aposoft.wechat.mp.media.news.NewsItem;

public class MaterialClientTest {

	static MaterialClient client = new MaterialClient();
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		if (!HttpClient.isLogEnabled()) {
			HttpClient.setLogEnabled(true);
		}
		accessTokenClient = AccessTokenClientFactory.getAccessTokenClient();
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
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Test
	public void testGetMeidaCount() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {

		System.out.println(
				JSON.toJSONString(client.getMediaCount(accessTokenService.getAccessToken().getAccess_token())));
	}

	/**
	 * 列举新闻资料
	 * 
	 * <pre>
	 * {
		    "item":[
		        {
		            "content":{
		                "create_time":1495479765,
		                "news_item":[
		                    {
		                        "author":"Jann",
		                        "content":"测试新闻内容,这是一件重大的测试新闻.",
		                        "content_source_url":"https://www.aposoft.cn",
		                        "digest":"测试新闻 摘要",
		                        "need_open_comment":0,
		                        "only_fans_can_comment":0,
		                        "show_cover_pic":1,
		                        "thumb_media_id":"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg",
		                        "thumb_url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9puFQCtHq6ngInOrPibVW8RKyrqiaKLB7vLfpicRQ5rKI3Ul3dibL7XshaQ/0?wx_fmt=jpeg",
		                        "title":"测试新闻",
		                        "url":"http://mp.weixin.qq.com/s?__biz=MzI5NzQ4NTcxMA==&mid=100000003&idx=1&sn=92f3e9f96fba7a9d2c4a80d11c1f37db&chksm=6cb515e25bc29cf4808dc8e343771e34aa8e2de802d6c8065ffaee38b4856f04013713130a51#rd"
		                    }
		                ],
		                "update_time":1495479765
		            },
		            "media_id":"gbFT6slaM_0w2LBuG_B-WMOTmnrnD3YlQ84dieFTLSo",
		            "update_time":1495479765
		        }
		    ],
		    "item_count":1,
		    "total_count":1
		}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Test
	public void testGetNewsMaterialList() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MediaListReq req = new MediaListReq();
		req.setCount(100);
		req.setOffset(0);
		req.setType(MediaType.news.name());

		System.out.println(
				JSON.toJSONString(client.getMediaList(accessTokenService.getAccessToken().getAccess_token(), req)));
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Test
	public void testGetMaterialList() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MediaListReq req = new MediaListReq();
		req.setCount(100);
		req.setOffset(0);
		req.setType(MediaType.image.name());

		System.out.println(
				JSON.toJSONString(client.getMediaList(accessTokenService.getAccessToken().getAccess_token(), req)));
	}

	/**
	 * {"media_id":"gbFT6slaM_0w2LBuG_B-WMLDsqp29VjMxDrFHZiOCzo","url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVjiaXWRh5quZn9NvAJ5uKMh72usWGibRQeK8vXRQf8pMEH3TTwaMaexfvNEc75hNlR3pZTEYo7YmsSw/0?wx_fmt=jpeg"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Ignore
	@Test
	public void testAddMeterial() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MediaEntity media = new MediaEntity();
		media.setFilename("diamond-404.jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setEntity(data);

		System.out.println(JSON.toJSONString(client.addMaterial(accessTokenService.getAccessToken().getAccess_token(),
				MediaType.image.name(), media)));
	}

	/**
	 * 影像文件测试用例
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Test
	public void testGetMeterial() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MaterialResp resp = client.getMaterial(accessTokenService.getAccessToken().getAccess_token(),
				"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg");
		if (!StringUtil.isBlank(resp) && !StringUtil.isBlank(resp.getMediaEntity())) {
			System.out.println(resp.getMediaEntity().getFilename());
			System.out.println(resp.getMediaEntity().getContentType());
			System.out.println(resp.getMediaEntity().getLength());
			Assert.assertTrue(resp.getMediaEntity().getLength() > 0);
		} else {
			System.out.println(JSON.toJSONString(resp));
		}
	}

	/**
	 * 测试上传图像
	 * {"url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9exgJsy35rfO8RX6zXNgMkkxtQMdfI6RqHIjw15Q8kiaIczqBGcYic5tw/0"}
	 * {"url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVjiaXWRh5quZn9NvAJ5uKMh78s3icBrQyXdmUS8I8TUv7FbRfI7Y6rmSNTWlxYCYiampmX38UWlXnhVA/0"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Ignore
	@Test
	public void testAddImage() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MediaEntity media = new MediaEntity();
		media.setFilename("diamond-404.jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setEntity(data);
		MediaResp resp = client.uploadImage(accessTokenService.getAccessToken().getAccess_token(), media);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * {"media_id":"gbFT6slaM_0w2LBuG_B-WCZ3QPLdOneF-f1Dc7yV8zc"}
	 * {"media_id":"gbFT6slaM_0w2LBuG_B-WIjnv6Zigyu3GrRdYBdpbIA"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Ignore
	@Test
	public void testAddNews() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		NewsItem news = new NewsItem();
		news.setAuthor("Jann");
		news.setDigest("测试新闻 摘要-1");
		news.setContent("测试新闻内容,这是一件重大的测试新闻.2017-5-23 11:34");
		news.setShow_cover_pic(1);
		news.setTitle("测试新闻");
		news.setThumb_media_id("gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg");
		news.setContent_source_url(
				"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVjiaXWRh5quZn9NvAJ5uKMh78s3icBrQyXdmUS8I8TUv7FbRfI7Y6rmSNTWlxYCYiampmX38UWlXnhVA/0");
		MediaResp resp = client.addNews(accessTokenService.getAccessToken().getAccess_token(), news);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * {"media_id":"gbFT6slaM_0w2LBuG_B-WCZ3QPLdOneF-f1Dc7yV8zc"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Ignore
	@Test
	public void testUpdateNews() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		NewsReq req = new NewsReq();
		req.setMedia_id("gbFT6slaM_0w2LBuG_B-WMOTmnrnD3YlQ84dieFTLSo");
		req.setIndex(0);
		NewsItem newsItem = new NewsItem();
		newsItem.setAuthor("Jann");
		newsItem.setDigest("测试新闻 摘要更新");
		newsItem.setContent("测试新闻内容,这是一件重大的测试新闻，在2017年5月23日发生了重大更新。");
		newsItem.setShow_cover_pic(1);
		newsItem.setTitle("测试新闻（修订）");
		newsItem.setThumb_media_id("gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg");
		newsItem.setContent_source_url("https://www.aposoft.cn");
		req.setArticles(newsItem);

		MediaResp resp = client.updateNews(accessTokenService.getAccessToken().getAccess_token(), req);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":45009,"errmsg":"reach max api daily quota limit hint:
	 * [lKKl0582vr65!]"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Test
	public void testGetNews() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		MaterialResp resp = client.getMaterial(accessTokenService.getAccessToken().getAccess_token(),
				"gbFT6slaM_0w2LBuG_B-WIjnv6Zigyu3GrRdYBdpbIA");
		if (!StringUtil.isBlank(resp) && !StringUtil.isBlank(resp.getMediaEntity())) {
			System.out.println(resp.getMediaEntity().getFilename());
			System.out.println(resp.getMediaEntity().getContentType());
			System.out.println(resp.getMediaEntity().getLength());
			Assert.assertTrue(resp.getMediaEntity().getLength() > 0);
		} else {
			System.out.println(JSON.toJSONString(resp));
		}
	}

	/**
	 * 
	 * {"media_id":"gbFT6slaM_0w2LBuG_B-WCZ3QPLdOneF-f1Dc7yV8zc"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException 
	 */
	@Ignore
	@Test
	public void testDeleteMaterial() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		WechatResp resp = client.deleteMaterial(accessTokenService.getAccessToken().getAccess_token(),
				"gbFT6slaM_0w2LBuG_B-WCZ3QPLdOneF-f1Dc7yV8zc");
		System.out.println(JSON.toJSONString(resp));
	}
}
