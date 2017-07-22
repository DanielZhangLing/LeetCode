package SubarraySumII;

public class SubarraySumII {
	/*
	 * use a find function find numbers in A[] <= given value
	 * 
	 */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int n = A.length;
        int count = 0;
        for(int i=1; i<n; i++){
            A[i] += A[i-1];
        }
        for(int i = 0 ; i<n; i++){
            if (A[i] >= start && A[i] <= end)
                count ++;

            int l = A[i]-end;
            int r = A[i]-start;
            count+= find(A,r) - find(A,l-1);
        }
        return count;
    }
    
    public int find(int[] A, int value){
        
        int end = A.length-1;
        int start = 0;
        if(value<A[0])
            return 0;
        
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(A[mid]<=value){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[end]<=value)
            return end+1;
        else
            return start+1;
        
    }
}
