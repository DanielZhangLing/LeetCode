package ContiguousArray525;

public class ContiguousArray525 {

	/*
	 * draw a diagram with fluctuation 1 means -1 0 means +1
	 * so when they reach 0 means from start to i is a result
	 * and all from -1 to -1 is another result
	 * https://leetcode.com/problems/contiguous-array/solution/
	 */
    public int findMaxLength(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int res = 0;
        int h = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                h-= 1;
            else
                h+=1;
            if(map.containsKey(h)){
                res = Math.max(res, i-map.get(h));
            }else{
                map.put(h,i);
            }
        }
        return res;
    }
}
