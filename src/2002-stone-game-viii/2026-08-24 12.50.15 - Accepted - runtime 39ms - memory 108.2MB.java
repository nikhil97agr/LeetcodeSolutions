class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int pre[] = new int[n];
        pre[0] = stones[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + stones[i];
        }
        Integer dp[] = new Integer[n];

        return solve(pre, 1, dp);
    }

    private int solve(int pre[], int i, Integer dp[]){
        if(i == pre.length -1){
            return pre[i];
        }

        if(dp[i] !=null) return dp[i];
        return dp[i] = Math.max(solve(pre, i+1, dp), pre[i] - solve(pre, i+1, dp));
    }
}