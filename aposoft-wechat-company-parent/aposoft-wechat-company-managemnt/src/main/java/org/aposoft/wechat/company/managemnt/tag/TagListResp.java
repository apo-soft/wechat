/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag;

import java.util.List;

import org.aposoft.wechat.company.managemnt.tag.impl.BasicTag;

import cn.aposoft.wechat.mp.WechatResp;

/**
 * 标签列表响应
 * 
 * @author Jann Liu
 *
 */
public class TagListResp extends WechatResp {
	private static final long serialVersionUID = 4720391812902914042L;

	private List<BasicTag> taglist;

	/**
	 * @return the taglist
	 */
	public List<BasicTag> getTaglist() {
		return taglist;
	}

	/**
	 * @param taglist
	 *            the taglist to set
	 */
	public void setTaglist(List<BasicTag> taglist) {
		this.taglist = taglist;
	}

}
