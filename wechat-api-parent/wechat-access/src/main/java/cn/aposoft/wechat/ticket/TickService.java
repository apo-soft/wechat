/**
 * 
 */
package cn.aposoft.wechat.ticket;

import cn.aposoft.wechat.access.address.UrlConfig;

/**
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
 *
 */
public interface TickService {
	// https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
	Ticket getTicket(String accessToken, UrlConfig config);
}
