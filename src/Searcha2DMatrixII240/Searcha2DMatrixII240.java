package Searcha2DMatrixII240;

public class Searcha2DMatrixII240 {
	/*
	 * We start search the matrix from top right corner,
	 *  initialize the current position to top right corner,
	 *   if the target is greater than the value in current position,
	 *    then the target can not be in entire row of current position
	 *     because the row is sorted,
	 *      if the target is less than the value in current position,
	 *       then the target can not in the entire column 
	 *       because the column is sorted too. 
	 *       We can rule out one row or one column each time, 
	 *       so the time complexity is O(m+n).
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
	/*
	 * failed too slow
	 */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        return dfs(0,0,matrix, target);
    }
    private boolean dfs(int i, int j, int[][] matrix, int target){
        if(i>=matrix.length||j>=matrix[0].length||matrix[i][j]>target)
            return false;
        if(matrix[i][j]==target)
            return true;
        return dfs(i+1,j,matrix,target)||dfs(i,j+1,matrix,target);
    }
}
