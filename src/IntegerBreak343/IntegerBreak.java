package IntegerBreak343;

public class IntegerBreak {

    public int integerBreak(int n) {
        
    	int quotient = 0;
    	int remainder = 0;
    	quotient = n/3;
    	remainder = n%3;
    	if(remainder == 0)
    		return (int) Math.pow(3, quotient);
    	else if(remainder == 1)
    		return (int) Math.pow(3, (quotient-1)) * 4;
    	else
    		return (int) Math.pow(3, quotient) *2;
    }
    public class integerBreak2 {
        public int integerBreak(int n) {
            if(n==2) return 1;
            if(n==3) return 2;
            int product = 1;
            while(n>4){
                product*=3;
                n-=3;
            }
            product*=n;
            
            return product;
        }
}
}
