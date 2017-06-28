/**
 * 
 */
package cn.aposoft.wechat.access.repo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.AccountType;

/**
 * account_config 微信公众号,企业号配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DbAccessTokenMapperTest {
	final static Logger logger = LoggerFactory.getLogger(DbAccessTokenMapperTest.class);

	static SqlSession session;

	@BeforeClass
	public static void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@AfterClass
	public static void dispose() {
		session.close();
	}

	@After
	public void clear() {
		session.commit();
	}

	// @Ignore
	@Test
	public void testSelectOneBlog() {
		selectWithSession(session);
		selectWithMapper(session);
	}

	private void selectWithSession(SqlSession session) {
		DbAccessTokenExample example = new DbAccessTokenExample();

		example.createCriteria().andAccountTypeEqualTo(AccountType.MP.name()).andIdEqualTo("wxa11111");
		DbAccessToken accountConfigs = session
				.selectOne("cn.aposoft.wechat.access.repo.DbAccessTokenMapper.selectByExample", example);
		logger.info(JSON.toJSONString(accountConfigs));
	}

	private void selectWithMapper(SqlSession session) {
		DbAccessTokenMapper mapper = session.getMapper(DbAccessTokenMapper.class);
		DbAccessTokenExample example = new DbAccessTokenExample();

		example.createCriteria().andAccountTypeEqualTo(AccountType.CORP.name()).andIdEqualTo("wxa11112")
				.andAgentIdEqualTo(2);
		List<DbAccessToken> accountConfigs = mapper.selectByExample(example);
		logger.info(JSON.toJSONString(accountConfigs));

	}

	@Ignore
	@Test
	public void setMpAccessToken() {
		DbAccessTokenMapper mapper = session.getMapper(DbAccessTokenMapper.class);
		DbAccessToken record = new DbAccessToken();
		record.setAccountType(AccountType.MP);
		record.setId("wxa11111");
		record.setExpires_in(7200);
		record.setAccess_token("818288");
		record.setRefreshTime(new Date());
		record.setExpires_in(7200);
		int accessTokenCounts = mapper.setMpAccessToken(record);
		logger.info(String.valueOf(accessTokenCounts));
	}

	@Ignore
	@Test
	public void setCompanyAccessToken() {
		DbAccessTokenMapper mapper = session.getMapper(DbAccessTokenMapper.class);
		DbAccessToken record = new DbAccessToken();
		record.setAccountType(AccountType.CORP);
		record.setId("wxa11112");
		record.setAgentId(2);
		record.setAccess_token("****wwisoisdifa**");
		record.setExpires_in(7200);
		record.setRefreshTime(new Date());
		int accessTokenCounts = mapper.setCompanyAccessToken(record);
		logger.info(String.valueOf(accessTokenCounts));
	}
}
