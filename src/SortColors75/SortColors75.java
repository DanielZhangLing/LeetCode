package SortColors75;

public class SortColors75 {
	// two pass O(m+n) space
	public void sortColors(int[] nums) {
	    // 2-pass
	    int count0 = 0, count1 = 0, count2 = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == 0) {count0++;}
	        if (nums[i] == 1) {count1++;}
	        if (nums[i] == 2) {count2++;}
	    }
	    for(int i = 0; i < nums.length; i++) {
	        if (i < count0) {nums[i] = 0;}
	        else if (i < count0 + count1) {nums[i] = 1;}
	        else {nums[i] = 2;}
	    }
	}

	// one pass in place solution
	public void sortColors(int[] nums) {
	    // 1-pass
	    int p1 = 0, p2 = nums.length - 1, index = 0;
	    while (index <= p2) {
	        if (nums[index] == 0) {
	            nums[index] = nums[p1];
	            nums[p1] = 0;
	            p1++;
	            // no need for recheck because the former are already correct
	        }
	        if (nums[index] == 2) {
	            nums[index] = nums[p2];
	            nums[p2] = 2;
	            p2--;
	            index--;// recheck if after swap is still 2
	        }
	        index++;
	    }
	}
	   
	    public void sortColors(int[] nums) {
	        if(nums==null||nums.length==0)
	            return;
	        int i = 0, j = nums.length-1;
	        for(int k = 0 ; k < nums.length; k++){
	        	// can't change order of these two while
	            while(nums[k] ==2&&k<j){
	                swap(nums, j--,k);
	            }
	            while(nums[k]==0&&k>i){
	                swap(nums, i++, k);
	            }

	        }
	        
	    }
	    private void swap(int[] nums, int i , int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
}
