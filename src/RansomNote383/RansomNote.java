package RansomNote383;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
     
    	char[] r = ransomNote.toCharArray();
    	char[] m = magazine.toCharArray();
    	int[] temp = new int[26];
    	for(int elm : m){
    		temp[elm-'a']++;
    	}
    	for(int elm: r){
    		if(temp[elm-'a']>0)
    			temp[elm-'a']--;
    		else return false;
    	}
    	return true;
    }
}
