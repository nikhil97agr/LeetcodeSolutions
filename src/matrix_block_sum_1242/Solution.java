package matrix_block_sum_1242;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int sum [][] = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int ans[][] = new int[m][n];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int minr = Math.max(1, i-k);
                int minc = Math.max(1, j-k);
                int maxr = Math.min(m, i+k);
                int maxc = Math.min(n, j+k);

                ans[i-1][j-1] = sum[maxr][maxc] - sum[minr-1][maxc] - sum[maxr][minc-1] + sum[minr-1][minc-1];
            }
        }


        return ans;

    }
}