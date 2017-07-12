package StoneGame;

public class StoneGame {
    public int stoneGame(int[] A) {
        // Write your code here
        if(null == A || 0== A.length)
            return 0;
        
        int n = A.length;
        
        //Initialize
        int[][] dp = new int[n][n];
        int[][] flag = new int[n][n];
        int[][] sum = new int[n][n];
        
        for(int i = 0; i<n ; i++){
            dp[i][i] = 0;
        }
        
        for(int i = 0; i<n; i++){
            sum[i][i] = A[i];
            for(int j = i+1 ; j<n; j++){
                sum[i][j] = sum[i][j-1]+A[j];
            }
        }
        
        return search(0, n-1,dp,flag,sum);
    }
    
    public int search(int l, int r, int[][] dp, int[][] flag, int[][] sum){
        
        if(flag[l][r]==1)
            return dp[l][r];
        
        if(l==r){
            flag[l][r] = 1;
            return 0;
        }
        
        dp[l][r] = Integer.MAX_VALUE;
        for(int i = l; i<r; i++){
            dp[l][r] = Math.min(dp[l][r], (search(l,i,dp,flag,sum)+search(i+1,r,dp,flag,sum)+sum[l][r]));
        }
        
        flag[l][r] = 1;
        return dp[l][r];
    }
}
