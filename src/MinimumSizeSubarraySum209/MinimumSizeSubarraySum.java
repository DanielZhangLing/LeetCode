package MinimumSizeSubarraySum209;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int[] nums, int s) {
        // write your code here
        int i = 0;
        int j = 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for(; i <len; i++){
            while(j <len && sum<s){
                sum+= nums[j];
                j++;
            }
            if(sum>=s)
                res = Math.min(res, j-i);
            sum -= nums[i];
        }
            
        return res==Integer.MAX_VALUE?-1:res;
    }
}
