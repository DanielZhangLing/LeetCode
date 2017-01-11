package MajorityElement169;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int limit = nums.length/2;
    	for(int i = 0;i<nums.length;i++){
    		int temp = nums[i];
    		map.put(temp, map.getOrDefault(temp, 0)+1);
			if(map.get(temp)> limit)
				return temp;
    	}
    	
    		
    	return 0;
    }
    

}
