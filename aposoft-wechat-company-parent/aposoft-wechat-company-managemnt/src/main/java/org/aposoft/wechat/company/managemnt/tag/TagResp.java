/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag;

import cn.aposoft.wechat.WechatResp;

/**
 * 标签管理响应报文
 * 
 * @author Jann Liu
 *
 */
public class TagResp extends WechatResp {
	private static final long serialVersionUID = 9013404813266491290L;
	private Integer tagid;

	/**
	 * @return the tagid
	 */
	public Integer getTagid() {
		return tagid;
	}

	/**
	 * @param tagid
	 *            the tagid to set
	 */
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

}
