package SearchinRotatedSortedArray33;

public class SearchinRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low+1< high){
            int mid = low+(high-low)/2;
            if(target == nums[mid])
                return mid;
            // check at gap left or gap right
            if(nums[mid]>=nums[low]){
                if(target<nums[mid]&&target>=nums[low])
                    high = mid;
                else
                    low = mid;
            }else{
                if(target>nums[mid]&&target<=nums[high])
                    low = mid;
                else
                    high = mid;
            }
        }
        if(nums[low]==target)
            return low;
        if(nums[high]==target)
            return high;
        return -1;
    }
}
