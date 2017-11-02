package DecodeWays91;

/**
 * Created by LingZhang on 5/19/17.
 */
public class DecodeWays {
	
	
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
            if(first >= 1 && first <= 9) {// treat the new digit a single number
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {// treat the new digit combine with the last digit
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    
	//dp
    public int numDecodings(String s) {
        if(s ==null||s.length()==0)
            return 0;
        int len = s.length();
        int res = 0;
        int[] dp = new int[2];
        dp[0] = 1;//remember this is 1
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i<len+1; i++){
            int cur = s.charAt(i-1)-'0';
            int prev = s.charAt(i-2)-'0';
            int num = cur+prev*10;

            if(num==10||num==20){//case 10, 20
                dp[i%2] = dp[(i-2)%2];
            }
            else if(num>10&&num<=26){// 11-26
                dp[i%2] = dp[(i-1)%2]+dp[(i-2)%2];
            }
            else if(cur!=0){//1-9 else
                dp[i%2] = dp[(i-1)%2];
            }
            else{// only write when use%
                dp[i%2] = 0;
            }
        }
//        if(first >= 1 && first <= 9) {
//            dp[i] += dp[i-1];  
//         }
//         if(second >= 10 && second <= 26) {
//             dp[i] += dp[i-2];
//         }
        return dp[len%2];
    }
}
