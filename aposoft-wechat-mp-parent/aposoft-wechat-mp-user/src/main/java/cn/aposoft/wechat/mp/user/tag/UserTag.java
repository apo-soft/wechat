/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag;

import java.io.Serializable;

/**
 * @author Jann Liu
 *
 */
public class UserTag implements Serializable {
	private static final long serialVersionUID = 2390231696272836387L;
	private int id;
	private String name;
	private Integer count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
