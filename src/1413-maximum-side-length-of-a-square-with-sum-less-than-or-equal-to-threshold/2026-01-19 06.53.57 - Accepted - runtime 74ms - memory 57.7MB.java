class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int preSum[][] = new int[n][m];
        preSum[0][0]= mat[0][0];
        for(int i=1;i<n;i++){
            preSum[i][0] = preSum[i-1][0] + mat[i][0];
        }

        for(int j=1;j<m;j++){
            preSum[0][j] = preSum[0][j-1] + mat[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mat[i][j];
            }
        }

        for(int len = Math.min(m, n);len > 0 ;len--){
            for(int i=0;i+len <= n;i++){
                for(int j=0;j+len <= m;j++){
                    int bx = i+len - 1;
                    int by = j + len - 1;

                    int sum = preSum[bx][by] - (j-1 >=0 ? preSum[bx][j-1] : 0) - (i-1 >=0 ? preSum[i-1][by] : 0 ) + (i-1 >=0 && j-1>=0 ? preSum[i-1][j-1] : 0);

                    if(sum <= threshold) return len;
                }
            }
        }


        return 0;
    }
}