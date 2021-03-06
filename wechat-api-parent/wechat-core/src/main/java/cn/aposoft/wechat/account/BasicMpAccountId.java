/**
 * 
 */
package cn.aposoft.wechat.account;

/**
 * 简单的公众号id实现
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicMpAccountId implements AccountId {
	private static final long serialVersionUID = 6741002183762436601L;

	private String id;

	@Override
	public AccountType getAccountType() {
		return AccountType.MP;
	}

	@Override
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return AccountType.MP + "[" + id + "]" + "";

	}
}
