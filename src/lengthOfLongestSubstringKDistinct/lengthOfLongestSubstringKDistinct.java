package lengthOfLongestSubstringKDistinct;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int len = s.length();
        int i=0, j=0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        
        for(;i<len;i++){
            while(j<len){
                char c = s.charAt(j);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
                else{
                    if(map.size()==k)
                        break;
                     map.put(c,1);
                }

                j++;
            }
            
            res = Math.max(res,j-i);
            
            char c2 = s.charAt(i);
            if(map.containsKey(c2)){
            if(map.get(c2)>1){
                map.put(c2,map.get(c2)-1);
            }
            else
                map.remove(c2);
            }
        }
        
        return res;
    }
}
