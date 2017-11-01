package MoveZeroes283;

import java.util.Vector;

public class MoveZeroes {

	public void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) return;

		int insertPos = 0;
		for (int num: nums) {
			if (num != 0) nums[insertPos++] = num;
		}

		while (insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
	}
	
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
