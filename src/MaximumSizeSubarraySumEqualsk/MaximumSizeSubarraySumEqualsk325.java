package MaximumSizeSubarraySumEqualsk;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk325 {

    public int maxSubArrayLen(int[] nums, int k) {
        
        if(nums==null||nums.length==0)
            return 0;
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            if(sum==k)
                result = i+1;
            else if(map.containsKey(sum-k))
            result = Math.max(result,i+1-map.get(sum-k));
            if(!(map.containsKey(sum)))
            map.put(sum,i+1);
        }
        return result;
    }
    
}
