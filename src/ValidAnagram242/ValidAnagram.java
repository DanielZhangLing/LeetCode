package ValidAnagram242;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
    	if (s==null&&t==null)
    		return true;
    	if (s==null||t==null)
    		return false;
    	int[] alphabet = new int[26];
    	for(int i=0;i<s.length();i++)
    		alphabet[s.charAt(i)-'a']++;
    	for(int i=0;i<t.length();i++)
    		alphabet[t.charAt(i)-'a']--;
    	for (int elm: alphabet){
    		if(elm!=0)
    			return false;
    	}
    	return true;
    		
    }
}
