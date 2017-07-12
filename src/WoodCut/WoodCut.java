package WoodCut;

public class WoodCut {
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for(int elm: L){
            max = Math.max(max,elm);
        }
        int start = 1;
        int end = max;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(certified(mid, L, k)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if (certified(end,L, k)) {
            return end;
        }
        if (certified(start,L, k)) {
            return start;
        }
        return 0;

    }
    
    public boolean certified(int mid, int[] L,int k){
        int count = 0;
        for(int i = 0; i<L.length; i++){
            count+= L[i]/mid;
        }
        return count>=k;
    }
}
