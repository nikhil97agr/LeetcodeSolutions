class Solution {
    public int minCost(int[][] costs) {
        Integer dp[][] = new Integer[costs.length][3];
        return Math.min(solve(0, 0, costs, costs.length, dp),
        Math.min(solve(0, 1, costs, costs.length, dp), solve(0,2, costs, costs.length, dp)));
    }

    private int solve(int i, int prev, int costs[][], int n, Integer dp[][]){
        if(i==n) return 0;
        if(dp[i][prev] !=null) return dp[i][prev];
        switch(prev){
            case 0 :
            return dp[i][prev] = Math.min(solve(i+1, 1, costs,n, dp) + costs[i][1], solve(i+1, 2, costs, n, dp) + costs[i][2]);

            case 1 :
            return dp[i][prev] = Math.min(solve(i+1, 0, costs,n, dp) + costs[i][0], solve(i+1, 2, costs, n, dp) + costs[i][2]);

            case 2 :
            return dp[i][prev] = Math.min(solve(i+1, 1, costs,n, dp) + costs[i][1], solve(i+1, 0, costs, n, dp) + costs[i][0]);
        }

        return 0;
    }
}