package minimum_cost_to_merge_stones_1042;

class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        
        if((n-1)%(k-1)!=0) return -1;

        Integer dp[][][] = new Integer[n+1][n+1][k+1];

        int prefix[] = new int[n+1];

        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] + stones[i-1];
        }

        return solve(0, n-1, 1, prefix, k, dp);
    }

    private int solve(int i, int j, int piles, int pre[], int k, Integer dp[][][]){
        if(i==j && piles == 1){
            return 0;
        }

        if(i==j) return 1000000;

        if(dp[i][j][piles]!=null) return dp[i][j][piles];


        if(piles == 1){
            return dp[i][j][piles] = solve(i, j, k, pre, k, dp) + pre[j+1] - pre[i];
        }else{
            int ans = 1000000;

            for(int t=i;t<j;t++){
                ans = Math.min(
                    ans,
                    solve(i, t, 1, pre, k, dp) + solve(t+1, j, piles-1, pre, k, dp)
                );
                
            }

            return dp[i][j][piles]= ans;
        }
    }
}