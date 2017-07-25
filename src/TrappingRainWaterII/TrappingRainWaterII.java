package TrappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

class Cell{
    int x;
    int y;
    int h;
    Cell(int x , int y , int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class CellComparator implements Comparator<Cell>{
    public int compare(Cell a, Cell b){
        return a.h-b.h;
    }
}

public class TrappingRainWaterII {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        int res = 0;
        int m = heights[0].length;
        int n = heights.length;
        int[][] visit = new int[n][m];
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(1,new CellComparator());
        for(int i=0; i<n; i++){
            minHeap.offer(new Cell(i,0,heights[i][0]));
            minHeap.offer(new Cell(i,m-1,heights[i][m-1]));
            visit[i][0] = 1;
            visit[i][m-1] = 1;
        }
        for(int i = 0; i<m; i++){
            minHeap.offer(new Cell(0,i,heights[0][i]));
            minHeap.offer(new Cell(n-1, i, heights[n-1][i]));
            visit[0][i] = 1;
            visit[n-1][i] = 1;
        }
        while(!minHeap.isEmpty()){
            Cell curCell = minHeap.poll();
            for(int i = 0; i<4; i++){
                int curX = curCell.x+dx[i];
                int curY = curCell.y+dy[i];
                if(curX>=0&&curY>=0&&curX<n&&curY<m&&1!=visit[curX][curY]){
                    visit[curX][curY] = 1;
                    minHeap.offer(new Cell(curX, curY, Math.max(curCell.h, heights[curX][curY])));
                    res+= Math.max(0, curCell.h-heights[curX][curY]);
                }
            }
        }
        return res;
    }
};