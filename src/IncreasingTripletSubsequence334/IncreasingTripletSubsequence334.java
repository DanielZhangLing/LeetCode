package IncreasingTripletSubsequence334;

public class IncreasingTripletSubsequence334 {
	/*
	 * The main idea is keep two values when check all elements in the array:
	 *  the minimum value min until now and 
	 *  the second minimum value secondMin from the minimum value's position until now.
	 *   Then if we can find the third one that larger than those two values at the same time,
	 *    it must exists the triplet subsequence and return true.

What need to be careful is: 
we need to include the condition that some value has the same value with minimum number,
 otherwise this condition will cause the secondMin change its value.
	 */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return false;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1; i <nums.length; i ++){
            if(nums[i]>second)
                return true;// return if you find a number bigger than both
            first = Math.min(first, nums[i]);// update small if n is smaller than both
            if(nums[i]>first)
                second = Math.min(second, nums[i]);// update big only if greater than small but smaller than big
        }
        return false;
    }
    
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}
