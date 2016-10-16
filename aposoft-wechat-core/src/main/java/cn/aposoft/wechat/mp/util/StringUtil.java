package cn.aposoft.wechat.mp.util;

public class StringUtil {
	private StringUtil() {

	}

	public static boolean isBlank(Object... input) {
		int len;
		for (Object in : input) {
			if (in == null||(len=in.toString().length())==0) {
				return true;
			}
		}
		return false;
	}
}
