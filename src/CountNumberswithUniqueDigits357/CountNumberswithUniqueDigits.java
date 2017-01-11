package CountNumberswithUniqueDigits357;

public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        
    	int res = 1;
    	for(int i=0;i<n; i++){
    		int temp = 1;
			if(i==0)
				temp*=9;
			else temp*=10-i;
	   		res +=temp;
    			}

    	return res;
    }
}
