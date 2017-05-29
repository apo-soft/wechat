/**
 * 
 */
package org.aposoft.wechat.company.managemnt.agent;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 读取的企业应用列表
 * 
 * <pre>
 * {
   "errcode": 0,
   "errmsg": "ok",
   "agentlist": [
       {
           "agentid": "5",
           "name": "企业小助手",
           "square_logo_url": "url",
           "round_logo_url": "url"
       },
       {
           "agentid": "8",
           "name": "HR小助手",
           "square_logo_url": "url",
           "round_logo_url": "url"
       }
       ]  
}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class AgentListResp extends WechatResp {
	private static final long serialVersionUID = -7556459776627257098L;

	private Agent[] agentlist;

	/**
	 * @return the agentlist
	 */
	public Agent[] getAgentlist() {
		return agentlist;
	}

	/**
	 * @param agentlist
	 *            the agentlist to set
	 */
	public void setAgentlist(Agent[] agentlist) {
		this.agentlist = agentlist;
	}

}
