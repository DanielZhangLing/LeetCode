package MinimumWindowSubstring76;

public class MinimumWindowSubstring {
    public String minWindow2(String s, String t) {
        int[] map = new int[256];
        int l = 0 , r = 0 , res = Integer.MAX_VALUE, cnt = t.length(), start = 0 , end = 0;
        for(char c: t.toCharArray()){
            map[c]++;
        }
        while(cnt==0||r<s.length()){//first option is if find enough character cnt==0 l keep moving try to find smaller, only charcter in t will >=0, because l is iterating added character
            if(cnt==0){
                if(map[s.charAt(l)]>=0)
                    cnt++;
                map[s.charAt(l)]++;
                l++;
            }
          //necessary number havent meet 0, keep adding new character
            if(r<s.length()&&cnt!=0){
                if(map[s.charAt(r)]>=1)
                    cnt--;
                map[s.charAt(r)]--;
                r++;
            }
            if(cnt==0&&r-l<res){// update minimum
                res = r-l;
                start = l;
                end = r;
            }
        }
        return res == Integer.MAX_VALUE? "":s.substring(start,end);
    }
    
    
    public static String minWindow(String source, String target) {
        // write your code
        int i=0 ,j=0 ;
        int len = source.length();
        int resLen = Integer.MAX_VALUE;
        String res = new String();
        int[] targetCount = new int[256];
        int[] sourceCount = new int[256];
        for(int k = 0; k<target.length(); k++){
            targetCount[target.charAt(k)]++;
        }
        
        for(;i<len;i++){
            while(j<len && !valid(sourceCount, targetCount)){
                    sourceCount[source.charAt(j)]++;
                    j++;
                }
                if(valid(sourceCount, targetCount)){
                    if(resLen>j-i){
                        resLen = j-i;
                        res = source.substring(i, j);
                    }
                }
                sourceCount[source.charAt(i)]--;
                
        }
        
        return resLen==Integer.MAX_VALUE? "":res;
    }
    
    public static boolean valid(int[] sourceCount, int[] targetCount){
        for(int i=0; i<256; i++){
            if(sourceCount[i]<targetCount[i])
                return false;
        }
        return true;
    }
    
    public static void main(String args[]){
    	String s1="abc";
    	String s2="a";
    	minWindow(s1,s2);
    }
    
}
