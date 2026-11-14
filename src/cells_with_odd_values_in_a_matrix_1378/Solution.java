package cells_with_odd_values_in_a_matrix_1378;

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int mat[][] = new int[m][n];
        for(int ind[] : indices){
            int r = ind[0];
            int c = ind[1];
            for(int i=0;i<n;i++){
                    mat[r][i]++;
            }

            for(int i=0;i<m;i++){
                    mat[i][c]++;
            }

        }
        int cnt = 0;
        for(int mt[] : mat){
            for(int x : mt){
                if(x%2==1)cnt++;
            }
        }
        return cnt;
    }
}