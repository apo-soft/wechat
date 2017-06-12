/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.config.AccountConfig;

/**
 * @author Jann Liu
 *
 */
public class DemoAccountConfigFactoryTest {

	@Test
	public void testGetConfig() throws IOException {
		AccountConfig config = DemoAccountConfigFactory.factory().getAccountConfig();
		Assert.assertNotNull(config);
		System.out.println(JSON.toJSONString(config));

	}
}
