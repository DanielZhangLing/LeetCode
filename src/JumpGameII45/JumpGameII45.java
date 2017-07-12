package JumpGameII45;

public class JumpGameII45 {
	/*
	 * 1. treat problem as if use i step how far can i go, or what is the range.
	 * 2. O n
	 */
    public int jump(int[] nums) {
        if(nums==null||nums.length<=1)
            return 0;
        int len = nums.length;
        int start = 0;
        int end = 0;
        int currentEnd = 0;
        int step = 0;
        while(start<=end){
            step = step+1;
            for(int i = start; i<=end; i++){
                if(i+nums[i]>=nums.length-1)
                    return step;
                else
                    currentEnd = Math.max(currentEnd, i+nums[i]);
            }
            start = end+1;
            end = currentEnd;
        }
        
        return Integer.MAX_VALUE;
    }
}
