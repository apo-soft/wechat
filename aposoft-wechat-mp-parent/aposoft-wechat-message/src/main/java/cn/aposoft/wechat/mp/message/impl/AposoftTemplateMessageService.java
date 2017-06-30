/**
 * 
 */
package cn.aposoft.wechat.mp.message.impl;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.mp.message.TemplateMessageService;
import cn.aposoft.wechat.mp.message.remote.TemplateMessageClient;

/**
 * 模板消息服务
 * 
 * @author Jann Liu
 *
 */
public class AposoftTemplateMessageService implements TemplateMessageService {
	final TemplateMessageClient client = new TemplateMessageClient();

	@Override
	public void close() {
		client.close();
	}

	@Override
	public String getTemplateList(String accessToken) throws RemoteException {
		return client.getTemplateList(accessToken);
	}

}
