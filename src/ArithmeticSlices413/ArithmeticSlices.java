package ArithmeticSlices413;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int n = 0;
        int result = 0;
        for (int i = 1;i< A.length-1;i++)
        {
        	if (A[i]-A[i-1] == A[i+1]-A[i])
        	{
        		n++;
        		result+= n;
        	}
        	else
        		n=0;
        }
        return result;
    }
}