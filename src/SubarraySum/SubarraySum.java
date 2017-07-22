package SubarraySum;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if(nums.length==0)
            return null;
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                res.add(map.get(sum)+1);
                res.add(i);
                return res;
            }
            else{
                map.put(sum, i);
            }
        }
        return null;
    }
}
