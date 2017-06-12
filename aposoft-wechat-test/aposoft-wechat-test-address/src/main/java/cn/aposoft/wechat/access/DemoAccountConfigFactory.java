/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.config.AccountConfig;
import cn.aposoft.wechat.config.BasicAccountConfig;

/**
 * AccessTokenConfigFactory 默认实现
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DemoAccountConfigFactory implements AccountConfigFactory {

	private volatile AccountConfig config;

	public DemoAccountConfigFactory() throws IOException {
		try (InputStream input = new FileInputStream("../../config/mp_account.txt")) {
			String s = IOUtils.toString(input, StandardCharsets.UTF_8);
			System.out.println(s);
			config = JSON.parseObject(s, BasicAccountConfig.class);
		}
	}

	public static AccountConfigFactory factory() throws IOException {
		return new DemoAccountConfigFactory();
	}

	@Override
	public AccountConfig getAccountConfig() {
		return config;
	}

}
