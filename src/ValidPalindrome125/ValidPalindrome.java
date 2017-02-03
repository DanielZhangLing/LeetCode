package ValidPalindrome125;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s.toLowerCase();
		int min = 0, max = s.length() - 1;
		loop: while (max > min) {
			char a = s.charAt(min);
			if (((a - 'a') >= 0 && (a - 'a') < 26)||((a-'0')>=0&&(a-'0')<10)) {
				while (max > min) {
					char b = s.charAt(max);
					if (((b - 'a') >= 0 && (b - 'a') < 26)||((b-'0')>=0&&(b-'0')<10)) {
						if (a == b) {
							min++;
							max--;

							continue loop;
						} else
							return false;
					} else {
						max--;
						continue;
					}
				}
			} else {
				min++;
				continue;
			}

		}
		return true;
	}
	
	public static void test(String data){
		
		System.out.println(isPalindrome(data));
	}
	
	public static void main(String[] args){
		test("0p");
	}
}
