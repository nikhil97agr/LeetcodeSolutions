import java.util.Arrays;

class Solution {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length;

        int dp[][] = new int[maxTime + 1][n];
        for (int d[] : dp) {
            Arrays.fill(d, 1_000_000_0);
        }

        dp[0][0] = passingFees[0];
        for (int currTime = 0; currTime <= maxTime; currTime++) {
            for (var e : edges) {
                int u = e[0];
                int v = e[1];
                int time = e[2];
                int nextTime = currTime + time;
                if (nextTime > maxTime) {
                    continue;
                }
                dp[nextTime][v] = Math.min(dp[nextTime][v] , dp[currTime][u] + passingFees[v]);
                dp[nextTime][u] = Math.min(dp[nextTime][u], dp[currTime][v] + passingFees[u]);
            }
        }

        int ans = 1_000_000_0;
        for (int i = 0; i <= maxTime; i++) {
            ans = Math.min(ans, dp[i][n - 1]);
        }
        return ans == 1_000_000_0 ? -1 : ans;
    }

}