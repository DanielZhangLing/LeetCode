package FindAllNumbersDisappearedinanArray448;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	int l = nums.length;
    	int[] temp = new int[l];

    	while (l>0){
    		temp[l-1] = l;
    		l--;
    	}
    	List<Integer> result = new ArrayList();
    	for (int i:nums)
    		temp[i-1] = 0;
    	for (int j:temp)
    		if (j>0)
    			result.add(j);
    	return result;
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    
    public static void main(String[] args){
    	FindAllNumbersDisappearedinanArray test = new FindAllNumbersDisappearedinanArray();
    	int[] data = {4,3,2,7,8,2,3,1};
    	System.out.println(test.findDisappearedNumbers(data));
    }
}
