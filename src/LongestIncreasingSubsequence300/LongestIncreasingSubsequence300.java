package LongestIncreasingSubsequence300;

public class LongestIncreasingSubsequence300 {

	/*
	 * dp[i] the longest subsequence ending with nums[i]
	 * O(n^2)
	 */
	
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            dp[i] = 1;
        }
        for(int i = 1; i <nums.length; i++){
        	// checking all the dp[i] calculated before
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i = 0;i<nums.length; i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
