package FindtheCelebrity277;

public class FindtheCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0;    	
        // The first pass is to pick out the candidate. i doesn't know candidate, then switch candidate. 
        for(int i = 1; i<n ; i++){
            if(knows(candidate,i))
                candidate = i;
        //doesn't check if candidate doesn't know former guys before switch him
        }for(int i = 0; i<candidate; i++){
            if(knows(candidate,i))
                return -1;
        }
        for(int i = 0;i<n; i++){
            if(i!=candidate&&!knows(i,candidate))
                return -1;
        }
        return candidate;
    }
}
