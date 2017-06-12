/**
 * 
 */
package cn.aposoft.wechat.mp.message;

import java.io.Serializable;
import java.util.Map;

/**
 * 模板消息
 * 
 * @author Jann Liu
 *
 */
public class TemplateMessage implements Serializable {
	private static final long serialVersionUID = 5646878439477024869L;
	/**
	 * 黑色 默认颜色
	 */
	public static final String DEFAULT_COLOR = "#000000";
	/**
	 * 红色
	 */
	public static final String RED_COLOR = "#FF0000";
	// "touser":"OPENID",
	// "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
	// "url":"http://weixin.qq.com/download",
	private String touser;
	private String template_id;
	private String url;
	private Object miniprogram;
	private Map<String, TemplateParam> data;

	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}

	/**
	 * @param touser
	 *            the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id
	 *            the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the miniprogram
	 */
	public Object getMiniprogram() {
		return miniprogram;
	}

	/**
	 * @param miniprogram
	 *            the miniprogram to set
	 */
	public void setMiniprogram(Object miniprogram) {
		this.miniprogram = miniprogram;
	}

	/**
	 * @return the data
	 */
	public Map<String, TemplateParam> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Map<String, TemplateParam> data) {
		this.data = data;
	}

	/**
	 * 微信小程序
	 *
	 */
	public static class Miniprogram implements Serializable {
		private static final long serialVersionUID = -527498572138635768L;
		// "appid":"xiaochengxuappid12345",
		private String appid;
		// "pagepath":"index?foo=bar"
		private String pagepath;

		/**
		 * @return the appid
		 */
		public String getAppid() {
			return appid;
		}

		/**
		 * @param appid
		 *            the appid to set
		 */
		public void setAppid(String appid) {
			this.appid = appid;
		}

		/**
		 * @return the pagepath
		 */
		public String getPagepath() {
			return pagepath;
		}

		/**
		 * @param pagepath
		 *            the pagepath to set
		 */
		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}

	}

	/**
	 * 模板参数
	 * 
	 */
	public static class TemplateParam implements Serializable {
		private static final long serialVersionUID = 9074315707696508981L;
		// "value":"巧克力",
		private String value;
		// "color":"#173177"
		private String color;

		public TemplateParam(String value, String color) {
			this.value = value;
			this.color = color;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}

		/**
		 * @param color
		 *            the color to set
		 */
		public void setColor(String color) {
			this.color = color;
		}

	}
}
