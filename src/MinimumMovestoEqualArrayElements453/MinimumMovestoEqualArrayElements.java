package MinimumMovestoEqualArrayElements453;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements {
    public static int minMoves(int[] nums) {
        
    	int res = 0;
    	int l = nums.length;
    	Arrays.sort(nums);
    	for(int i = 1;i<l;i++){
    		res +=(nums[l-i] - nums[l-i-1]) * i;
    	}
    	return res;
    }
    
    // add 1 to n-1 element is actually minus 1 to the highest number
    public int minMoves2(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
    
    public static void main(String[] args){
    	int[] data = {1,2,3};
    	System.out.println(minMoves(data));
    }
}
