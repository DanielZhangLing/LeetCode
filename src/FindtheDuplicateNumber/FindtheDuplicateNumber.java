package FindtheDuplicateNumber;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Write your code here
        int start = 1;
        int end = nums.length;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(numSmallerThenMid(mid,nums)>mid){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(numSmallerThenMid(start,nums)<=start){
            return end;
        }
        else{
            return start;
        }
        
    }
    public int numSmallerThenMid(int mid, int[] nums){
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if (nums[i]<=mid){
                count++;
            }
        }
        return count;
    }
}
