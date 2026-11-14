package reshape_the_matrix_566;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(r*c!=m*n){
            return mat;
        }
        int result[][] =new int[r][c];
        int i =0;
        int j = 0;
        while(i<m*n){
            int row = i/n;
            int col = i%n;
            int row1 = j/c;
            int col1 = j%c;
 
            result[row1][col1] = mat[row][col];
            j++;
            i++;
        }

        return result;
    }
}