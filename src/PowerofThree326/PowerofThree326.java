package PowerofThree326;

public class PowerofThree326 {
     public boolean isPowerOfThree(int n) {
         if(n<=0)
             return false;
         while(n!=1){
             if(n%3!=0)
                 return false;
             n /= 3;
         }
         return true;
     }
     public boolean isPowerOfThree2(int n) {
    	    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    	}
     /*
      * If N is a power of 3:

It follows that 3^X == N
It follows that log (3^X) == log N
It follows that X log 3 == log N
It follows that X == (log N) / (log 3)
For the basis to hold, X must be an integer.
However, due to the fact that log(3) cannot be precisely represented on a binary computer;
 X is considered an integer if its decimal component falls within a guard range of +/-0.00000000000001. 
 Static imports for log, abs and rint from java.lang.Math.
      */
     public boolean isPowerOfThree3(int n) {
    	  double a = log(n) / log(3);
    	  return abs(a - rint(a)) <= 0.00000000000001;
    	}
     public boolean isPowerOfThree4(int n) {
    	    // 1162261467 is 3^19,  3^20 is bigger than int  
    	    return ( n>0 &&  1162261467%n==0);
    	}
}
