package BestTimetoBuyandSellStockII122;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
     for(int i=1;i<prices.length;i++)
    	 if(prices[i]-prices[i-1]>0)
    		 maxProfit+= prices[i]-prices[i-1];
     return maxProfit;
    }
    public int maxProfit2(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int min = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]<prices[i-1]){
                res+= prices[i-1]-min;
                min = prices[i];
            }
        }
        return res+ prices[prices.length-1]-min;
    }
}
