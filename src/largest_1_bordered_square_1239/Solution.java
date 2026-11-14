package largest_1_bordered_square_1239;

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int min = Math.min(n, m);
        int hCnt[][] = new int[n][m];
        int vCnt[][] = new int[n][m];
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    cnt++;
                }else{
                    cnt = 0;
                }
                hCnt[i][j] = cnt;
            }
        }

        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(grid[j][i] == 1){
                    cnt++;
                }else{
                    cnt = 0;
                }
                vCnt[j][i] = cnt;
            }
        }

        for(int len = min;len >= 1;len--){
            if(check(len, hCnt, vCnt, n, m)){
                return len * len;
            }
        }

        return 0;
    }

    private boolean check(int len, int hCnt[][], int vCnt[][], int n, int m){
        for(int i=0;i+len-1 < n;i++){
            for(int j=0;j+len-1 < m;j++){
                if(hCnt[i][j+len-1] >= len && vCnt[i+len-1][j] >= len && hCnt[i+len-1][j+len-1] >= len && vCnt[i+len-1][j+len-1] >= len) return true;
            }
        }

        return false;
    }
}