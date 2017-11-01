package OneEditDistance161;

public class OneEditDistance161 {
	/*
	 * There're 3 possibilities to satisfy one edit distance apart: 
	 * 
	 * 1) Replace 1 char:
	 	  s: a B c
	 	  t: a D c
	 * 2) Delete 1 char from s: 
		  s: a D  b c
		  t: a    b c
	 * 3) Delete 1 char from t
		  s: a   b c
		  t: a D b c
	 */
	public class Solution {
	    public boolean isOneEditDistance(String s, String t) {
	        int slen = s.length();
	        int tlen = t.length();
	        // abcsef   and   abcsefffffffffffff 
	        if(Math.abs(slen-tlen)>1)
	            return false;
	        for(int i = 0; i <Math.min(slen,tlen);i++){
	            if(s.charAt(i) != t.charAt(i)){
	                if(slen == tlen)
	                    return s.substring(i+1).equals(t.substring(i+1));
	                else if(slen<tlen)
	                    return s.substring(i).equals(t.substring(i+1));
	                else 
	                    return t.substring(i).equals(s.substring(i+1));
	            }
	        }
	        return Math.abs(slen-tlen)==1;// previous are the same, get rid of aaaaa, aaaaa same input
	    }
}
