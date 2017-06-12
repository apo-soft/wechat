/**
 * 
 */
package cn.aposoft.wechat.ticket.remote;

import cn.aposoft.io.QuietCloseable;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.ticket.Ticket;

/**
 * @author Jann Liu
 *
 */
public interface TicketClient extends QuietCloseable {
	/**
	 * 访问客户端
	 * 
	 * @param accessToken
	 * @param type
	 *            票据类型
	 * @return 票据响应
	 * @throws RemoteException
	 */
	TicketResp getTicket(final String accessToken, final Ticket.Type type) throws RemoteException;
}
