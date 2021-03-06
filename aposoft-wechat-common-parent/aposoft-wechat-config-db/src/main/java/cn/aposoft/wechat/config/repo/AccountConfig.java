package cn.aposoft.wechat.config.repo;

import java.util.Date;

import cn.aposoft.wechat.account.AccountType;
import cn.aposoft.wechat.config.WechatConfig;

/**
 * 账户配置信息:mybatis:DB
 */
public class AccountConfig implements WechatConfig {
	private static final long serialVersionUID = -926784705809538822L;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private String id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.account_type
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private AccountType accountType;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.agent_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private Integer agentId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.secret
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private String secret;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.encoding_AES_Key
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private String encodingAESKey;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.token
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private String token;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.user_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private String userId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.create_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private Date createTime;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column account_config.update_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.id
	 *
	 * @return the value of account_config.id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.id
	 *
	 * @param id
	 *            the value for account_config.id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.account_type
	 *
	 * @return the value of account_config.account_type
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.account_type
	 *
	 * @param accountType
	 *            the value for account_config.account_type
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.agent_id
	 *
	 * @return the value of account_config.agent_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.agent_id
	 *
	 * @param agentId
	 *            the value for account_config.agent_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.secret
	 *
	 * @return the value of account_config.secret
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.secret
	 *
	 * @param secret
	 *            the value for account_config.secret
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.encoding_AES_Key
	 *
	 * @return the value of account_config.encoding_AES_Key
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.encoding_AES_Key
	 *
	 * @param encodingAesKey
	 *            the value for account_config.encoding_AES_Key
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.token
	 *
	 * @return the value of account_config.token
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public String getToken() {
		return token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.token
	 *
	 * @param token
	 *            the value for account_config.token
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.user_id
	 *
	 * @return the value of account_config.user_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.user_id
	 *
	 * @param userId
	 *            the value for account_config.user_id
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.create_time
	 *
	 * @return the value of account_config.create_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.create_time
	 *
	 * @param createTime
	 *            the value for account_config.create_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column account_config.update_time
	 *
	 * @return the value of account_config.update_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column account_config.update_time
	 *
	 * @param updateTime
	 *            the value for account_config.update_time
	 *
	 * @mbg.generated Mon Jun 26 09:53:19 CST 2017
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}