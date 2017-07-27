package CombinationSumIV377;

public class CombinationSumIV377 {
	/*
	 * 自底向上， dp
	 * 是每一个值有多少种可能 dp[k] = sum(dp[k-i]) i属于nums 用dp[0]=1作为开始
	 */
    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        if(nums==null||nums.length==0)
            return res;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i<=target; i++){
            for(int elm: nums){
                if(i-elm>=0)
                    dp[i] += dp[i-elm];
            }
        }
        return dp[target];
    }
    
    /*
     * 自顶向下
     */
    
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}
