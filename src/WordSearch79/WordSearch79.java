package WordSearch79;

public class WordSearch79 {

	
	/*
	 * dfs use a visit to record vist or not
	 */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(find(board, visit,w, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean find(char[][] board, boolean[][] visit, char[] w, int i, int j, int index){
        if(index==w.length)
            return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        if(visit[i][j])
            return false;
        if(board[i][j]!=w[index])
            return false;
        visit[i][j] = true;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for(int k = 0; k<4; k++){
            if(find(board, visit,w, i+dx[k], j+dy[k], index+1))
                return true;
        }
        visit[i][j] = false;// remember to delete if this path is not working
        return false;
        
    }
}
