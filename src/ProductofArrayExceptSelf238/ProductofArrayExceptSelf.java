package ProductofArrayExceptSelf238;

public class ProductofArrayExceptSelf {
    
    // 分别从两边开始往中间乘，都到了目标位置停下
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i< len; i++){
            res[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i = len-1; i>=0; i--){
            res[i] *= product;
            product *=nums[i];
        }
        return res;
    }
    
    public int[] productExceptSelf(int[] nums) {
        if(nums.length==0||nums.length==1)
            return null;
        int n = nums.length;
        int res[] = new int[n];
        res[0] = 1;
        for(int i = 1; i<n; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int total = nums[n-1];
        for(int j = n-2; j>=0; j--){
            res[j] *= total;
            total *= nums[j];
        }
        return res;
        
    }
    
    public static void main(String[] args){
    	ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();
    	int[] data = {1,2,3,4};
    	for(int elm: test.productExceptSelf(data))
    		System.out.println(elm);
    }
}
