package BestMeetingPoint296;

import java.util.ArrayList;
import java.util.Arrays;

public class BestMeetingPoint296 {

    public static int minTotalDistance(int[][] grid) {
        
    	ArrayList<Integer> x = new ArrayList();
    	ArrayList<Integer> y = new ArrayList();
    	
    	for(int i=0; i<grid.length;i++)
    		for(int j=0; j<grid[i].length;j++){
    			if(grid[i][j]==1){
    			x.add(i);
    			y.add(j);
    			}	
    }  	
    	return calculateDistance(x)+calculateDistance(y);
	}
    
    public static int calculateDistance(ArrayList<Integer> array){
    	array.sort(null);;
    	int min = 0;
    	int max = array.size()-1;
    	int count = 0;
    	while(min<max){
    		count+= array.get(max)-array.get(min);
    		min++;
    		max--;
    	}
    	return count;
    }
    
    public static void main(String[] args){
    	
    	int[][] data = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    	System.out.println(minTotalDistance(data));
    }
}
