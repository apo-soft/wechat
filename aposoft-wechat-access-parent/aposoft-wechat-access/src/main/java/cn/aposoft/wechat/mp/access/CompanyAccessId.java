/**
 * 
 */
package cn.aposoft.wechat.mp.access;

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
