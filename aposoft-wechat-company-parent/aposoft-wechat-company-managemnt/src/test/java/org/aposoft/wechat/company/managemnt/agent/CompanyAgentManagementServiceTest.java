/**
 * 
 */
package org.aposoft.wechat.company.managemnt.agent;

import java.io.IOException;

import org.aposoft.wechat.company.managemnt.agent.impl.AposoftCompanyAgentManagementService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;

/**
 * @author Jann Liu
 *
 */
public class CompanyAgentManagementServiceTest {
	static final CompanyAgentManagementService service = new AposoftCompanyAgentManagementService();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		HttpClient.setLogEnabled(true);
		accessTokenService = AccessTokenServiceFactory.getCompanyAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenService.close();
	}

	/**
	 * <pre>
	 * {
	 * "errcode":0,
	 * "errmsg":"ok",
	 * "agentid":"1","allow_partys":{"partyid":[1]},
	 * "allow_tags":{"tagid":[]},
	 * "allow_userinfos":{"user":[]},
	 * "chat_extension_url":"",
	 * "close":"0",
	 * "description":"用于发送报警通知",
	
	 * "isreportenter":0,
	 * "isreportuser":1,
	 * "name":"国美金控系统监控报警",
	 * "redirect_domain":"",
	 * "report_location_flag":0,
	 * "round_logo_url":"http://mmbiz.qpic.cn/mmbiz_png/TViaAHqibUdjcda6ogWtAwBGibtVoC1D7FD4rL1Jego0Q6iaYBiaLrv4ibQRwicFDS6COTzxZfKgMXfeCVmt7lhOVEUXQ/0",
	 * "square_logo_url":"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5OC0bJAOIoZHDo8vW9Y0cEefS9VjdBTXs0oBOuqNRSMQ/0",
	 * "type":1}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetAgent() throws RemoteException, AccessTokenException {
		AgentResp resp = service.getAgent(accessTokenService.getAccessToken().getAccess_token(), "1");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	 * 		{
	 * 		"agentlist":[
		 * 		{	"agentid":"1",
		 * 			"name":"国美金控系统监控报警",
		 * 			"round_logo_url":"http://mmbiz.qpic.cn/mmbiz_png/TViaAHqibUdjcda6ogWtAwBGibtVoC1D7FD4rL1Jego0Q6iaYBiaLrv4ibQRwicFDS6COTzxZfKgMXfeCVmt7lhOVEUXQ/0",
		 * 			"square_logo_url":"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5OC0bJAOIoZHDo8vW9Y0cEefS9VjdBTXs0oBOuqNRSMQ/0"
		 * 		},{
		 * 			"agentid":"2",
		 * 			"name":"jenkins",
		 * 			"round_logo_url":"http://mmbiz.qpic.cn/mmbiz_png/hXGHyrWV2rLePuONvaTLuVGG7bKaG3tYCoTvibrdIbIicKv9G5stib8dqUlj7Ldib8Vq3ncl63QnaGnGx3TwiamBoFg/0",
		 * 			"square_logo_url":"http://wx.qlogo.cn/mmhead/Q3auHgzwzM56BEicL0FiaY3GRs0HpvafEpwQpbqlM6Kts5N3Bf9t9dWg/0"
		 * 		}],
	 * 		"errcode":0,
	 * 		"errmsg":"ok"}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetAgentList() throws RemoteException, AccessTokenException {
		AgentListResp resp = service.getAgentList(accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}
}
