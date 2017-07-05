/**
 * 
 */
package cn.aposoft.wechat.access;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.aposoft.framework.concurrent.AsyncRefreshService;
import cn.aposoft.framework.concurrent.RefreshWorker;
import cn.aposoft.framework.concurrent.SelfRefreshWorker;
import cn.aposoft.framework.io.QuietCloseable;

/**
 * 默认异步刷新服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
@Service
public class DefaultAsyncRefreshService implements AsyncRefreshService, QuietCloseable {
	private static final Logger logger = LoggerFactory.getLogger(DefaultAsyncRefreshService.class);
	// 刷新服务工作实例
	private RefreshWorker refreshWorker;

	private final ExecutorService executor = Executors.newSingleThreadExecutor();

	/**
	 * @return the refreshWorker
	 */

	public RefreshWorker getRefreshWorker() {
		return refreshWorker;
	}

	/**
	 * auto 注入Worker
	 * 
	 * @param refreshWorker
	 *            the refreshWorker to set
	 */
	@Autowired
	public void setRefreshWorker(RefreshWorker refreshWorker) {
		this.refreshWorker = refreshWorker;
		if (refreshWorker instanceof SelfRefreshWorker) {
			((SelfRefreshWorker) refreshWorker).setRefreshService(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.framework.io.QuietCloseable#close()
	 */
	@PreDestroy
	@Override
	public void close() {
		executor.shutdown();
	}

	@Scheduled(fixedRate = 1000 * 60 * 5)
	void confirm() {

	}

	// 异步执行任务
	@Override
	public void execute(Object context) {
		try {
			executor.execute(new Task(context));
		} catch (RuntimeException e) {
			logger.error("async task submitted error.", e);
		}
	}

	private class Task implements Runnable {
		private Object context;

		Task(Object context) {
			this.context = context;
		}

		@Override
		public void run() {
			refreshWorker.refresh(context);
		}
	}
}
