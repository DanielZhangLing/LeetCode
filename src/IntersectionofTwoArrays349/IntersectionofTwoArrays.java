package IntersectionofTwoArrays349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
     
    	List<Integer> res = new ArrayList<Integer>();
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	for(int elm: nums1){
    		map.put(elm, map.getOrDefault(elm, 0)+1);
    	}
    	
    	for(int elm: nums2){
    		if(map.get(elm)!=null){
    			res.add(elm);
    			map.remove(elm);
    		}
    	}
    	
    	int[] resArray = new int[res.size()];
    	for (int i = 0; i < res.size(); i++) {
    		resArray[i] = res.get(i);
    	}
    	return resArray;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
    
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}
