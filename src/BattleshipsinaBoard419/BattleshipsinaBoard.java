package BattleshipsinaBoard419;

public class BattleshipsinaBoard {
    public static int countBattleships(char[][] board) {
        int result = 0;
    	for (int i = 0;i<board.length;i++)
    	{
    		for(int j = 0; j<board[i].length;j++)
    		{
    			if(board[i][j]=='.' || ((board[i][j]=='X' && ((i>0&&board[i-1][j]=='X')||(j>0&&board[i][j-1]=='X')))))
    				continue;
    			result++;
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		char[][] str = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println (countBattleships(str));
	}
}
