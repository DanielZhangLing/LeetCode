package LetterCombinationsofaPhoneNumber17;

/**
 * Created by LingZhang on 5/14/17.
 */
public class LetterCombinationsofaPhoneNumber {
	
	/*
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
    public static List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length()==0) return result;

        result.add("");
        for (int i=0; i<digits.length(); i++)
            result = combine(digitletter[digits.charAt(i)-'0'],result);

        return result;
    }

    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i=0; i<digit.length(); i++)
            for (String x : l)
                result.add(x+digit.charAt(i));

        return result;
    }
}
