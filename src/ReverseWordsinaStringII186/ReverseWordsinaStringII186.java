package ReverseWordsinaStringII186;

public class ReverseWordsinaStringII186 {
	public void reverseWords(char[] s) {
		// Three step to reverse
		// 1, reverse the whole sentence
		reverse(s, 0, s.length - 1);
		// 2, reverse each word
		int start = 0;
		int end = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}
		// 3, reverse the last word, if there is only one word this will solve
		// the corner case
		reverse(s, start, s.length - 1);
	}

	public void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

	public void reverseWords(char[] s) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] != ' ')
				stack.push(s[i]);
			else {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			}

		}
		if (s != null && s.length > 0) {
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			String res = sb.toString();
			char[] r = res.toCharArray();
			for (int i = 0; i < r.length; i++) {
				s[i] = r[i];
			}
		}

	}
}
