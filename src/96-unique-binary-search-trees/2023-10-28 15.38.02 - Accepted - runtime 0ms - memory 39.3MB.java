class Solution {
    public int numTrees(int n) {
        Integer dp[] = new Integer[n+1];
        
        dp[0] = dp[1] = 1;

        int total = 0;
        for(int i=1;i<=n;i++){
            total += solve(1, i-1, i-1, dp)*solve(i+1, n, n-i, dp);
        }

        return total;
    }

    private int solve(int start, int end, int nodes, Integer dp[]){
        if(nodes==0 || nodes==1) return 1;

        if(dp[nodes]!=null) return dp[nodes];

        int total = 0;
        for(int i=start;i<=end;i++){
            total += solve(start, i-1, i-start, dp)*solve(i+1, end, end-i, dp);
        }

        return dp[nodes] = total;
    }
}