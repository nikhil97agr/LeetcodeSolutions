class Solution {
    public int minFlips(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m= grid[0].length;
        int one = 0;
        int diff = 0;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                int total = grid[i][j] + grid[i][m-1-j] + grid[n-1-i][j] + grid[n-1-i][m-1-j];
                ans += Math.min(total, 4 - total);
            }
        }

        if(n%2==1){
            for(int i=0;i<m/2;i++){
                int a= grid[n/2][i];
                int b = grid[n/2][m-1-i];
                diff += a^b;
                one += a + b;
            }

        }

        if(m%2==1){
            for(int i=0;i<n/2;i++){
                int a = grid[i][m/2];
                int b = grid[n- i -1][m/2];
                diff += a ^ b;
                one += a + b;
            }
        }

        if(n%2==1 && m%2==1){
            int val = grid[n/2][m/2];
            ans += val;
        }

        if(diff == 0 && one%4!=0){
            ans += 2;
        }
        return ans + diff;
    }
}