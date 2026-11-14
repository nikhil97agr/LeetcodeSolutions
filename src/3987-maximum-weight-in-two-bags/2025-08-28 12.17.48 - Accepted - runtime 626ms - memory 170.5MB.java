class Solution {
    public int maxWeight(int[] weights, int w1, int w2) {
        Integer dp[][][] = new Integer[weights.length][w1+1][w2+1];
        return solve(w1, w2, 0, weights, dp);
    }

    private int solve(int w1, int w2, int i, int weights[], Integer dp[][][]){
        if(i == weights.length) return 0;

        int ans = 0;

        if(dp[i][w1][w2] != null) return dp[i][w1][w2];

        if(w1 >= weights[i]){
            ans = Math.max(ans, weights[i] + solve(w1 - weights[i], w2, i+1, weights,dp));
        }

        if(w2 >= weights[i]){
            ans = Math.max(ans, weights[i] + solve(w1, w2 - weights[i], i+1, weights, dp));
        }

        ans = Math.max(ans, solve(w1, w2, i+1, weights, dp));
        return dp[i][w1][w2] = ans;
    }
}