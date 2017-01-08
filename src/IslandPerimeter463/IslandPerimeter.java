package IslandPerimeter463;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
    	
    	int perimeter = 0;
        
    	int[][] temp = new int[grid.length][grid[0].length];
    	for(int i=0; i<grid.length; i++)
    		for(int j=0; j<grid[i].length; j++){
    			if (grid[i][j]>0){
	    			if (i-1>-1)
	    				temp[i-1][j]++;
	    			if (j-1>-1)
	    				temp[i][j-1]++;
	    			if (i+1<grid.length)
	    				temp[i+1][j]++;
	    			if (j+1<grid[i].length)
	    				temp[i][j+1]++;
    			}
    		}
    	for(int i=0; i<grid.length; i++)
    		for(int j=0; j<grid[i].length; j++)
    			if (grid[i][j]>0)
    				perimeter+= 4-temp[i][j];
    	
    	return perimeter;
    }
    public static void main(String[] args){
    	IslandPerimeter test = new IslandPerimeter();
    	int[][] data = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    	System.out.println(test.islandPerimeter(data));
    }
}
