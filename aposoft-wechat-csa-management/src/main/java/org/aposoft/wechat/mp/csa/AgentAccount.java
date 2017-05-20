/**
 * 
 */
package org.aposoft.wechat.mp.csa;

/**
 * 客服人员账号信息
 * 
 * @author liuya
 *
 */
public class AgentAccount {
	private String account;
	private String nickname;
	private String password;
	private String headerImgUrl;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeaderImgUrl() {
		return headerImgUrl;
	}

	public void setHeaderImgUrl(String headerImgUrl) {
		this.headerImgUrl = headerImgUrl;
	}

}
