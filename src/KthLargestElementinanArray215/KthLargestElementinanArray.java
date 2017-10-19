package KthLargestElementinanArray215;

public class KthLargestElementinanArray {

	// quick select
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return 0;
        return quickSort(nums, 0 , nums.length-1, k);
    }
    
    private int quickSort(int[] nums, int low, int high, int k){
        if (low == high) {
            return nums[low];
        }
        int pos = partition(nums, low, high);
        if (pos + 1 == k) {
            return nums[pos];
        } else if (pos + 1 < k) {
            return quickSort(nums, pos + 1, high, k);
        }  else {
            return quickSort(nums, low, pos - 1, k);
        }
    }
    
    private int partition(int[] nums, int low, int high){
        int i = low;
        int j = high;
        int pivot = nums[low];
        while(j>=i){
            while(i<=j&&nums[i]>=pivot)
                i++;
            while(j>=i&&nums[j]<=pivot)
                j--;
            if(j>i){ 
                swap(nums,j,i);
            }
        }
        swap(nums, low, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    

    
    
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}
    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
