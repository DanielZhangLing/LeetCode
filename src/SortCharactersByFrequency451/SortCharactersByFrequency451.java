package SortCharactersByFrequency451;

import java.util.ArrayList;
import java.util.HashMap;

public class SortCharactersByFrequency451 {
    public static String frequencySort(String s) {
        
    	char[] data = s.toCharArray();
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i<data.length; i++ ){
    		if(map.get(data[i]) != null)
    			map.put(data[i],1+map.get(data[i]));
    		else
    			map.put(data[i], 1);
    	}
    	ArrayList<Character>[] bucket = new ArrayList[s.length()+1];
    	for(char item:map.keySet()){
    		int times = map.get(item);
    		if (bucket[times] == null)
    			bucket[times] = new ArrayList<Character>();
    		bucket[times].add(item);
    	}
    	
    	StringBuilder fixedData = new StringBuilder();
    	for(int i = bucket.length-1;i>=0;i--)
    		if(bucket[i] != null)
    			for(char key: bucket[i])
    				for(int times = 0;times<map.get(key);times++)
    					fixedData.append(key);
    	return fixedData.toString();
    					
    				
    	
    }
    public static void main(String[] args){
    	System.out.println(frequencySort("eeeee"));
    }
}
