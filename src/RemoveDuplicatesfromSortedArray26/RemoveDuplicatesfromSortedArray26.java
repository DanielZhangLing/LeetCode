package RemoveDuplicatesfromSortedArray26;

public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int count = 0;
        for(int i = 1; i <nums.length; i ++){
            if(nums[i] == nums[i-1]){
                count++;
                continue;
            }
            else{
                nums[i-count] = nums[i];
            }
        }
        return nums.length-count;
    }
    
    
    xxxxxxx{
        int index= 0 ; 
        for(int i = 1; i<nums.length; i++){
            if(nums[i]===nums[i-1])
                continue;
            nums[++index]=nums[i];
        }
        return index+1;
    }
}
