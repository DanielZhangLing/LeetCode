package CopyBooks;

public class CopyBooks {
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages.length == 0)
            return 0;
            int total=0, max= 0 ;
        for(int i = 0;i<pages.length;i++){
            max = Math.max(max,pages[i]);
            total += pages[i];
        }
        int start = max;
        int end = total;
        
        while(start+1<end){
            int mid = start + (end-start)/2;
            if(countCopiers(pages, mid)>k){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(countCopiers(pages, start)<=k)
            return start;
        return end;
    }
    
    public int countCopiers(int[] pages, int limit){
        int copiers = 1;
        int sum = 0;
        for(int i = 0 ; i< pages.length; i++){
            if(sum+pages[i]>limit){
                copiers++;
                sum = 0;
            }
            sum+= pages[i];
        }
        return copiers;
    }
}
