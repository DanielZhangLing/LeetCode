package Sqrt;

public class Sqrt {
    public int sqrt(int x) {
        // write your code here
        long start = 1;
        long end = x;
        while(start+1<end){
            long mid = (start+end)/2;
            if(mid*mid>x){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(start*start <= x)
            return (int)start;
        else
            return (int)end;
    }
}
