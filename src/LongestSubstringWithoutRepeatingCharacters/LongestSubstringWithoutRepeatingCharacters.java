package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {
    if(s == null || s.length()==0)
        return 0;
    int l = 0, r = 0, res = 0;
    Set set = new HashSet<Character>();
    for(; l<s.length(); l++){
        while(r<s.length()&&!set.contains(s.charAt(r))){
            res = Math.max(res, r-l+1);
            set.add(s.charAt(r));
            r++;
        }
        set.remove(s.charAt(l));
    }
    return res;
}
public int lengthOfLongestSubstring(String s) {
    if (s.length()==0) return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    for (int i=0, j=0; i<s.length(); ++i){
        if (map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
        }
        map.put(s.charAt(i),i);
        max = Math.max(max,i-j+1);
    }
    return max;
}
}
