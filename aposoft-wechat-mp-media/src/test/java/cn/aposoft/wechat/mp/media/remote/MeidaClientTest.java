/**
 * 
 */
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
import cn.aposoft.util.MediaEntity;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;

/**
 * @author Jann Liu
 *
 */
public class MeidaClientTest {

	static MediaClient client = new MediaClient();
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
	 * {@code {"created_at":1495420514,"media_id":"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L","type":"image"}}
	 * {"created_at":1495429645,"media_id":"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw","type":"image"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testUploadMeida() throws RemoteException, FileNotFoundException, IOException {
		MediaEntity media = new MediaEntity();
		media.setFilename("diamond-404.jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setEntity(data);

		System.out.println(JSON.toJSONString(client.uploadMedia(accessTokenService.getAccessToken().getAccess_token(),
				MediaType.image.name(), media)));
	}

	/**
	 * {"created_at":1495429645,"media_id":"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw","type":"image"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeida1() throws RemoteException, FileNotFoundException, IOException {

		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));

		MediaEntityResp dataResp = client.getMedia(accessTokenService.getAccessToken().getAccess_token(),
				"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw");
		if (dataResp != null && dataResp.getMedia() != null) {
			Assert.assertTrue(data.length == dataResp.getMedia().getLength());
		}
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeida() throws RemoteException, FileNotFoundException, IOException {

		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));

		MediaEntityResp dataResp = client.getMedia(accessTokenService.getAccessToken().getAccess_token(),
				"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L");
		System.out.println(dataResp.getMedia().getFilename());
		System.out.println(dataResp.getMedia().getContentType());
		System.out.println(dataResp.getMedia().getLength());
		if (dataResp != null && dataResp.getMedia() != null) {
			Assert.assertTrue(data.length == dataResp.getMedia().getLength());
		}
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeidaCount() throws RemoteException, FileNotFoundException, IOException {

		System.out.println(
				JSON.toJSONString(client.getMediaCount(accessTokenService.getAccessToken().getAccess_token())));
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeidaList() throws RemoteException, FileNotFoundException, IOException {
		MediaListReq req = new MediaListReq();
		req.setCount(100);
		req.setOffset(0);
		req.setType(MediaType.image.name());

		System.out.println(
				JSON.toJSONString(client.getMediaList(accessTokenService.getAccessToken().getAccess_token(), req)));
	}

	/**
	 * {@code {"created_at":1495420514,"media_id":"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L","type":"image"}}
	 * {"created_at":1495429645,"media_id":"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw","type":"image"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Ignore
	@Test
	public void testAddMeterial() throws RemoteException, FileNotFoundException, IOException {
		MediaEntity media = new MediaEntity();
		media.setFilename("diamond-404.jpg");
		media.setContentType("image/jpg");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setEntity(data);

		System.out.println(JSON.toJSONString(client.addMaterial(accessTokenService.getAccessToken().getAccess_token(),
				MediaType.image.name(), media)));
	}

	/**
	 * {@code {"created_at":1495420514,"media_id":"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L","type":"image"}}
	 * {"created_at":1495429645,"media_id":"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw","type":"image"}
	 * 
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeterial() throws RemoteException, FileNotFoundException, IOException {
		MaterialResp resp = client.getMaterial(accessTokenService.getAccessToken().getAccess_token(),
				"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg");
		System.out.println(resp.getMediaEntity().getFilename());
		System.out.println(resp.getMediaEntity().getContentType());
		System.out.println(resp.getMediaEntity().getLength());
		Assert.assertTrue(resp.getMediaEntity().getLength() > 0);
	}
}
