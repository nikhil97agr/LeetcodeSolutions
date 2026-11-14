package paint_house_iii_1583;

class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer dp[][][] = new Integer[m+1][target+1][n+1];

        int ans = solve(0,0, houses, cost,m, n, target, 0, dp);

        return ans >= 10000000 ? -1 : ans;
    }

    private int solve(int i,int currColor, int houses[], int cost[][], int m, int n, int target, int neighborCnt, Integer dp[][][]){
        if(i==m){
            if(target== neighborCnt) return 0;

            return 10000000;
        }

        if(neighborCnt > target) return 10000000;

        if(dp[i][neighborCnt][currColor]!=null) return dp[i][neighborCnt][currColor];

        if(houses[i]!=0){
            int newCnt = neighborCnt + ((currColor==houses[i]) ? 0 : 1);

          return  dp[i][neighborCnt][currColor] = solve(i+1, houses[i], houses, cost, m, n, target, newCnt,dp);
        }

        int ans = 10000000;
        for(int j=0;j<cost[i].length;j++){
            int cnt = neighborCnt + ((currColor == (j+1) )? 0 : 1);
            ans = Math.min(ans, cost[i][j] + solve(i+1, j+1, houses, cost, m, n, target, cnt, dp));
        }

        return dp[i][neighborCnt][currColor] = ans;
    }
}