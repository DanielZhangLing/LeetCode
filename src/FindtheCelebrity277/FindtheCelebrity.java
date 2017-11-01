package FindtheCelebrity277;

public class FindtheCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0;    	
        // The first pass is to pick out the candidate. i doesn't know candidate, 
        // then switch candidate. if exists only could be this guy
        for(int i = 1; i<n ; i++){
            if(knows(candidate,i))
                candidate = i;
        //doesn't check if candidate doesn't know former guys or if former one knows candidates before switch him
        }
        for(int i = 0 ; i<n; i++){
            if(i!= candidate&& (knows(candidate,i)||!knows(i,candidate)))
                return -1;
        }
        return candidate;
    }
}
