class Solution {
    int parent[];
    int score[];
    int n;
    int max;
    Integer dp[];
    public int maxProfit(int n, int[][] edges, int[] score) {
        parent = new int[n];
        this.n = n;
        max = (1<<n) -1;
        this.score = score;
        dp = new Integer[max+1];
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];

            parent[v] = parent[v] | (1<<u);
        }

        return solve(max, 1);
    }

    private int solve(int mask, int pos){
        if(mask == 0) return 0;
        if(dp[mask]!=null) return dp[mask];
        int ans = 0;
        for(int i=0;i<n;i++){
            if((mask & (1<<i)) !=0){
                if((parent[i] & (mask))==0){
                    ans = Math.max(ans, pos * score[i] + solve( mask ^ (1<<i), pos + 1));
                }
            }
        }
        return dp[mask] = ans;
    }
}