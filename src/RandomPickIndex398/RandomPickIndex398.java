package RandomPickIndex398;

// randomly select an int from 0 to the nums of target. 
// If x equals 0, set the res as the current index. 
// The probability is always 1/nums for the latest appeared number. 
// For example, 1 for 1st num, 1/2 for 2nd num, 
// 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
public class RandomPickIndex398 {

    int nums[];
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for(int i = 0 ; i <nums.length; i++){
            if(nums[i]!=target)
                continue;
            if(rand.nextInt(++total)==0)
                res = i;
        }
        return res;
    }
}
