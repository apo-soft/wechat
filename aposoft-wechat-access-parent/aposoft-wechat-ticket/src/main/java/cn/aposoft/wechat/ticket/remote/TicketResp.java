/**
 * 
 */
package cn.aposoft.wechat.ticket.remote;

import java.util.Date;

import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.ticket.Ticket;

/**
 * Ticket客户端
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class TicketResp extends WechatResp implements Ticket {
	private static final long serialVersionUID = -491033865705015375L;
	private Type type;
	private String ticket;
	private int expires_in;
	private Date refreshTime;

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @param refreshTime
	 *            the refreshTime to set
	 */
	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getTicket() {
		return ticket;
	}

	@Override
	public int getExpires_in() {
		return expires_in;
	}

	@Override
	public Date getRefreshTime() {
		return refreshTime;
	}

}
