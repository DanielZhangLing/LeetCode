package KthLargestElementinanArray215;

public class KthLargestElementinanArray {

//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(0, nums.length-1, nums, k);
//    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length-1, nums, k);
    }
    
    public static int quickSelect(int low, int high, int[] nums, int k){

        int temp = nums[high];
        int middle = low;
        for(int i =low; i<=high-1;i++){
            if(nums[i]>temp){
                swap(i, middle, nums);
                middle++;
            }
        }
        swap(high, middle, nums);
        int m = middle-low+1;
        if(k == m)
        return nums[middle];
        else if(m>k)
        	return quickSelect(low, middle-1, nums, k);
        else{
            return quickSelect(middle+1, high, nums,k-m);
            }
    }
    
    static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {2,1};
    	findKthLargest(nums, 1);
    }
}
