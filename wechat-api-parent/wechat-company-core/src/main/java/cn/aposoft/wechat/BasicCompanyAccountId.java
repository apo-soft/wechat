/**
 * 
 */
package cn.aposoft.wechat;

import cn.aposoft.wechat.account.AccountType;

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

	@Override
	public String toString() {
		return accountType + "[" + id + ":" + agentId + "]";
	}

	// CompanyAccountId 三要素相等
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (!(other instanceof CompanyAccountId)) {
			return false;
		}
		// 类型 id，agentId相等
		if (equals(AccountType.CORP, ((CompanyAccountId) other).getAccountType())
				&& equals(this.id, ((CompanyAccountId) other).getId())
				&& equals(this.agentId, ((CompanyAccountId) other).getAgentId())) {
			return true;
		}
		return false;
	}

	private static <T extends Comparable<T>> boolean equals(T v1, T v2) {
		return (v1 == null && v2 == null) || (v1 != null && v1.compareTo(v2) == 0);
	}
}
