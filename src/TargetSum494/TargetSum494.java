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
}
