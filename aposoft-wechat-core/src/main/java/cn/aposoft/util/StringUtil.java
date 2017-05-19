package cn.aposoft.util;

public class StringUtil {
	private StringUtil() {

	}

	/**
	 * 对象空字符校验
	 * 
	 * @param input
	 *            传入参数
	 * @return 是否存在空字符串
	 */
	public static boolean isBlank(Object... input) {
		for (Object in : input) {
			if (in == null || (in.toString().length()) == 0) {
				return true;
			}
		}
		return false;
	}
}
