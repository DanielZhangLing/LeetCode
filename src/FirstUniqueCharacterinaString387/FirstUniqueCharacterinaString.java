package FirstUniqueCharacterinaString387;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        
    	int[] times = new int[26];
    	for(int i=0;i<s.length();i++){
    		times[s.charAt(i)-'a']++;
    	}
    	for(int i=0;i<s.length();i++){
    		if(times[s.charAt(i)-'a']==1)
    			return i;
    	}
    	return -1;
    }
}
