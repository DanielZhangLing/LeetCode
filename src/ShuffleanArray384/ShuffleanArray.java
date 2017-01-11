package ShuffleanArray384;

import java.util.HashSet;
import java.util.Random;

public class ShuffleanArray {

	int[] nums;
	
	public ShuffleanArray(int[] nums){
		this.nums = nums;
	}
	
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] temp = nums.clone();
    	Random rand = new Random();
    	for(int i = 1; i<nums.length;i++){
    		int randNum = rand.nextInt(i+1);
    		swap(temp,i,randNum);
    	}
    	return temp;
    	
    }
    
    public void swap(int[] a, int i, int randNum){
    	int temp = a[i];
    	a[i] = a[randNum];
    	a[randNum] = temp;
    }
}
