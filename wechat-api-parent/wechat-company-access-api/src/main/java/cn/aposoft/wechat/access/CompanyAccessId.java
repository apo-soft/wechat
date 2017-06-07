/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.access.AccessId;

/**
 * 企业访问授权ID
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAccessId extends AccessId {
	/**
	 * @return 企业机构AgentId
	 * 
	 */
	Integer getAgentId();
}
