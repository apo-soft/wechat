/**
 * 
 */
package cn.aposoft.wechat.config.repo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.AccountType;

/**
 * @author Jann Liu
 *
 */
public class AccountConfigMapperTest {
	final static Logger logger = LoggerFactory.getLogger(AccountConfigMapperTest.class);

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

	/**
	 * @param args
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void testSelectOneBlog() {
		selectWithSession(session);
		selectWithMapper(session);
	}

	private void selectWithSession(SqlSession session) {
		AccountConfigExample example = new AccountConfigExample();

		example.createCriteria().andIdEqualTo("1");
		AccountConfig accountConfigs = session
				.selectOne("cn.aposoft.wechat.config.repo.AccountConfigMapper.selectByExample", example);
		logger.info(JSON.toJSONString(accountConfigs));
	}

	private void selectWithMapper(SqlSession session) {
		AccountConfigMapper mapper = session.getMapper(AccountConfigMapper.class);
		AccountConfigExample example = new AccountConfigExample();

		example.createCriteria().andIdEqualTo("1");
		List<AccountConfig> accountConfigs = mapper.selectByExample(example);
		logger.info(JSON.toJSONString(accountConfigs));
	}

	@Ignore
	@Test
	public void setConfig() {
		AccountConfigMapper mapper = session.getMapper(AccountConfigMapper.class);

		AccountConfig record = new AccountConfig();
		record.setAccountType(AccountType.MP);
		record.setId("*****");
		record.setSecret("*************");
		int accountConfigs = mapper.insertSelective(record);
		logger.info(JSON.toJSONString(accountConfigs));
		session.commit();
	}
}
