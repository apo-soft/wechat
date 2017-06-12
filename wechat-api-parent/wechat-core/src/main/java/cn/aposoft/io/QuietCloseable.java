/**
 * 
 */
package cn.aposoft.io;

import java.io.Closeable;

/**
 * 静默关闭接口声明
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface QuietCloseable extends Closeable {
	@Override
	public void close();
}
