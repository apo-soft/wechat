/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import java.io.Serializable;

/**
 * 素材文件信息
 * 
 * @author Jann Liu
 *
 */
public class MediaContent implements Serializable {
	private static final long serialVersionUID = -3593184285360189467L;
	private byte[] data;
	private String contentType;
	private String fileName;

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
