/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.config.RefreshConfigFactory;
import cn.aposoft.wechat.config.WechatCompanyConfig;

/**
 * @author Jann Liu
 *
 */
public class AccessTokenServiceFactory {
	static final String DEFAULT_FILE_PATH = "../../config/access_token.txt";
	static final String DEFAULT_COMPANY_CONFIG_PATH = "../../config/gome-ops-key.txt";
	static final String DEFAULT_COMPANY_FILE_PATH = "../../config/company_access_token.txt";
	public static AccessTokenService getAccessTokenService() throws IOException {
		return getAccessTokenService(null);
	}

	public static AccessTokenService getAccessTokenService(String filePath) throws IOException {
		if (StringUtils.isBlank(filePath)) {
			filePath = DEFAULT_FILE_PATH;
		}
		AccessTokenClient accessTokenClient = AccessTokenClientFactory.getAccessTokenClient();
		return new FilePathAccessTokenService(DEFAULT_FILE_PATH, accessTokenClient,
				DemoAccountConfigFactory.factory().getAccountConfig(), RefreshConfigFactory.getRefreshConfig());
	}

	public static AccessTokenService getCompanyAccessTokenService() throws FileNotFoundException, IOException {
		return getCompanyAccessTokenService(DEFAULT_COMPANY_FILE_PATH, DEFAULT_COMPANY_CONFIG_PATH);
	}

	public static AccessTokenService getCompanyAccessTokenService(String filePath, String configPath)
			throws FileNotFoundException, IOException {
		if (StringUtils.isBlank(configPath)) {
			configPath = DEFAULT_COMPANY_CONFIG_PATH;
		}
		if (StringUtils.isBlank(filePath)) {
			filePath = DEFAULT_COMPANY_FILE_PATH;
		}
		AccessTokenClient accessTokenClient = AccessTokenClientFactory.getCompanyAccessTokenClient();
		try (InputStream input = new FileInputStream(configPath)) {
			WechatCompanyConfig config = JSON.parseObject(IOUtils.toString(input, StandardCharsets.UTF_8),
					WechatCompanyConfig.class);
			AccessTokenService accessTokenService = new FilePathAccessTokenService(filePath, accessTokenClient, config,
					RefreshConfigFactory.getRefreshConfig());
			return accessTokenService;
		}

	}
}
