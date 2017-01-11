package ProductofArrayExceptSelf238;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
     
    	int[] output = new int[nums.length];
    	int product = 1;
    	int productExptZero = 1;
    	boolean count = true;
    	for(int elm: nums){
    		if (count&& elm==0){
    			count = false;
    			product *= elm;
    		}
    		else{
    			product *= elm;
    			productExptZero *= elm;
    		}
    	}
    	for(int i=0; i<nums.length;i++){
    		if(nums[i]==0)
    			output[i] = productExptZero;
    		else
    			output[i] = product/nums[i];
    	}
    	
    	return output;
    }
    
    // 分别从两边开始往中间乘，都到了目标位置停下
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
    
    public static void main(String[] args){
    	ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();
    	int[] data = {1,2,3,4};
    	for(int elm: test.productExceptSelf(data))
    		System.out.println(elm);
    }
}
