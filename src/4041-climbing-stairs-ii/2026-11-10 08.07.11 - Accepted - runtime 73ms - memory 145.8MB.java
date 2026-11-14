class Solution {
    public int climbStairs(int n, int[] costs) {
        Long dp[] = new Long[n];


        long ans = solve(dp, n, 0, costs);

            return (int)ans;
        
    }

    private long solve(Long dp[], int n, int i, int costs[]){
        if(i > n){
            return Integer.MAX_VALUE;
        }

        if(i==n){
            return costs[i-1];
        }

        if(dp[i]!=null) return dp[i];


        return dp[i] = (i==0 ? 0 : costs[i-1]) + Math.min(
           solve(dp, n, i+1, costs) + 1 ,
            Math.min(
              solve(dp, n, i+2, costs) + 4  ,
                solve(dp, n, i+3, costs) + 9
            )
        );
    }
}