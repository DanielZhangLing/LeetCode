package kSum;

public class kSum {

	• n个数，取k个数，组成和为target
	• State:
	• f[i][j][t]前i个数取j个数出来能否和为t
	• Function:
	• f[i][j][t] = f[i - 1][j - 1][t - a[i-1]] + f[i - 1][j][t]
	• Intialization
	• f[i][0][0] = 1
	• Answer
	• f[n][k][target]

    public int kSum(int A[], int k, int target) {
        // write your code here、
        int[][][] dp = new int[A.length+1][k+1][target+1];
        for(int i=0; i<=A.length; i++)
            dp[i][0][0] = 1;
        for(int i = 1 ; i<= A.length; i++){
            for(int j = 1; j<=k; j++){
                for(int m=1; m<=target; m++){
                    dp[i][j][m] = dp[i-1][j][m];
                    if(m-A[i-1]>=0){
                        dp[i][j][m] += dp[i-1][j-1][m-A[i-1]];
                    }
                }
            }
        }
        return dp[A.length][k][target];
    }
}
