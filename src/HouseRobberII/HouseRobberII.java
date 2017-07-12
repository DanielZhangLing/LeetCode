package HouseRobberII;

public class HouseRobberII {
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        return Math.max(robber1(nums, 0 , nums.length-2), robber1(nums, 1, nums.length-1));
    }
    
    public int robber1(int[] nums, int start, int end){
        if((start-end) == 0){
            return nums[start];
        }
        if((end-start) == 1){
            return Math.max(nums[start], nums[end]);
        }
        int[] res = new int[2];
        res[start%2] = nums[start];
        res[(start+1)%2] = Math.max(nums[start],nums[start+1]);
        for(int i = start+2; i<=end; i++){
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2]+nums[i]);
        }
        return res[end%2];
    }
}
