package CountingBits338;

/*
 * This is the function we get, now we need find the other pattern for the function to get the general function. After we analyze the above function, we can get
dp[0] = 0;

dp[1] = dp[1-1] + 1;

dp[2] = dp[2-2] + 1;

dp[3] = dp[3-2] +1;

dp[4] = dp[4-4] + 1;

dp[5] = dp[5-4] + 1;

dp[6] = dp[6-4] + 1;

dp[7] = dp[7-4] + 1;

dp[8] = dp[8-8] + 1;
..

Obviously, we can find the pattern for above example, so now we get the general function

dp[index] = dp[index - offset] + 1;
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        int base = 1;
        for(int i=1;i<result.length;i++){
            if(i<base*2)
                result[i] = 1+result[i-base];
            else{
                result[i] = 1;
                base = i;
            }
        }
        return result;
    }
    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
