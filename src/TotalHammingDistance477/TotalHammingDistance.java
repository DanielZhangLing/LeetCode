package TotalHammingDistance477;

public class TotalHammingDistance {


    public int totalHammingDistance(int[] nums) {
    	int result = 0;
    	for(int i = 0;i<nums.length;i++)
    		for(int j = i+1; j<nums.length;j++)
    			result += Integer.bitCount((nums[i]^nums[j]));
    	return result;
    }
    
    public int totalHammingDistance2(int[] nums) {
    	int result = 0;
    	int n = nums.length;
    	int[] bitCount = new int[31];
    	for(int i = 0;i<bitCount.length;i++)  {  
    		int count = 0;
    		for(int j = 0; j<n;j++)
    			count+= nums[j]>>i&1;
    		result += count*(n-count);
    	}
    	return result;
    }
}
