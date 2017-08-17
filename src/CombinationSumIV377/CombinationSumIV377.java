package CombinationSumIV377;

public class CombinationSumIV377 {
	/*
	 * comb[target] = sum(comb[target - nums[i]]),
	 *  where 0 <= i < nums.length, and target >= nums[i]
	 */
    if(nums == null || nums.length==0)
        return 0;
    int[] dp = new int[target+1];
    dp[0] = 1;
    for(int i = 1; i<=target; i++){
        for(int j = 0; j<nums.length; j++){
            if(i - nums[j]>=0){
                dp[i] += dp[i-nums[j]];
            }
        }
    }
    return dp[target];
}
}
