class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        Integer dp[][] = new Integer[n][k+1];
        return solve(0, k, costs, n, k, dp);
    }

    private int solve(int i, int prev, int costs[][], int n, int k, Integer dp[][]){
        if(i==n) return 0;
        if(dp[i][prev]!=null) return dp[i][prev];
        int ans = Integer.MAX_VALUE;

        for(int j=0;j<k;j++){
            if(prev != j){
                ans = Math.min(ans, costs[i][j] + solve(i+1, j, costs, n, k, dp));
            }
        }

        return dp[i][prev] = ans;
    }
}