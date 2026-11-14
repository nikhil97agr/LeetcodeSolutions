package spiral_matrix_ii_59;

class Solution {
    public int[][] generateMatrix(int n) {
        int next = 1;
        int result[][] = new int[n][n];
        int sr = 0;
        int er = n-1;
        int sc = 0;
        int ec = n-1;
        int i,j;

        while(sr <= er && sc <= ec){
            i = sr;
            j = sc;
            while(j<=ec){
                result[i][j] = next++;
                j++;
            }
            sr++;
            i=sr;
            j = ec;
            while(i<=er){
                result[i][j] = next++;
                i++;
            }
            ec--;
            if(sr>er || sc > ec){
                return result;
            }

            i = er;
            j=ec;
            while(j>=sc){
                result[i][j] = next++;
                j--;
            }
            er--;
            i=er;
            j=sc;
            while(i>=sr){
                result[i][j] = next++;
                i--;
            }
            sc++;
        }
        return result;
    }
}