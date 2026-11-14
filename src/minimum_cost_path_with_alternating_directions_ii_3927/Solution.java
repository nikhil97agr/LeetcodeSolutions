package minimum_cost_path_with_alternating_directions_ii_3927;

class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        Long dp[][][]= new Long[m][n][2];
        return 1 + solve(0, 0, waitCost, m, n, 1, dp);
    }

    private long solve(int i, int j, int cost[][], int n, int m, int sec, Long dp[][][]){
        if(i==n-1 && j == m-1){
            return 0;
        }
        if(dp[i][j][sec]!=null) return dp[i][j][sec];
        long ans = (1l<<53) -1;

        int diff[][] = new int[][]{{0,1},{1,0}};

        for(int d[] : diff){
            int ni = i  + d[0];
            int nj = j + d[1];


            if(ni >=0 && ni < n && nj >=0 && nj < m){
                long temp = solve(ni, nj, cost, n, m, 0, dp);
                    if(temp != ((1l<<53) -1)) {
                        ans = Math.min(ans, (long) (sec % 2 == 0 ? cost[i][j] : 0) + (long) (ni + 1) * (nj + 1) + temp);
                    }
            }


        }
        return dp[i][j][sec]= ans;
    }
}