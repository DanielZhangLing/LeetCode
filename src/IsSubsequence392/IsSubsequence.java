package IsSubsequence392;

import java.util.ArrayList;

public class IsSubsequence {

//    public boolean isSubsequence(String s, String t) {
//        
//    	ArrayList<Integer>[] al = new ArrayList[26];
//    	int count = -1;
//    	
//    	for(int i = 0; i<t.length(); i++){
//    		int index = t.charAt(i)-'a';
//    		if (al[index]==null)
//    			al[index] = new ArrayList<Integer>();
//    		al[index].add(i);
//    	}
//    	loop: for(int i=0; i<s.length();i++){
//    		int index = s.charAt(i)-'a';
//    		if(al[index]==null)
//    			return false;
//    		for(int j=0; j<al[index].size(); j++){
//    			if(al[index].get(j)>count){
//    				count = al[index].get(j);
//    				continue loop;
//    			}
//    		}
//    		return false;
//    	}
//    	return true;
//    		
//    }
    public boolean isSubsequence2(String s, String t) {
    
    	if(s.length()==0)
    		return true;
    	int indexS = 0;
    	int indexT = 0;
    	while(indexT<t.length()){
    		if(s.charAt(indexS)==t.charAt(indexT)){
    			indexS++;
        		if(indexS == s.length())
        			return true;
    		}
    		indexT++;
    }
    	return false;
    }
}
