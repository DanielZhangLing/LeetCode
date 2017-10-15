package Pow50;

public class Pow50 {
	/*
	 * 这一题主要是递归类似二分法，每次递归求n/2的结果，再乘以自己，如果是奇数再乘以一个x 注意点
		n 是负数的情况
		n 是奇数的情况
	 */
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
