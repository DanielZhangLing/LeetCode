package ZigZagConversion6;

/**
 * Created by LingZhang on 5/31/17.
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s.equals(""))
			return s;
		int len = s.length();
		char[] str = s.toCharArray();
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();
		int i = 0;
		while (i < len) {
			for (int k = 0; k < numRows && i < len; k++) {
				sb[k].append(str[i++]);
			}
			for (int k = numRows - 2; k > 0 && i < len; k--) {
				sb[k].append(str[i++]);
			}
		}
		StringBuffer res = new StringBuffer();
		for (int j = 0; j < numRows; j++) {
			res.append(sb[j]);
		}
		return res.toString();
	}

	// toCharArray();
	// 引用类型数组，每一个都要new
	// Java provides the StringBuffer and String classes, and the String class
	// is used to manipulate character strings that cannot be changed. Simply
	// stated, objects of type String are read only and immutable. The
	// StringBuffer class is used to represent characters that can be modified.
	// buffer is quicker
	// it’s synchronized
}
