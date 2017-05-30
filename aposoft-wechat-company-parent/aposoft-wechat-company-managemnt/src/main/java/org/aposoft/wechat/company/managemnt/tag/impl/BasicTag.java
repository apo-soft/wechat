package org.aposoft.wechat.company.managemnt.tag.impl;

import org.aposoft.wechat.company.managemnt.tag.Tag;

/**
 * 标签简单实现
 * 
 * @author Jann Liu
 *
 */
public class BasicTag implements Tag {

	private String tagname;
	private Integer tagid;

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	@Override
	public String getTagname() {
		return tagname;
	}

	@Override
	public Integer getTagid() {
		return tagid;
	}

}
