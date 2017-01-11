package LongestPalindrome409;

import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
     
    	int res = 0;
    	boolean flag = false;
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	for(int i =0;i<s.length();i++){
    		char c = s.charAt(i);
    		map.put(c, map.getOrDefault(c, 0)+1);
    	}
    	for(char key: map.keySet()){
    		int v = map.get(key);
    		if(v%2 ==0)
    			res+=v;
    		else if(flag ==false){
    			res+=v;
    			flag = true;
    		}
    		else res+=v-1;
    	}
    	return res;
    }
    public int longestPalindrome2(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp-'a']++;
            else uppercase[temp-'A']++;
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        return res == s.length() ? res : res+1;
            
    }
    public int longestPalindrome3(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}
}
