package KthLargestinNArrays;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int x, y, val;
    Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.val - b.val;
    }
} 


public class KthLargestinNArrays {
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int height = matrix.length;
        int width = matrix[0].length;
        int[] dx = {0,1};
        int[] dy = {1,0};
        boolean[][] temp = new boolean[height][width];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0,0,matrix[0][0]));
        
        for(int i=0; i<k-1; i++){
            Pair cur = minHeap.poll();
            for(int j=0; j<2; j++){
                int tempX = cur.x+dx[j];
                int tempY = cur.y+dy[j];
                if(tempX<height&&tempY<width&&!temp[tempX][tempY]){
                    temp[tempX][tempY] = true;
                    minHeap.add(new Pair(tempX, tempY, matrix[tempX][tempY]));
                }
            }
        }
        return minHeap.poll().val;
        }
}
