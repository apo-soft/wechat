/**
 * 
 */
package cn.aposoft.wechat.config;

/**
 * 刷新配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicRefreshConfig implements RefreshConfig {
	private static final long serialVersionUID = -7079886841642376996L;

	private int asyncRefreshThreshold = 1800;

	private int holdonThreshold = 5;

	private int retryTimes = 1;

	public BasicRefreshConfig() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.config.RefreshConfig#getExpiredThreshold()
	 */
	@Override
	public int getAsyncRefreshThreshold() {
		return asyncRefreshThreshold;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.config.RefreshConfig#getHoldonThreshold()
	 */
	@Override
	public int getHoldonThreshold() {
		return holdonThreshold;
	}

	/**
	 * @param asyncRefreshThreshold
	 *            the asyncRefreshThreshold to set
	 */
	public void setAsyncRefreshThreshold(int asyncRefreshThreshold) {
		this.asyncRefreshThreshold = asyncRefreshThreshold;
	}

	/**
	 * @param holdonThreshold
	 *            the holdonThreshold to set
	 */
	public void setHoldonThreshold(int holdonThreshold) {
		this.holdonThreshold = holdonThreshold;
	}

	/**
	 * @return the retryTimes
	 */
	@Override
	public int getRetryTimes() {
		return retryTimes;
	}

	/**
	 * @param retryTimes
	 *            the retryTimes to set
	 */
	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}

}
