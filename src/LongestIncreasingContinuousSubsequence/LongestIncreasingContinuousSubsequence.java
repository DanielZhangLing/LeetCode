package LongestIncreasingContinuousSubsequence;

public class LongestIncreasingContinuousSubsequence {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A.length==0)
            return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i<A.length; i++){
            if(A[i]>A[i-1]){
                dp[i%2] = dp[(i-1)%2]+1;
                max = Math.max(max,dp[i%2]);
            }
            else
                dp[i%2] = 1;
        }
        
        dp[0] = 1;
        for(int i = 1; i<A.length; i++){
            if(A[i]<A[i-1]){
                dp[i%2] = dp[(i-1)%2]+1;
                max = Math.max(max,dp[i%2]);
            }
            else
                dp[i%2] = 1;
        }
        return max;
    }
}
