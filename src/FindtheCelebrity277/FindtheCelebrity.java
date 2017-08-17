package FindtheCelebrity277;

public class FindtheCelebrity {

    public int findCelebrity(int n) {
    	// The first pass is to pick out the candidate. i doesn't know candidate, then switch candidate. 
        if(n==0)
        return -1;
        int candidate = 0;
        for(int i=0;i<n;i++)
        {
            if(!knows(i, candidate))
                candidate = i;
        }
        // second pass is to check candidate because it may not exist
        for(int j = 0; j<n ; j++){
            if(j!=candidate){
                if(!knows(j, candidate) || knows(candidate, j))
                return -1;
            }
        }
        
        return candidate;
    }
}
