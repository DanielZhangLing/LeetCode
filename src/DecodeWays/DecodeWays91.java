package DecodeWays;

public class DecodeWays91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    public static int numDecodings(String s) {
        int res = 0;
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return res;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=s.length(); i++){
            if(s.charAt(i-2)!='1'&& s.charAt(i-1)=='0'){
                return 0;
            }
            if((s.charAt(i-2)=='2'&& s.charAt(i-1)<'7'&&s.charAt(i-1)>'0')||(s.charAt(i-2)=='1'&&s.charAt(i-1)!='0')){
                dp[i] = dp[i-2] + dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
        
        
    }
    public static void main(String[] args){
    	String a  = "110";
    	int n = a.length();
    	System.out.println(numDecodings(a));
    }
}
