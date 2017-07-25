package BackpackII;

public class BackpackII {
	/*
	 * • 状态 State
• f[i][j] 表示前i个物品当中选一些物品组成容量为j的最大价值
• 方程 Function
• f[i][j] = max(f[i-1][j], f[i-1][j-A[i-1]] + V[i-1]);
• 初始化 Intialization
• f[0][0]=0;
• 答案 Answer
• f[n][s]
• O(n*s)

	 */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                if(i==0||j ==0)
                    dp[i][j] = 0;
                else if(j-A[i-1]<0)
                    dp[i][j] = dp[i-1][j];
                else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]]+V[i-1]);
                    }
                
            }
        }
        return dp[n][m];
    }
}
