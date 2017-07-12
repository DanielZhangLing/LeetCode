package DecodeWays;

public class DecodeWays91 {
    public static int numDecodings(String s) {
        int n = s.length();
        if(null==s||""==s||0==n)
            return 0;
        
        if(n==1)
            return 1;
        if(Integer.parseInt(s)<27){
        	return 2;
        }
        int result = 0;
        if('1'==s.charAt(n-2)||'2'==s.charAt(n-2))
            result = numDecodings(s.substring(0,n-2)) + numDecodings(s.substring(0,n-1));
        else
            result = numDecodings(s.substring(0,n-1));
        return result;
        
    }
    public static void main(String[] args){
    	String a  = "123";
    	int n = a.length();
    	System.out.println(numDecodings(a));
    	System.out.println(numDecodings("1"));
    	System.out.println(numDecodings("12"));
    }
}
