package ImplementstrStr28;

public class ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        if(h<n)
            return -1;
        if(n==0)
            return 0;
        for(int i = 0 ; i<= h-n; i++){
            for(int j = 0 ; j<n; j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)) break;
                if(j == n-1) return i;
            }
        }
        return -1;
    }
    
    for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          if (j == needle.length()) return i;
          if (i + j == haystack.length()) return -1;
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
}
