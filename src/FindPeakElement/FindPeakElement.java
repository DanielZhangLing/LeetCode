package FindPeakElement;

public class FindPeakElement {
    public int findPeak(int[] A) {
        // write your code here
        int left = 0;
        int right = A.length-1;
        
        while(right>left+1){
            int mid = (left+right)/2;
            if(A[mid]>A[mid+1]){
                right = mid;
            }
            else if(A[mid]<A[mid+1]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(A[left]>A[right]){
            return left;
        }
        else{
            return right;
        }
        
    }
}
