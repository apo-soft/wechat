/**
 * 
 */
package org.aposoft.wechat.company.managemnt.department;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 部门操作响应
 * 
 * @author Jann Liu
 *
 */
public class DepartmentResp extends WechatResp {
	private static final long serialVersionUID = 4323349584533400493L;
	private Integer id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
