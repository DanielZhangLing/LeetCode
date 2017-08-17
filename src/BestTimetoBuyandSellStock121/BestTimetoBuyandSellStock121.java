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
}
