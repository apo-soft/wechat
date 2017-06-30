/**
 * 
 */
package cn.aposoft.wechat.ticket.remote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.ticket.Ticket.Type;

/**
 * 默认Ticket客户端
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DefaultTicketClientTest {

	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
	}

	/**
	 * <pre>
	 * {
	 * "access_token":
	 * "LPvhG4gw1RctDesgQ86iphMkHqw_jQmy6fsFE4PSHcguYmky0LteA6T5GenYR4ZxmCzoosoKikxIYlNN6QVx_ZZ33WO8hIRGJ6fITGTdII9vlTPyqsOO1yn-b02h-gLYHRLhABAMWQ",
	 * "expires_in":
	 * 7200
	 * }
	 * </pre>
	 * 
	 * <pre>
	 * {
	 * "errcode":0,
	 * "errmsg":"ok",
	 * "ticket":"kgt8ON7yVITDhtdwci0qeWlxqxjPRRxknAuh0OXJIDAXvpdchWaeTJj--BK1X__gbpmvpohOgBxEV-qT4ob4hw",
	 * "expires_in":7200
	 * }
	 * </pre>
	 * 
	 * @throws RemoteException
	 */
	// @Ignore
	@Test
	public void testGetTicket() throws RemoteException {
		try (DefaultTicketClient client = new DefaultTicketClient();) {

			TicketResp ticket = client.getTicket(accessTokenService.getAccessToken().getAccess_token(), Type.jsapi);
			assertNotNull(ticket);
			assertEquals(7200, ticket.getExpires_in());
		}
	}

}
