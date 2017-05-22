/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

/**
 * 素材列表请求参数
 * 
 * @author Jann Liu
 *
 */
public class MediaListReq {
	/**
	 * 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * 
	 * @see MediaType
	 */
	private String type;
	/**
	 * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 */
	private Integer offset;
	/**
	 * 返回素材的数量，取值在1到20之间
	 */
	private Integer count;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
