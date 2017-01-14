package Sum4II454;

import java.util.HashMap;
import java.util.Map;

public class Sum4II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
    	int res = 0;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int elmA:A)
    		for(int elmB:B)
    			map.put(elmA+elmB, map.getOrDefault((elmA+elmB),0)+1);
    		
    	for(int elmA:C)
    		for(int elmB:D)
    			res+=map.getOrDefault(-(elmA+elmB),0);
    	return res;
    }
}
