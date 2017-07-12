package MinimumNumberofArrowstoBurstBalloons452;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
    	if(points.equals(null)||points.length==0||points[0].length==0)
    		return 0;
    	Arrays.sort(points,(a,b)->a[0]-b[0]);
    	int rightLimit = points[0][1];
    	int count =1;
    	for(int i=1; i<points.length;i++){
    		if(points[i][0]>rightLimit){
    			count++;
    			rightLimit = points[i][1];
    		}
    		else
    			rightLimit = Math.min(rightLimit, points[i][1]);
    	}
    	return count;
    }
    

}
