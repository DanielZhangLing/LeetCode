package HouseRobber198;

public class HouseRobber {
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for(int num:nums){
            int temp = prevYes;
            prevYes = prevNo + num;
            prevNo = Math.max(prevNo, temp);
        }
        return Math.max(prevNo,prevYes);
    }
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[2];
        
        
        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + A[i-1]);
        }
        return res[n%2];
    }

}
