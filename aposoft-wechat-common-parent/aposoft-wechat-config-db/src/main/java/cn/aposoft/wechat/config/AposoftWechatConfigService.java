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
 * 微信通用配置信息读取,存储服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AposoftWechatConfigService implements WechatCompanyConfigService, WechatMpConfigService {
	final static Logger logger = LoggerFactory.getLogger(AccountConfigMapperTest.class);
	private AccountConfigMapper accountConfigMapper;

	public void setAccountConfigMapper(AccountConfigMapper accountConfigMapper) {
		this.accountConfigMapper = accountConfigMapper;
	}

	public AposoftWechatConfigService() {
	}

	public AposoftWechatConfigService(AccountConfigMapper accountConfigMapper) {
		this.accountConfigMapper = accountConfigMapper;
	}

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
	public WechatCompanyConfig getWechatMpConfig(final String id, final Integer agentId) {
		AccountConfigExample example = new AccountConfigExample();
		example.createCriteria().andAccountTypeEqualTo(AccountType.CORP.name()).andIdEqualTo(id)
				.andAgentIdEqualTo(agentId);

		List<cn.aposoft.wechat.config.repo.AccountConfig> records = accountConfigMapper.selectByExample(example);
		if (records != null && !records.isEmpty()) {
			return records.get(0);
		}
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
