/**
 * 
 */
package cn.aposoft.wechat.access;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.aposoft.wechat.BasicCompanyAccountId;
import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.access.address.SimpleAccessTokenAddressConfig;
import cn.aposoft.wechat.access.repo.DbAccessTokenMapper;
import cn.aposoft.wechat.config.AposoftWechatConfigService;
import cn.aposoft.wechat.config.BasicRefreshConfig;
import cn.aposoft.wechat.config.repo.AccountConfigMapper;

/**
 * 应用配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
// @ImportResource("classpath:spring/access-token-spring-config.xml")
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan(basePackages = "cn.aposoft.wechat.**.repo")
public class AccessTokenApplicationConfiguration {

	@Bean
	public DbAccessTokenManagement accessTokenManagement(DbAccessTokenMapper dbAccessTokenMapper) {
		return new DbAccessTokenManagement(dbAccessTokenMapper);
	}

	@Bean
	public AposoftWechatConfigService aposoftWechatConfigService(AccountConfigMapper accountConfigMapper) {
		AposoftWechatConfigService service = new AposoftWechatConfigService();
		service.setAccountConfigMapper(accountConfigMapper);
		return service;
	}

	@Bean
	@ConfigurationProperties(prefix = "aposoft.wechat.companyAccountId")
	public BasicCompanyAccountId accountId() {
		return new BasicCompanyAccountId();
	}

	@Bean
	@ConfigurationProperties(prefix = "aposoft.wechat.refreshConfig")
	public BasicRefreshConfig refreshConfig() {
		return new BasicRefreshConfig();
	}

	@Bean
	public SimpleAccessTokenAddressConfig accessTokenAddressConfig() {
		return new SimpleAccessTokenAddressConfig();
	}

	@Bean(destroyMethod = "close")
	public DefaultAccessTokenClient accessTokenClient(AddressConfig accessTokenAddressConfig) {
		return new DefaultAccessTokenClient(accessTokenAddressConfig);
	}

}
