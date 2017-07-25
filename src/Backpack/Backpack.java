package Backpack;

public class Backpack {
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i = 0; i<=m; i++){
            dp[0][i] = false;
        }
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                dp[i][j] = dp[i-1][j];
                if(j-A[i-1]>=0 &&  dp[i-1][j-A[i-1]]){
                    dp[i][j] = true;
                }
            }
        }
        for(int i = m; i>=0; i--){
            if(dp[n][i])
                return i;
        }
        return 0 ;
        
    }
}
