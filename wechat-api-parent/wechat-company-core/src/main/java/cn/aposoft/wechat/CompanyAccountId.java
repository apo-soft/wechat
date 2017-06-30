/**
 * 
 */
package cn.aposoft.wechat;

import cn.aposoft.wechat.account.AccountId;

/**
 * 企业访问授权ID
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface CompanyAccountId extends AccountId {
	/**
	 * @return 企业机构AgentId
	 * 
	 */
	Integer getAgentId();
}
