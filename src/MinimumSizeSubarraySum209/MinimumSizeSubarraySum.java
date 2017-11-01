package MinimumSizeSubarraySum209;

public class MinimumSizeSubarraySum {
// two pointers
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while(j<nums.length){
            if(sum<s){
                sum += nums[j++];
            }
            while(sum>=s){
                min = Math.min(min,j-i );
                sum -= nums[i++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
