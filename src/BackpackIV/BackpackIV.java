package BackpackIV;

public class BackpackIV {
	
	/*
	 * State:
• f[i][S] “前i”个物品，取出组成和为S的个数
• Function:
• a[i-1] 是第i个物品下标是i-1
• k 是第i个物品选取的次数
循环只要j-nums[i-1]*k>=0
• f[i][S] += f[i-1][S - k*a[i-1]] or f[i-1][S]
• Intialize:
• f[0][0] = 1; 从i=1开始
• Answer:
• 答案是f[n][S]

	 */
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i =1 ; i<=n; i++){
            for(int j = 0; j<=target; j++){
                int k = 0;
                while(j-nums[i-1]*k>=0){
                    dp[i][j] +=dp[i-1][j-nums[i-1]*k];
                    k++;
                }
            }
        }
        
        return dp[n][target];
    }
}
