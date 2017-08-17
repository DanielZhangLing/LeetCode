package RomantoInteger13;

public class RomantoInteger {
	/*
	 * get number from roman first is smaller than the latter one than it's a subtraction
	 */
	public int romanToInt(String s) {

		int res = 0;
		int n = s.length();
		for (int i = 0; i < n - 1; i++) {
			if (getNum(s.charAt(i)) < getNum(s.charAt(i + 1))) {
				res -= getNum(s.charAt(i));
			} else
				res += getNum(s.charAt(i));
		}
		return res +getNum(s.charAt(n-1));
	}

	public int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
