/**
 * 
 */
package cn.aposoft.wechat.ticket;

import java.util.Date;

/**
 * JS-页面访问票据
 * 
 * <pre>
 * {
		"errcode":0,
		"errmsg":"ok",
		"ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA",
		"expires_in":7200
	}
 * </pre>
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface Ticket {
	/**
	 * Ticket 类型
	 * 
	 * @author Jann Liu
	 * @since 1.0
	 */
	public static enum Type {
		/**
		 * Javascript ticket
		 */
		jsapi("https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token="),
		/**
		 * 卡券
		 */
		wx_card("https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=wx_card&access_token="),
		/**
		 * 企业JS-API
		 */
		work("https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=");
		public final String url;

		private Type(String url) {
			this.url = url;
		}
	}

	Type getType();

	/**
	 * Token 实际值,微信返回
	 * 
	 * @return 微信提供的Ticket 有效值字符串
	 */
	public String getTicket();

	/**
	 * 微信提供的超时时间 秒
	 * 
	 * @return 超时时间
	 */
	public int getExpires_in();

	/**
	 * 刷新token时间，服务器本地计时
	 * 
	 * @return 服务器本地计时刷新时间
	 */
	public Date getRefreshTime();
}
