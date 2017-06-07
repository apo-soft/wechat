/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.access.AccountId;

/**
 * 企业访问授权ID
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAccessId extends AccountId {
	/**
	 * @return 企业机构AgentId
	 * 
	 */
	Integer getAgentId();
}
