/**
 * 
 */
package org.aposoft.wechat.company.managemnt.department;

import java.io.Serializable;

/**
 * 
 * <pre>
 * {
   	"id": 2,
   	"name": "广州研发中心",
   	"parentid": 1,
   	"order": 1
	}
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class Department implements Serializable {
	private static final long serialVersionUID = -7655940850617364542L;
	private Integer id;
	private Integer order;
	private Integer parentid;
	private String name;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * @return the parentid
	 */
	public Integer getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
