package MinimumMovestoEqualArrayElementsII462;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        
    	Arrays.sort(nums);
    	int count = 0;
    	int i = 0;
    	int j = nums.length-1;
    	while (i<j){
    		count+= nums[j]-nums[i];
    		i++;
    		j--;
    	}
    	return count;
    }
    
    public static void main(String[] args){
    	
    	int[] data = {1,2,3};
    	MinimumMovestoEqualArrayElementsII test = new MinimumMovestoEqualArrayElementsII();
    	System.out.println(test.minMoves2(data));
    }
}
