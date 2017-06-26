/**
 * 
 */
package cn.aposoft.wechat.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.config.repo.AccountConfigExample;
import cn.aposoft.wechat.config.repo.AccountConfigMapper;
import cn.aposoft.wechat.config.repo.AccountConfigMapperTest;

/**
 * 
 * @author Jann Liu
 *
 */
public class AposoftWechatConfigService implements WechatCompanyConfigService, WechatMpConfigService {
	final static Logger logger = LoggerFactory.getLogger(AccountConfigMapperTest.class);
	private AccountConfigMapper accountConfigMapper;

	@Override
	public WechatMpConfig getWechatMpConfig(String id) {
		AccountConfigExample example = new AccountConfigExample();
		example.createCriteria().andAccountTypeEqualTo(AccountType.MP.name()).andIdEqualTo(id);

		List<cn.aposoft.wechat.config.repo.AccountConfig> records = accountConfigMapper.selectByExample(example);
		if (records != null && !records.isEmpty()) {
			return records.get(0);
		}
		return null;
	}

	@Override
	public void setWechatMpConfig(WechatMpConfig config) {
		int recordCount = accountConfigMapper.setMp(config);
		if (logger.isDebugEnabled()) {
			logger.debug("Inserts or Updates: {}", recordCount);
		}
	}

	@Override
	public WechatCompanyConfig getWechatMpConfig(String id, Integer agentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWechatMpConfig(WechatCompanyConfig config) {
		int recordCount = accountConfigMapper.setCorp(config);
		if (logger.isDebugEnabled()) {
			logger.debug("Inserts or Updates: {}", recordCount);
		}
	}

}
