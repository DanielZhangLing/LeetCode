package MaximumProductSubarray152;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        
        if(null==nums||0==nums.length)
            return 0;
            
        int maxpre = nums[0];
        int minpre = nums[0];
        int max = nums[0];
        int maxhere, minhere;
        
        for(int i=1;i<nums.length;i++){
            maxhere = Math.max(Math.max(maxpre*nums[i],nums[i]),minpre*nums[i]);
            minhere = Math.min(Math.min(minpre*nums[i],nums[i]),maxpre*nums[i]);
            maxpre = maxhere;
            minpre = minhere;
            max = Math.max(maxpre,max);
        }
        
        return max;
    }
}
