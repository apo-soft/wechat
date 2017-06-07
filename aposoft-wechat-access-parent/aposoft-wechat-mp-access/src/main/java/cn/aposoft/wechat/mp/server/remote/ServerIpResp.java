/**
 * 
 */
package cn.aposoft.wechat.mp.server.remote;

import java.util.List;

import cn.aposoft.wechat.mp.WechatResp;

/**
 * 服务器IP响应报文
 * 
 * @author Jann Liu
 *
 */
public class ServerIpResp extends WechatResp {
	private static final long serialVersionUID = 8147359032708747182L;
	private List<String> ip_list;

	/**
	 * @return the ip_list
	 */
	public List<String> getIp_list() {
		return ip_list;
	}

	/**
	 * @param ip_list
	 *            the ip_list to set
	 */
	public void setIp_list(List<String> ip_list) {
		this.ip_list = ip_list;
	}
}
