package TotalHammingDistance477;

public class TotalHammingDistance {


    public int totalHammingDistance(int[] nums) {
    	int result = 0;
    	for(int i = 0;i<nums.length;i++)
    		for(int j = i+1; j<nums.length;j++)
    			result += Integer.bitCount((nums[i]^nums[j]));
    	return result;
    }
    
    /**
     * For each bit position 1-32 in a 32-bit integer, 
     * we count the number of integers in the array which have that bit set. 
     * Then, if there are n integers in the array and k of them have a particular bit set 
     * and (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.
     * @param nums
     * @return
     */
    public int totalHammingDistance2(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++) 
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}
