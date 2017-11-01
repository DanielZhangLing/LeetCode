package TargetSum494;

public class TargetSum494 {
	
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(0,nums,S,0);
    }
    
    private int dfs(int index, int[] nums, int S,int sum){
        if(index == nums.length&& sum == S){
            return 1;
        }
        if(index == nums.length){
            return 0;
        }
        return dfs(index+1, nums, S, sum+nums[index]) + dfs(index+1, nums, S, sum-nums[index]);
    }
    
    
    
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
    https://leetcode.com/uploads/files/1485048726667-screen-shot-2017-01-21-at-8.31.48-pm.jpg
}
