package NumberofIslands200;

public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid==null||grid.length==0||grid[0].length ==0)
            return res;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j]!='0'){
                    res++;
                    flip(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void flip(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int k = 0; k<4; k++){
            int newI = dx[k]+i;
            int newJ = dy[k]+j;
            if(newI>=0&&newI<grid.length&&newJ>=0&&newJ<grid[0].length&&grid[newI][newJ]!='0'){
                flip(grid, newI, newJ);
            }
        }
        return;
    }
}
