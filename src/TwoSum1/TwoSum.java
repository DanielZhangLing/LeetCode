package TwoSum1;

/**
 * Created by LingZhang on 5/8/17.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
    
    
        public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int sum;
        
        while( left < right ) {
            sum = numbers[left] + numbers[right];
            if(  sum == target )
                return new int[]{left+1, right+1};
            else if ( sum < target )    left++;
            else right--;
        }
        return null;
    }
}
