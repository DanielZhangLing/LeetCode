package SparseMatrixMultiplication311;

public class SparseMatrixMultiplication {

	//n^3
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();
        
        for(int k = 0; k < n; k++) {
            tableB.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < l; j++) {
                if (B[k][j] != 0){
                    tableB.get(k).put(j, B[k][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (Integer j: tableB.get(k).keySet()) {
                        C[i][j] += A[i][k] * tableB.get(k).get(j);
                    }
                }
            }
        }
        return C;   
    }
	/*
	 * As you can see from above: for the same value A[i][k] from the first matrix, 
	 * it will be used at most nB times if A[i][k] is not zero. 
	 * And the smart solution is taking advantage of that!!!,
	 *  the smart solution can be described as:

For each value A[i][k] in matrix A, if it is not zero, 
we calculate A[i][k] * B[k][j] and accumulate it into C[ i ][ j ]
 (Key part: the C[ i ][ j ] by now is not the final value in the result matrix !! 
 Remember, in the brute force solution, the final value of C[i][j],
  takes sum of all multiplication values of K corresponding values from A and B?
   here C[ i ][ j ] is only sum of some multiplication values, 
   NOT ALL until the program is done )
	 */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
            	//????????
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
    
    /**
     * brute force
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
                for (int j = 0; j < nB; j++) {
                    for(int k = 0; k < n; k++) {
                         C[i][j] += A[i][k] * B[k][j];
                    }
                }
        }
        return C;  
    }
}
