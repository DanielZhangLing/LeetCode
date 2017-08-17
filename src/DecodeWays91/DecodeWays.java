package DecodeWays91;

/**
 * Created by LingZhang on 5/19/17.
 */
public class DecodeWays {
	//dp
    public int numDecodings(String s) {
        int res = 0;
        if(s==null||s.length()==0||s.charAt(0)=='0')//不能从0开始
            return res;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=s.length(); i++){
        	//0前面只能跟1或者2
            if(s.charAt(i-2)!='1'&&s.charAt(i-2)!='2'&& s.charAt(i-1)=='0'){
                return 0;
            }
            //如果出现了0说明前面一个数字和他绑定只有这一种可能，结果和i-2一样
            if(s.charAt(i-1)=='0')
                dp[i] = dp[i-2];
            //1几和20几会多一种可能
            else if((s.charAt(i-2)=='2'&& s.charAt(i-1)<'7'&&s.charAt(i-1)>'0')||(s.charAt(i-2)=='1'&&s.charAt(i-1)!='0')){
                dp[i] = dp[i-2] + dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];     
    }
}
