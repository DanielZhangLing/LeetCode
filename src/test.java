import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                res[j][m-1-i] = matrix[i][j];
            }
        }
		for(int[] i: res){
			for(int elm:i){
				System.out.println(elm);
			}
		}
        matrix =  res;
    }

	public static void main(String[] args){
			int[] a  =new int[5];
			for(int i: a){
				System.out.println(i);
		}
		
	
	}
}
