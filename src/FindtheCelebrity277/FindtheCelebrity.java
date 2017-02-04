package FindtheCelebrity277;

public class FindtheCelebrity {

    public int findCelebrity(int n) {
        
        if(n==0)
        return -1;
        int candidate = 0;
        for(int i=0;i<n;i++)
        {
            if(!knows(i, candidate))
                candidate = i;
        }
        
        for(int j = 0; j<n ; j++){
            if(j!=candidate){
                if(!knows(j, candidate) || knows(candidate, j))
                return -1;
            }
        }
        
        return candidate;
    }
}
