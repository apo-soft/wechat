/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.config.AccountConfig;
import cn.aposoft.wechat.config.RefreshConfig;

/**
 * 从文件路径读取ACCESS_TOKEN的方法，避免测试时反复调用远程AccessToken，导致调用失败
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class FilePathAccessTokenService extends BasicAccessTokenService {

	private final File file;

	private volatile AccessToken accessToken;

	public FilePathAccessTokenService(String filepath, AccessTokenClient client, AccountConfig accountConfig,
			RefreshConfig refreshConfig) throws IOException {
		super(client, accountConfig, refreshConfig);
		File file = new File(filepath);
		if (file.exists() && file.isDirectory()) {
			throw new IOException("Filepath is not a file");
		}

		if (!file.exists()) {
			FileUtils.touch(file);
		}
		this.file = file;
		loadCacheAccessToken();
	}

	/**
	 * 加载缓存的Accesstoken
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected void loadCacheAccessToken() throws FileNotFoundException, IOException {
		try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.US_ASCII)) {
			String accessTokenString = IOUtils.toString(reader);
			if (!StringUtils.isBlank(accessTokenString)) {
				accessToken = JSON.parseObject(accessTokenString, BasicAccessToken.class);
			}
		}
	}

	@Override
	public AccessToken getAccessToken() throws AccessTokenException {
		if (accessToken == null || isNearlyExpired(accessToken)) {
			try {
				loadCacheAccessToken();
			} catch (IOException e1) {
				// ignore
			}
			if (accessToken == null || isNearlyExpired(accessToken)) {
				accessToken = super.getAccessToken();
				try (OutputStream output = new FileOutputStream(file)) {
					IOUtils.write(JSON.toJSONString(accessToken), output, StandardCharsets.US_ASCII);
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return accessToken;
	}

}
