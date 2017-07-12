package CoinsinaLine;

public class CoinsinaLine {
    public boolean firstWillWin(int n) {
        // write your code here
        if(n==1||n==2)
            return true;
        if(n==0)
            return false;
        int[] dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n; i++){
            if(dp[i]==-1){
                if(dp[i-1]==0||dp[i-2]==0){
                    dp[i] = 1;
                }else{
                    dp[i] = 0;
                }
            }
        }
        return dp[n]==1? true:false;
    }
}
