/**
 * 
 */
package cn.aposoft.wechat;

/**
 * @author Jann Liu
 *
 */
public class MediaEntity {
	private String contentType;
	private String filename;
	private Long length;
	private byte[] entity;

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the contentLength
	 */
	public Long getLength() {
		return length;
	}

	/**
	 * @param contentLength
	 *            the contentLength to set
	 */
	public void setLength(Long contentLength) {
		this.length = contentLength;
	}

	/**
	 * @return the entity
	 */
	public byte[] getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(byte[] entity) {
		this.entity = entity;
	}

}
