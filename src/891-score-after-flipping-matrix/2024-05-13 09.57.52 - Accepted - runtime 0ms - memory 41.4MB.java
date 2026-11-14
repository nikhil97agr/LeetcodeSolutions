class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0){
                for(int j=0;j<n;j++){
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(grid[j][i] == 0){
                    cnt++;
                }
            }
            if(cnt > m/2){
                for(int j=0;j<m;j++){
                    grid[j][i] = (grid[j][i] == 0) ? 1 : 0;
                }
            }
        }


        int ans = 0;
        for(int i=0;i<m;i++){
            int temp =0;
            int x = 0;
            for(int j=n-1;j>=0;j--){
                temp = temp | (grid[i][j] << x);
                x++;
            }
            ans += temp;
        }

        return ans;
    }
}