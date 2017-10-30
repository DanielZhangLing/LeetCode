package ContinuousSubarraySum523;

public class ContinuousSubarraySum523 {
	/**
	 * We iterate through the input array exactly once,
	 *  keeping track of the running sum mod k of the elements in the process. 
	 *  If we find that a running sum value at index j has been previously seen before
	 *   in some earlier index i in the array, 
	 *   then we know that the sub-array (i,j] contains a desired sum.
	 * @param nums
	 * @param k
	 * @return
	 */
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return false;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            if(k!=0)// be careful with 0, just basically add everything
                sum %=k;
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1)
                    return true;
            }
            else{
                map.put(sum,i);
            }
        }
        return false;
    }
}
