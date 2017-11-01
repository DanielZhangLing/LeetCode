package Pow50;

public class Pow50 {
	/*
	 * 这一题主要是递归类似二分法，每次递归求n/2的结果，再乘以自己，如果是奇数再乘以一个x 注意点
		n 是负数的情况 如果是minint翻过来是不存在的所以要先拿出来一个
		n 是奇数的情况
	 */
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        if(n<0)
            return 1/x * myPow(1/x, -(n+1));
        return n%2==0? myPow(x*x, n/2): x*myPow(x*x, n/2);
    }
    
    double myPow(double x, int n) { 
        if(n==0) return 1;
        double t = myPow(x,n/2);
        if(n%2) return n<0 ? 1/x*t*t : x*t*t;
        else return t*t;
    }
}
