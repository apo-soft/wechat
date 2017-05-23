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

	/**
	 * 对象空字符校验
	 * 
	 * @param input
	 *            传入参数
	 * @return 是否存在空字符串
	 */
	public static boolean isNull(Object... input) {
		for (Object in : input) {
			System.out.println(in);

			if (in == null) {
				return true;
			} else {
				System.out.println(in.getClass());
			}
		}
		return false;
	}
}
