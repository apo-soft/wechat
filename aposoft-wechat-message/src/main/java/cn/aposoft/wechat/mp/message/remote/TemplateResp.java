/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * <pre>
 *  {
           "errcode":0,
           "errmsg":"ok",
           "template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"
       }
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class TemplateResp extends WechatResp {
	private static final long serialVersionUID = 3097140954163545866L;
	private String template_id;

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

}
