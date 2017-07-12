package JumpGame55;

public class JumpGame55 {
	/*
	 * 1.don't use boolean array
	 * 2.maintain a maxReach, that means the farest that we can go
	 * 3.if i>maxReach skip it,actually can stop
	 * O n
	 */
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)
            return false;
        int len = nums.length;
        int maxReach = 0;
        for(int i = 0; i<len; i++){
            if(i<=maxReach){
                maxReach = Math.max(maxReach, i+nums[i]);
            }
        }
        return maxReach>=len-1;
    }
}
