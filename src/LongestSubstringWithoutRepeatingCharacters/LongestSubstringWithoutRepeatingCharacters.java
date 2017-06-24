package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		// write your code here
		if (0 == s.length())
			return 0;
		int i = 0, j = 0;
		int len = s.length();
		int res = Integer.MIN_VALUE;
		int[] map = new int[256];
		for (; i < len; i++) {
			while (j < len && 0 == map[s.charAt(j)]) {
				map[s.charAt(j)] = 1;
				j++;
			}
			res = Math.max(res, j - i);
			map[s.charAt(i)] = 0;
		}
		return res == Integer.MIN_VALUE ? -1 : res;
	}
}
