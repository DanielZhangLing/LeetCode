package BestTimetoBuyandSellStock121;

public class BestTimetoBuyandSellStock121 {
	/*
	 * min smallest up to now
	 */
    public int maxProfit(int[] prices) {
        int res=0;
        int min = Integer.MAX_VALUE;
        for(int elm: prices){
            min = Math.min(min, elm);
            res = Math.max(res, elm-min);
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
