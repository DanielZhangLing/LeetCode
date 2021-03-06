package MergeSortedArray88;

public class MergeSortedArray88 {
	/*
	 * keypoint: add from last to the first or how can we get number from nums1
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i>-1&&j>-1){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>-1){
            nums1[k--] = nums2[j--];
        }
    }
}
