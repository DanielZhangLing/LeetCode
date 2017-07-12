package BurstBalloons;

public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        // Write your code here
        if(null==nums||nums.length==0){
            return 0;
        }
        
        //Initialize
        int n = nums.length;
        int[][] visit = new int[n+2][n+2];
        int[][] dp = new int[n+2][n+2];
        int [] arr = new int [n+2];
        for (int i = 1; i <= n; i++){
        	arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        
        return search(1, n, visit, dp, arr);
        
    }
    
    public static int search(int l, int r, int[][] visit, int[][] dp, int[] arr){
        if(visit[l][r]==1){
            return dp[l][r];
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = l; i<=r ;++i){
            int left = search(l,i-1,visit,dp,arr);
            int right = search(i+1,r,visit,dp,arr);
            int mid = arr[i]*arr[l-1]*arr[r+1];
            res= Math.max(res, (left+ right+mid));
        }
        dp[l][r] = res;
        visit[l][r] = 1;
        return dp[l][r];
    }
    public static void main(String[] args){
    	int[] a = {4,1,5, 10};
    	maxCoins(a);
    }
}
