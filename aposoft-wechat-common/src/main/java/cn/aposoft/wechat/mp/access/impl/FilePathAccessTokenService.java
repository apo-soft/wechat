/**
 * 
 */
package cn.aposoft.wechat.mp.access.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.access.AccessConfig;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;

/**
 * 从文件路径读取ACCESS_TOKEN的方法，避免测试时反复调用远程AccessToken，导致调用失败
 * 
 * @author Jann Liu
 *
 */
public class FilePathAccessTokenService extends BasicAccessTokenService {

	public static final String DEFAULT_FILE_PATH = "../config/access_token.txt";
	private final File file;

	private volatile AccessToken accessToken;

	public FilePathAccessTokenService(String filepath, AccessTokenClient client, AccessConfig config)
			throws IOException {
		super(client, config);
		File file = new File(filepath);
		if (file.exists() && file.isDirectory()) {
			throw new IOException("Filepath is not a file");
		}

		if (!file.exists()) {
			FileUtils.touch(file);
		}
		this.file = file;
		readAccessToken();
	}

	protected void readAccessToken() throws FileNotFoundException, IOException {
		try (FileReader reader = new FileReader(file)) {
			String accessTokenString = IOUtils.toString(reader);
			if (!StringUtils.isBlank(accessTokenString)) {
				accessToken = JSON.parseObject(accessTokenString, BasicAccessToken.class);
				System.out.println(accessToken);
			}
		}
	}

	@Override
	public AccessToken getAccessToken() {
		System.out.println(accessToken == null);
		if (accessToken == null || isNearlyExpired(accessToken)) {
			try {
				readAccessToken();
			} catch (IOException e1) {
				// ignore
			}
			if (accessToken == null || isNearlyExpired(accessToken)) {
				accessToken = super.getAccessToken();
				try {
					IOUtils.write(JSON.toJSONString(accessToken), new FileOutputStream(file));
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return accessToken;
	}

}
