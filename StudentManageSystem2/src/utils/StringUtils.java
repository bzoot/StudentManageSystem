package utils;
/** 
 * @author  Mualim
 * @date ����ʱ�䣺2017-3-29 ����4:48:15 
 * @version 1.0 
 * @parameter  
 * @return  
 */
public class StringUtils {
	/**
	 * ���Դ�Сд��startsWith
	 * 
	 * @param prefix
	 * @param str
	 * @return boolean
	 */
	public static boolean isStartWithIgnoreCase(String prefix, String str) {
		int length = prefix.length();
		if (length > str.length()) {
			return false;
		} else if (prefix.equalsIgnoreCase(str.substring(0, length))) {
			return true;
		} else {
			return false;
		}
	}
}
