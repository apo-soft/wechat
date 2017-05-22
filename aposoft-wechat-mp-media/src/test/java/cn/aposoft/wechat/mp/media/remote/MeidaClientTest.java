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
import org.junit.Test;

import com.alibaba.fastjson.JSON;

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
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testUploadMeida() throws RemoteException, FileNotFoundException, IOException {
		MediaContent media = new MediaContent();
		media.setFileName("panda.png");
		media.setContentType("image/png");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setData(data);

		System.out.println(JSON.toJSONString(client.uploadMedia(accessTokenService.getAccessToken().getAccess_token(),
				MediaType.image.name(), media)));
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGetMeida() throws RemoteException, FileNotFoundException, IOException {
		MediaContent media = new MediaContent();
		media.setFileName("panda.png");
		media.setContentType("image/png");
		byte[] data = IOUtils.toByteArray(new FileInputStream("media/diamond-404.jpg"));
		media.setData(data);

		System.out.println(JSON.toJSONString(client.uploadMedia(accessTokenService.getAccessToken().getAccess_token(),
				MediaType.image.name(), media)));
	}
}
