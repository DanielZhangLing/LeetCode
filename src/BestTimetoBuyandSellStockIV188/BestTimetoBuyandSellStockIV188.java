package BestTimetoBuyandSellStockIV188;

public class BestTimetoBuyandSellStockIV188 {
	/*
	 *  // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions. 
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
	 */
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        int res = 0;
        int[][] dp = new int[k+1][prices.length];
        for(int i = 1;i <dp.length; i++){
            int tmpMax = dp[i-1][0] - prices[0];
            for(int j = 1; j<dp[0].length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+tmpMax);
                res = Math.max(res, dp[i][j]);
                tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]);
            }
        }
        return res;
    }
        private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
