/**
 * 
 */
package cn.aposoft.wechat;

/**
 * 简单的CompanyAccountId
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicCompanyAccountId implements CompanyAccountId {
	private static final long serialVersionUID = -9085766572463011040L;
	/**
	 * 取值固定为{@code AccountType.CORP}
	 */
	private final static AccountType accountType = AccountType.CORP;
	private String id;
	private Integer agentId;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

}
