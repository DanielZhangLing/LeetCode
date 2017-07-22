package ContinuousSubarraySumII;

public class ContinuousSubarraySumII {

	/*
	 * 你可以这么理解			
整个数组的和为sum			
那么我们正常就是用DP，用你的方法算出连续最大值subMax			
但是，因为数组可以循环，所以还需要连续最小值subMin			
我们去比较  sum - subMin > subMax ?  sum - subMin : subMax			
			
举个例子：A = [1 , -2, -3, 5]			
subMax = 5			
subMin = -5			
sum = 1			
用总和减去最小连续的值应该是 sum - subMin = 1 - (-5) = 6			
但是subMax = 5, 所以答案是6，然后更新下标就可以			
	 */
    ArrayList<Integer> res = new ArrayList<Integer>(2);
    if(A==null||A.length==0)
        return res;
    int[] dp = new int[A.length];
    int start = 0, end = 0, max = Integer.MIN_VALUE;
    res.add(0);
    res.add(0);

    dp[0] = A[0];
    for(int i = 1; i<A.length; i++){
        if(dp[i-1]<0){
            start = end = i;
            dp[i] = A[i];
        }else{
            end = i;
            dp[i] = dp[i-1] +A[i];
        }
        if(dp[i]>max){
            res.set(0,start);
            res.set(1,end);
            max = dp[i];
        }
    }
    
    ArrayList<Integer> minRes = new ArrayList<Integer>(2);
    int min = Integer.MAX_VALUE;
    minRes.add(0);
    minRes.add(0);
    start = 0;
    end = 0;
    dp[0] = A[0];
    for(int i = 1; i<A.length; i++){
        if(dp[i-1]>=0){
            start = end = i;
            dp[i] = A[i];
        }else{
            end = i;
            dp[i] = dp[i-1] +A[i];
        }
        if (start == 0 && end == A.length-1) continue;

        if(dp[i]<min){
            minRes.set(0,(end+1)%A.length); //==length will change to 0
            minRes.set(1,(start-1+A.length)%A.length);//取全部数字的时候，结果为-1，正确显示成len-1
            min = dp[i];
        }
    }
    
    int sum = 0;
    for(int elm: A){
        sum+= elm;
    }
    
    return max>(sum-min)? res:minRes;
    
    
}
}
