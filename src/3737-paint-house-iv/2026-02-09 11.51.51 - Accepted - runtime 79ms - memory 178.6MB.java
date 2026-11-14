class Solution {
    
    public long minCost(int n, int[][] cost) {
        long dp[][][] = new long[n/2][4][4];
        for(long d1[][] : dp){
            for(long d[] : d1) {
                Arrays.fill(d, -1);
            }
        }
        return solve(n, cost, -1, -1, 0, dp);
    }

    private long solve(int n, int cost[][], int preL, int preR, int i, long dp[][][]){
        if(i==n/2) return 0;

        if(dp[i][preL+1][preR+1]!= -1) return dp[i][preL+1][preR+1];

        long ans= Long.MAX_VALUE;

        for(int j=0;j<3;j++){
            for(int k=0;k<3;k++){
                if(j== k || j == preL || k == preR){
                    continue;
                }
                long temp = solve(n, cost, j, k, i+1, dp);
                if(temp != Long.MAX_VALUE){
                    ans = Math.min(ans, 
                        temp + cost[i][j] + cost[n-i-1][k]
                    );
                }
            }
        }
        return dp[i][preL+1][preR+1] = ans;
    }
}