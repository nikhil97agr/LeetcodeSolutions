package minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix_1409;

class Solution {
    int ans = 1000;
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        solve(mat, m, n,0,0, 0);
        return ans == 1000 ? -1 : ans; 
    }

    private void solve(int mat[][], int m, int n,int i, int j, int step){
        if(step == 10000  ) return;
        if(step >= ans) return;
        if(check(mat, m, n)){

            ans = Math.min(ans, step);
            return;
        }

        if(j==n){
            j=0;
            i++;
        }

        if(i==m) return;


                flip(mat, i, j, m, n);
                solve(mat, m, n,i,j+1, step + 1);
                flip(mat, i, j, m, n);
                solve(mat, m, n, i, j+1, step );


    }

    private void flip(int mat[][], int i, int j, int m, int n){
        mat[i][j] ^= 1;

        if(i+1 < m) mat[i+1][j] ^= 1;
        if(i-1 >=0) mat[i-1][j] ^= 1;

        if(j+1 < n ) mat[i][j+1] ^= 1;
        if(j-1 >= 0) mat[i][j-1] ^= 1;
    }

    private boolean check(int mat[][], int m, int n){
        int cnt = 0;
        for(int x[]: mat){
            for(int y : x){
                if(y==0) cnt++;
            }
        }
        

        return cnt == m*n;
    }
}