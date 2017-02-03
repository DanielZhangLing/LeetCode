package DesignTicTacToe348;

import BinaryTreeInorderTraversal94.TreeNode;

public class DesignTicTacToe {
	
	int[] horizontal, vertical ;
	int[] diagonal = {0,0};
	int len;
	int result = 0;
    public DesignTicTacToe(int n) {
    	if(n<1){
    		result = -1;
    	}
	    else{
	    	len = n;
	        horizontal = new int[n];    
	        vertical = new int[n];
	        for(int i=0;i<len; i++){
	        	horizontal[i] = 0;
	        	vertical[i] = 0;
	        }
    	}
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
    	if(result!=0) 
    		return result;
    	if(row==col)
    		if(Math.abs(player==1?++diagonal[0]:--diagonal[0])==len){
    			result = player;
    			return player;
    		}
    	if(row+col==len-2)
    		if(Math.abs(player==1?++diagonal[1]:--diagonal[1])==len){
    			result = player;
    			return player;
    		}
    	
		if(Math.abs(player==1?++horizontal[row]:--horizontal[row])==len){
			result = player;
			return player;
		}
		
		if(Math.abs(player==1?++vertical[col]:--vertical[col])==len){
			result = player;
			return player;
		}
		
		return 0;	
    }
    
	public static void main(String[] args){
		int[] a = {1,1};
		System.out.println(++a[0]);
	}
}
