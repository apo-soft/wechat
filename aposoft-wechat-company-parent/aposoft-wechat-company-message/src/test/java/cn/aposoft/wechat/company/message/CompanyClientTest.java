/**
 * 
 */
package cn.aposoft.wechat.company.message;

import org.junit.AfterClass;

import cn.aposoft.wechat.company.common.CompanyAccessTokenClient;
import cn.aposoft.wechat.company.message.impl.AposoftCompanyMessageService;

/**
 * @author Jann Liu
 *
 */
public class CompanyClientTest {

	static final CompanyMessageService service = new AposoftCompanyMessageService();
	static final CompanyAccessTokenClient client = new CompanyAccessTokenClient();

	@AfterClass
	public static void dispose() {
		service.close();
		client.close();
	}
}
