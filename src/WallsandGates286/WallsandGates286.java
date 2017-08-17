package WallsandGates286;

public class WallsandGates286 {
	/*
	 * count from gate back to other point
	 * use a queue to maintain a bfs
	 * let all gate step at the same time
	 * O(m*n)
	 */
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null||rooms.length==0){
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i<m; i++){
            for(int j = 0 ; j<n; j++){
                if(rooms[i][j]==0)
                    q.add(new int[]{i, j });
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i<q.size() ; i++){
                int[] now = q.poll();
                int row = now[0];
                int col = now[1];
                for(int k = 0; k<4; k++){
                    int newR = row+dx[k];
                    int newC = col+dy[k];
                    if(newR<0||newR>=m||newC<0||newC>=n||rooms[newR][newC]!=Integer.MAX_VALUE)
                        continue;
                    else{
                        rooms[newR][newC] = rooms[row][col]+1;
                        q.add(new int[]{newR,newC});
                    }
                }
            }
        }
    }
}
