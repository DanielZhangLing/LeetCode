package MaximumSizeSubarraySumEqualsk;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk325 {

    public int maxSubArrayLen(int[] nums, int k) {
        
        if(nums==null||nums.length==0)
            return 0;
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);//如果整个sum就等于k
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            if(map.containsKey(sum-k))
                result = Math.max(result,i-map.get(sum-k));
            if(!(map.containsKey(sum)))//去除重复的，因为后面出现的即使相等，减出来也不会更大了
                map.put(sum,i);
        }
        return result;
    }
    
}
