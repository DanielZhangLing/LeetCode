package CoinsinaLineII;

public class CoinsinaLineII {
    public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        if(len==0)
            return false;
        if(len==1||len==2)
            return true;
        int[] sum = new int[len+1];
        int[] flag = new int [len+1];
        int[] dp = new int[len+1];
        sum[0] = 0;
        for(int i = 1; i<=len; i++){
            sum[i] = sum[i-1]+ values[len-i];
        }
        dp[0] = 0;
        dp[1] = values[len-1];
        dp[2] = dp[1]+values[len-2];
        for(int i = 3; i<=len; i++){
            dp[i] = Math.max((sum[i]-dp[i-1]),(sum[i]-dp[i-2]));
        }
        return dp[len]>(sum[len]-dp[len]);
        
    }
}
