class Solution {
    public int maxScore(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int sum = grid[i][0];
            for(int j=1;j<m;j++){
                sum += grid[i][j];
                ans = Math.max(ans, sum);

                if(i > 0 && i < n-1 && j > 0 && j < m-1){
                    ans = Math.max(ans, grid[i][j]);
                }

                sum = Math.max(sum, grid[i][j]);
            }

        }

        for(int i=0;i<m;i++){
            int sum =grid[0][i];
            for(int j=1;j<n;j++){
                sum += grid[j][i];
                ans = Math.max(ans, sum);

                if( i > 0 && i < m-1 && j > 0 && j < n-1){
                    ans = Math.max(ans, grid[j][i]);
                }

                sum = Math.max(sum, grid[j][i]);
            }
        }

        return ans;
    }

}