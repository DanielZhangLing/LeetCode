package TopKFrequentElements347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
    	HashMap<Integer,Integer> times = new HashMap<>();
    	for(int elm: nums){
    		if(times.get(elm)!=null)
    			times.put(elm, times.get(elm)+1);
    		else
    			times.put(elm, 1);
    	}
    	List<Integer>[] bucket = new ArrayList[nums.length+1];
    	List<Integer> res = new ArrayList();
    	for(int key:times.keySet()){
    		int freq = times.get(key);
    		if(bucket[freq]==null)
    			bucket[freq] = new ArrayList();
    		bucket[freq].add(key);
    	}
    	int count = 0;
    	for(int i = 0; i<bucket.length;i++){
    		if(count<k&&bucket[bucket.length-i-1]!=null){
	    		for(int elm: bucket[bucket.length-i-1]){
	    			res.add(elm);
	    			count++;
	    		}
    		}
    	}
    	return res;
    	
    }
}
