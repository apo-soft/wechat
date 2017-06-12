/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

/**
 * 发送过滤器
 * 
 * @author Jann Liu
 *
 */
public class Filter {
	private Boolean is_to_all;
	private Integer tag_id;

	/**
	 * @return the is_to_all
	 */
	public Boolean getIs_to_all() {
		return is_to_all;
	}

	/**
	 * @param is_to_all
	 *            the is_to_all to set
	 */
	public void setIs_to_all(Boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	/**
	 * @return the tag_id
	 */
	public Integer getTag_id() {
		return tag_id;
	}

	/**
	 * @param tag_id
	 *            the tag_id to set
	 */
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}

}
