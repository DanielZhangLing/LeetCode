package ThreeSum;

public class ThreeSum {
	/*
	 * 这里的思想主要是，取出一个元素i，然后再用two sum的方法求其他两个，它们的sum为target - i
遇到题目没有思路的时候都可以考虑先sort一下~
注意点

不能有重复的set, 所以都要将数组sort一下，方便在code中跳过重复的数
two sum可以用hashmap, 也可以用two pointer的方法
时间复杂度O(nlogn + n * n) = O(n^2)
	 */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            List<List<Integer>> two = twoSum(nums, 0-nums[i], i);
            if(!two.isEmpty()){
                for(List<Integer> elm: two){
                    elm.add(nums[i]);
                    res.add(elm); 
                }
  
            }
        }
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null ||nums.length==0)
            return res;
        int start = index+1, end = nums.length-1;
        while(end>start){
            if(start!=index+1&&nums[start]==nums[start-1]){
                start++;
                continue;
            }
            if(end!=nums.length-1&&nums[end]== nums[end+1]){
                end--;
                continue;
            }
            if(nums[start]+nums[end]>target){
                end--;
            }else if(nums[start]+nums[end]<target){
                start++;
            }
            else{
                List<Integer> now = new ArrayList<Integer>();
                now.add(nums[start]);
                now.add(nums[end]);
                res.add(now);
                start++;
                end--;
            }
        }
        return res;
    }
}
