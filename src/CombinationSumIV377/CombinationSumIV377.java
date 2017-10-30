package CombinationSumIV377;

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
    
    
//    time limit
//    public int combinationSum4(int[] nums, int target) {
//        if (target == 0) {
//            return 1;
//        }
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]) {
//                res += combinationSum4(nums, target - nums[i]);
//            }
//        }
//        return res;
//    }
    
    /*
     * 自顶向下
     * We can fill the array with -1 to indicate that the result hasn't been calculated yet.
     *  0 is not a good choice because it means there is no combination sum for the target.
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
//The problem with negative numbers is that now the combinations 
// could be potentially of infinite length. Think about nums = [-1, 1] and target = 1.
// We can have all sequences of arbitrary length that follow the patterns -1, 1, -1, 1,
// ..., -1, 1, 1 and 1, -1, 1, -1, ..., 1, -1, 1 
// (there are also others, of course, just to give an example). 
// So we should limit the length of the combination sequence, 
// so as to give a bound to the problem.
