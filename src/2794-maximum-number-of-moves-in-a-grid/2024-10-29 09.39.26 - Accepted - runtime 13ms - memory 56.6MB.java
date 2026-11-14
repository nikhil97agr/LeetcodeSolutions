class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[] = new int[n];
        Arrays.fill(dp, 0);
        for(int i=m-2;i>=0;i--){
            int temp[] = new int[n];

            Arrays.fill(temp, 0);
            for(int j=0;j<n;j++){
                if(j-1 >= 0 && grid[j-1][i+1] > grid[j][i]){
                    temp[j] = Math.max(temp[j], dp[j-1]+1);
                }

                if( j+1 <n && grid[j+1][i+1] > grid[j][i]){
                    temp[j] = Math.max(temp[j], dp[j+1] + 1);
                }

                if(grid[j][i+1] > grid[j][i]){
                    temp[j] = Math.max(temp[j], dp[j]+1);
                }
            }

            dp = temp;
        }

        int ans = 0;

        for(int x : dp){
            ans = Math.max(ans, x);
        }
        return ans;

    }
}