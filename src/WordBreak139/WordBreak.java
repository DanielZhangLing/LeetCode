package WordBreak139;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
        boolean result = false;
        if(null==wordDict||0==wordDict.size()){
            return result;
        }
        List<String> candidate = new ArrayList<String>();
        if(0==s.length())
            return true;
        boolean temp = false;
        for(int i=0; i<s.length(); i++){
            if(wordDict.contains(s.substring(0,i+1)))
                temp = wordBreak(s.substring(i+1), wordDict);
                if(!temp)
                    continue;
                else return temp;
//                candidate.add(s.substring(i+1));
        }
//        for(String elm:candidate)
//            result = result||wordBreak(elm, wordDict);
        return result;
    }
    public static void main(String[] args){
    	String s = "mynameisDaniel";
    	List<String> wordDict = new ArrayList<String>();
    	wordDict.add("my");
    	wordDict.add("name");
    	wordDict.add("is");
    	wordDict.add("Daniel");
    	System.out.println(1&15);
    }
}

