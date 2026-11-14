package increment_submatrices_by_one_2625;

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int pre[][] = new int[n][n+1];

        for(int q[] : queries){
            for(int i=q[0];i <= q[2];i++){
                pre[i][q[1]]++;
                pre[i][q[3]+1]--;
            }
        }
        int res[][] = new int[n][n];

        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=0;j<n;j++){
                sum += pre[i][j];
                res[i][j] = sum;
            }
        }

        return res;
    }
}