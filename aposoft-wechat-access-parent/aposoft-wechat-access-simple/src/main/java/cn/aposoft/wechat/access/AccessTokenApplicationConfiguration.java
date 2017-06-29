/**
 * 
 */
package cn.aposoft.wechat.access;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.aposoft.wechat.access.repo.DbAccessTokenMapper;

/**
 * 应用配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
//@ImportResource("classpath:spring/access-token-spring-config.xml")
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "cn.aposoft.wechat.**.repo")
public class AccessTokenApplicationConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenApplicationConfiguration.class);

	@Bean
	public CompanyAccessTokenManagement accessTokenManagement(DbAccessTokenMapper dbAccessTokenMapper) {
		if (logger.isDebugEnabled()) {
			logger.debug(dbAccessTokenMapper == null ? "dbAccessTokenMapper null" : "dbAccessTokenMapper not null");
		}
		return new DbAccessTokenManagement(dbAccessTokenMapper);
	}

}
