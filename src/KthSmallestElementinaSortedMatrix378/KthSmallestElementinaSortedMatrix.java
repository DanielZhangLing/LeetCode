package KthSmallestElementinaSortedMatrix378;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0 ; j<n;j++){
        	Tuple t = new Tuple();
        	t.x = 0;
        	t.y = j;
        	t.val = matrix[0][j];
        	pq.offer(t);
        }
        for(int i=0; i<k-1;i++){
        	Tuple t = pq.poll();
        	if(t.x == n-1)
        		continue;
        	else
        		pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
        	
    }
    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
class Tuple implements Comparable<Tuple>{
	int x,y,val;

	public Tuple(){}
	public Tuple(int x, int y,int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public int compareTo(Tuple o) {
		// TODO Auto-generated method stub
		return this.val-o.val;
	}
	
	
}
