/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.access.repo.DbAccessToken;
import cn.aposoft.wechat.access.repo.DbAccessTokenMapper;

/**
 * AccessToken管理对象,测试类
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DbAccessTokenManagementTest {
	final static Logger logger = LoggerFactory.getLogger(DbAccessTokenManagementTest.class);

	static SqlSession session;
	private DbAccessTokenManagement management;

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

	@Before
	public void prepare() {
		management = new DbAccessTokenManagement(session.getMapper(DbAccessTokenMapper.class));
	}

	@After
	public void clear() {
		session.commit();
	}

	@Test
	public void testGetMpAccessToken() {
		@SuppressWarnings("serial")
		AccountId accountId = new AccountId() {
			@Override
			public AccountType getAccountType() {
				return AccountType.MP;
			}

			@Override
			public String getId() {
				return "wxa11111";
			}

		};
		AccessToken accessToken = management.getAccessToken(accountId);
		logger.info(JSON.toJSONString(accessToken));
	}

	@Test
	public void testGetCompanyAccessToken() {
		@SuppressWarnings("serial")
		CompanyAccountId accountId = new CompanyAccountId() {
			@Override
			public AccountType getAccountType() {
				return AccountType.CORP;
			}

			@Override
			public String getId() {
				return "wxa11112";
			}

			@Override
			public Integer getAgentId() {
				return 2;
			}

		};
		AccessToken accessToken = management.getAccessToken(accountId);
		logger.info(JSON.toJSONString(accessToken));
	}

	@Test
	public void testSetMpAccessToken() {
		DbAccessToken record = new DbAccessToken();
		record.setAccountType(AccountType.MP);
		record.setId("wxa11111");
		record.setExpires_in(7200);
		record.setAccess_token("818290");
		record.setRefreshTime(new Date());
		record.setExpires_in(7200);
		management.setAccessToken((MpAccessTokenStore) record);

	}

	@Test
	public void testSetCorpAccessToken() {
		DbAccessToken record = new DbAccessToken();
		record.setAccountType(AccountType.CORP);
		record.setId("wxa11112");
		record.setAgentId(2);
		record.setExpires_in(7200);
		record.setAccess_token("**wwisoisdifa**");
		record.setRefreshTime(new Date());
		record.setExpires_in(7200);
		management.setAccessToken(record);
	}
}
