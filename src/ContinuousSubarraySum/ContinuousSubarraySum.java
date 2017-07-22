package ContinuousSubarraySum;

public class ContinuousSubarraySum {
	
	/*
	 * dp, 用数组记录该节点为结尾的最大subarray。
	 * 用start end 记录结果
	 */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>(2);
        res.add(0);
        res.add(0);
        if(A==null||A.length==0)
            return res;
        int start = 0, end = 0, max=A[0];
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i = 1; i<A.length; i++){
            if(dp[i-1]<0){
                dp[i] = A[i];
                start = end = i;//意味着从这里往后的所有dp[i]起点都大于等于i，因为前面是负数
            }
            else{
                dp[i] = dp[i-1]+A[i];
                end = i;
            }
            if(dp[i]>max){
                max = dp[i];
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }
}
