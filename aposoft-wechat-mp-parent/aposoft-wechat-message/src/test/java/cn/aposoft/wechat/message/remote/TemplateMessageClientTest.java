/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.mp.message.TemplateMessage;
import cn.aposoft.wechat.mp.message.TemplateMessage.TemplateParam;
import cn.aposoft.wechat.mp.message.remote.MessageResp;
import cn.aposoft.wechat.mp.message.remote.TemplateMessageClient;

/**
 * 模板消息客户端测试
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class TemplateMessageClientTest {
	static TemplateMessageClient client = new TemplateMessageClient();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
		client.close();
	}

	/**
	 * <pre>
	 * {
	"template_list":[
	    {
	        "template_id":"zw9lgptQReQQpJoofaPucstJSFi7bUmJ_26I1rBAgkk",
	        "title":"系统故障通知",
	        "primary_industry":"",
	        "deputy_industry":"",
	        "content":"{{first.DATA}} 业务： {{business.DATA}} 系统：{{system.DATA}} IP : {{ip.DATA}} 故障现象：{{performance.DATA}} 故障时间：{{time.DATA}} {{remark.DATA}}",
	        "example":""
	    },
	    {
	        "template_id":"GVNDCaelOcnviNrP5NNA9uc4sBMnCC4eRSiDHNotCIM",
	        "title":"摘要模板",
	        "primary_industry":"",
	        "deputy_industry":"",
	        "content":"摘要：{{digest.DATA}}",
	        "example":""
	    }
	]
	}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testgetTemplateList() throws RemoteException, AccessTokenException {
		System.out.println(client.getTemplateList(accessTokenService.getAccessToken().getAccess_token()));
	}

	/**
	 * {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteTemplate() throws RemoteException, AccessTokenException {
		System.out
				.println(JSON.toJSONString(client.deleteTemplate(accessTokenService.getAccessToken().getAccess_token(),
						"GVNDCaelOcnviNrP5NNA9uc4sBMnCC4eRSiDHNotCIM")));

	}

	// BE57iEeATYm4O5qGJcszZxsSSHS7ANkwHkTiFakaVu0
	@Ignore
	@Test
	public void testSendTemplateMessage() throws RemoteException, AccessTokenException {
		TemplateMessage msg = new TemplateMessage();
		msg.setTouser("ojqOLxLh0480oz5gqHqLgzRgCLHM");
		msg.setTemplate_id("zw9lgptQReQQpJoofaPucstJSFi7bUmJ_26I1rBAgkk");
		Map<String, TemplateParam> data = new HashMap<>();
		data.put("first", new TemplateParam("系统运行报警通知", "#173177"));
		data.put("business", new TemplateParam("美借", "#173177"));
		data.put("system", new TemplateParam("JIE-API", "#173177"));
		data.put("ip", new TemplateParam("10.143.92.93", "#173177"));
		data.put("performance", new TemplateParam("调用闪银接口连续报错.", "#173177"));
		data.put("time", new TemplateParam(new Date().toString(), "#173177"));
		data.put("remark", new TemplateParam("请联系相关人员处理！", "#FF0000"));
		// msg.setUrl(null);
		msg.setData(data);
		MessageResp resp = client.sendTemplateMessage(accessTokenService.getAccessToken().getAccess_token(), msg);
		System.out.println(JSON.toJSONString(resp));
	}
}
