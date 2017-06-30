/**
 * 
 */
package cn.aposoft.wechat.config;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.framework.data.PersistentErrorException;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.account.AccountId;
import cn.aposoft.wechat.account.AccountType;
import cn.aposoft.wechat.config.repo.AccountConfigExample;
import cn.aposoft.wechat.config.repo.AccountConfigMapper;

/**
 * 微信通用配置信息读取,存储服务
 * <p>
 * <attention>mybatis 底层对SQLException 转换为RuntimeException,需要在业务中进行处理</attention>
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AposoftWechatConfigService implements WechatConfigService {
	final static Logger logger = LoggerFactory.getLogger(AposoftWechatConfigService.class);
	private AccountConfigMapper accountConfigMapper;

	public AposoftWechatConfigService() {
	}

	private WechatConfig getWechatConfig(AccountConfigExample example) {
		List<cn.aposoft.wechat.config.repo.AccountConfig> records = accountConfigMapper.selectByExample(example);
		if (records != null && !records.isEmpty()) {
			return records.get(0);
		}
		return null;
	}

	public AposoftWechatConfigService(AccountConfigMapper accountConfigMapper) {
		this.accountConfigMapper = accountConfigMapper;
	}

	public void setAccountConfigMapper(AccountConfigMapper accountConfigMapper) {
		this.accountConfigMapper = accountConfigMapper;
	}

	private AccountConfigExample getMpExample(String id) {
		AccountConfigExample example = new AccountConfigExample();
		example.createCriteria().andAccountTypeEqualTo(AccountType.MP.name()).andIdEqualTo(id);
		return example;
	}

	private AccountConfigExample getExample(AccountId accountId) {
		if (AccountType.MP.equals(accountId.getAccountType())) {
			return getMpExample(accountId.getId());
		} else {
			return getCompanyExample((CompanyAccountId) accountId);
		}
	}

	private AccountConfigExample getCompanyExample(CompanyAccountId accountId) {
		return getCompanyExample(accountId.getId(), accountId.getAgentId());
	}

	private AccountConfigExample getCompanyExample(final String id, final int agentId) {
		AccountConfigExample example = new AccountConfigExample();
		example.createCriteria().andAccountTypeEqualTo(AccountType.CORP.name()).andIdEqualTo(id)
				.andAgentIdEqualTo(agentId);
		return example;
	}

	@Override
	public WechatMpConfig getWechatMpConfig(String id) {
		return getWechatConfig(getMpExample(id));
	}

	@Override
	public void setWechatMpConfig(WechatMpConfig config) {
		int recordCount = accountConfigMapper.setMp(config);
		if (recordCount <= 0) {
			throw new PersistentErrorException("No data modified,count:" + recordCount);
		}
	}

	@Override
	public WechatCompanyConfig getWechatCompanyConfig(final String id, final Integer agentId) {
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
	public void setWechatCompanyConfig(WechatCompanyConfig config) {
		int recordCount = accountConfigMapper.setCorp(config);
		if (recordCount <= 0) {
			throw new PersistentErrorException("No data modified,count:" + recordCount);
		}
	}

	@Override
	public WechatCompanyConfig getWechatCompanyConfig(CompanyAccountId accountId) {
		if (accountId == null || accountId.getAgentId() == null || StringUtils.isBlank(accountId.getId())) {
			return null;
		}
		return getWechatCompanyConfig(accountId.getId(), accountId.getAgentId());
	}

	/**
	 * 返回通用配置信息，适用于公众号和企业号
	 */
	@Override
	public WechatConfig getWechatConfig(final AccountId accountId) {
		AccountConfigExample example = getExample(accountId);
		return getWechatConfig(example);
	}
}
