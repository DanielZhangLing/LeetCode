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
}
