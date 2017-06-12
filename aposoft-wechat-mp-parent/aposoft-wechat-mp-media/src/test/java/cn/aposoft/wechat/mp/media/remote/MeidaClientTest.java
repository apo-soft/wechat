/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.mp.media.MediaType;

/**
 * @author Jann Liu
 *
 */
public class MeidaClientTest {

	static MediaClient client = new MediaClient();
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
	 * {@code {"created_at":1495420514,"media_id":"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L","type":"image"}}
	 * {"created_at":1495429645,"media_id":"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw","type":"image"}
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testUploadMeida() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
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
	 * @throws AccessTokenException
	 */
	@Test
	public void testGetMeida1() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		try (InputStream input = new FileInputStream("media/diamond-404.jpg")) {
			byte[] data = IOUtils.toByteArray(input);

			MediaEntityResp dataResp = client.getMedia(accessTokenService.getAccessToken().getAccess_token(),
					"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw");
			if (dataResp != null && dataResp.getMedia() != null) {
				Assert.assertTrue(data.length == dataResp.getMedia().getLength());
			}
		}
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws AccessTokenException
	 */
	@Test
	public void testGetMeida() throws RemoteException, FileNotFoundException, IOException, AccessTokenException {
		try (InputStream input = new FileInputStream("media/diamond-404.jpg")) {
			byte[] data = IOUtils.toByteArray(input);

			MediaEntityResp dataResp = client.getMedia(accessTokenService.getAccessToken().getAccess_token(),
					"KsmAk839SjPBI-yb8jweVB1ypbg0w4M_P1Bxg6OfGLBeW_O5Rcy9OogJvDS2dBDw");

			if (dataResp != null && dataResp.getMedia() != null) {
				Assert.assertEquals(data.length, dataResp.getMedia().getLength().longValue());
				System.out.println(dataResp.getMedia().getFilename());
				System.out.println(dataResp.getMedia().getContentType());
				System.out.println(dataResp.getMedia().getLength());
			}
		}
	}

}
