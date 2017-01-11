package FindAllDuplicatesinanArray442;

import java.util.List;
import java.util.ArrayList;

public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        
    	List<Integer> result = new ArrayList<Integer>();
    	for(int i =0;i<nums.length;i++){
    		int index = Math.abs(nums[i])-1;
    		if(nums[index]<0)
    			result.add(Math.abs(nums[i]));
    		else
    			nums[index]= -nums[index];  		
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	FindAllDuplicatesinanArray test = new FindAllDuplicatesinanArray();
    	int[] data = {4,3,2,7,8,2,3,1};
    	for(int e: test.findDuplicates(data))
    		System.out.println(e);
    	
    }
}
