package LetterCombinationsofaPhoneNumber17;

/**
 * Created by LingZhang on 5/14/17.
 */
public class LetterCombinationsofaPhoneNumber {
	
	/*
	 * o(m^n)
	 * queue first in first out q is linkedlist
	 */
    public List<String> letterCombinations(String digits) {
        if(digits == null||digits.length()==0)
            return new ArrayList<String>();
        String[] phone= {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> q= new LinkedList<String>();
        q.add("");
        for(int i=0; i<digits.length(); i++){
            String p =  phone[digits.charAt(i)-'0'];
            int size = q.size();
            for(int j = 0; j<size; j++){
                String cur = q.poll();
                for(int k=0;k<p.length(); k++){
                    q.add(cur+p.charAt(k));
                }
            }
        }
        return q;
    }
	/*
	 * 这里算是递归，每次加上一个数字
	 */
    	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    	public List<String> letterCombinations(String digits) {
    		List<String> ret = new LinkedList<String>();
    		combination("", digits, 0, ret);
    		return ret;
    	}
    
    	private void combination(String prefix, String digits, int offset, List<String> ret) {
    		if (offset >= digits.length()) {
    			ret.add(prefix);
    			return;
    		}
    		String letters = KEYS[(digits.charAt(offset) - '0')];
    		for (int i = 0; i < letters.length(); i++) {
    			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
    		}
    	}
}
