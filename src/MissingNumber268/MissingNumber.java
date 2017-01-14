package MissingNumber268;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        
    int n = nums.length;
    int res = (0+n)*(n+1)/2;
    for(int elm:nums)
        res -= elm;
        
    return res;
    }
    
    public int missingNumber2(int[] nums) {

        int xor = 0, i = 0;
    	for (i = 0; i < nums.length; i++) {
    		xor = xor ^ i ^ nums[i];
    	}

    	return xor ^ i;
    }
}
