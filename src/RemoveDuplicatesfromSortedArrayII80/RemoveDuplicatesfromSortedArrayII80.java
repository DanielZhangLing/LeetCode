package RemoveDuplicatesfromSortedArrayII80;

public class RemoveDuplicatesfromSortedArrayII80 {
	public int removeDuplicates(int[] nums) {
		   int i = 0;
		   for (int n : nums)
		      if (i < 2 || n > nums[i - 2])
		         nums[i++] = n;
		   return i;
		}
	
	
	int removeDuplicates(int A[], int n, int k) {

        if (n <= k) return n;

        int i = 1, j = 1;
        int cnt = 1;
        while (j < n) {
            if (A[j] != A[j-1]) {
                cnt = 1;
                A[i++] = A[j];
            }
            else {
                if (cnt < k) {
                    A[i++] = A[j];
                    cnt++;
                }
            }
            ++j;
        }
        return i;
}
	// trash
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0 ; 
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])==2){
                    count++;
                    continue;
                }
                map.put(nums[i],2);
                nums[i-count] = nums[i];
            }else{
                map.put(nums[i],1);
                nums[i-count] = nums[i];
            }
        }
        return nums.length-count;
    }
}
