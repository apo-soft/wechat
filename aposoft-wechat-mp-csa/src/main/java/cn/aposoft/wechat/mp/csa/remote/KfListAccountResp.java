/**
 * 
 */
package cn.aposoft.wechat.mp.csa.remote;

import java.util.List;

import cn.aposoft.wechat.mp.csa.AgentAccount;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 客服列表
 * 
 * @author Jann Liu
 *
 */
public class KfListAccountResp extends WechatResp {
	private static final long serialVersionUID = -4414482522656211494L;
	private List<AgentAccount> kf_list;

	public List<AgentAccount> getKf_list() {
		return kf_list;
	}

	public void setKf_list(List<AgentAccount> kf_list) {
		this.kf_list = kf_list;
	}
}
