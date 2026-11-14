class Solution {

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {

        int m = grid.length;
        int n = grid[0].length;


        int pre[][]= buildPref(grid, m, n);
        if(pre[m-1][n-1] == m*n){
            return true;
        }
        if(stampHeight > m || stampWidth > n){
             return false;
        }

        if (1l * stampHeight * stampWidth == 1l*m * n) {
            return pre[m - 1][n - 1] == 0;
        }
        int stamp[][] = new int[m][n];
        for (int i = 0; i + stampHeight <= m; i++) {
            for (int j = 0; j + stampWidth <= n; j++) {
                int i1 = i + stampHeight - 1;
                int i2 = j + stampWidth - 1;
                var val = pre[i1][i2];
                if (i > 0) {
                    val -= pre[i - 1][i2];
                }

                if (j > 0) {
                    val -= pre[i1][j - 1];
                }

                if (i > 0 && j > 0) {
                    val += pre[i-1][j-1];
                }
                
                if(val == 0){
                    stamp[i][j] = 1;
                }
            }
        }
        
        int pre2[][] = buildPref(stamp, m, n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;

                int i1 = Math.max(0, i - stampHeight + 1);
                int i2 = Math.max(0, j - stampWidth + 1);
                var val = pre2[i][j];
                if (i1 > 0) {
                    val -= pre2[i1 - 1][j];
                }

                if (i2 > 0) {
                    val -= pre2[i][i2 - 1];
                }

                if (i1 > 0 && i2 > 0) {
                    val += pre2[i1-1][i2-1];
                }
                
                
                if(val ==0) return false;
            }
        }
        
        return true;

    }

    private int[][] buildPref(int grid[][], int m, int n){
        int pre[][] = new int[m][n];

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    pre[i][j] = grid[i][j];
                } else if (i == 0) {
                    pre[i][j] = pre[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    pre[i][j] = pre[i - 1][j] + grid[i][j];
                } else {
                    pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i][j];
                }
            }
        }
        return pre;
    }
}