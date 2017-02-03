package NumberofBoomerangs447;

import java.util.HashMap;

public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<n;i++){
        	for(int j = 0;j<n ;j++){
        		if(i==j) continue;
        		int d = getDistance(points[i],points[j]);
        		map.put(d, map.getOrDefault(d, 0)+1);
        	}
        	for(int val:map.values())
        		res +=val*(val-1);
        	map.clear();
        }
        return res;
    }
    
    public int getDistance(int[] a, int[] b){
    	int dX = a[0]-b[0];
    	int dY = a[1]-b[1];
    	return dX*dX+dY*dY;
    }
}
