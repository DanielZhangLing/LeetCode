package MoveZeroes283;

import java.util.Vector;

public class MoveZeroes {

    public int[] moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length;i++){
        	if(nums[i] == 0){
        		count++;
        		continue;
        	}
        	else{
        		nums[i-count] = nums[i];
        	}
        }
        while(count>0){
        	nums[nums.length-count--] = 0;
        }
        return nums;
    }
    
	public static void main(String[] args){
		
		String a = "12345";
		
	}
}
