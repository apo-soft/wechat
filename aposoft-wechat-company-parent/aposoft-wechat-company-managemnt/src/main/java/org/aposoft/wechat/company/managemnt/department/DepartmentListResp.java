/**
 * 
 */
package org.aposoft.wechat.company.managemnt.department;

import java.util.List;

import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 部门查询列表
 * 
 * @author Jann Liu
 *
 */
public class DepartmentListResp extends WechatResp {
	private static final long serialVersionUID = -4282340102349418176L;
	private List<Department> department;
	/**
	 * @return the department
	 */
	public List<Department> getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
}
