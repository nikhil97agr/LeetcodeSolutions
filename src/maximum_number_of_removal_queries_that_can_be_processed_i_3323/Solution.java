package maximum_number_of_removal_queries_that_can_be_processed_i_3323;

class Solution {
    Integer dp[][];
    public int maximumProcessableQueries(int[] nums, int[] queries) {
        int ans = 0;
        int q = queries.length;
        int n= nums.length;
        dp = new Integer[n][n+1];
        for(int i=0;i<n;i++){
            ans = Math.max(ans, solve(nums, queries, i, i, q, n ));
        }

        return ans;
    }

    private int solve(int nums[], int queries[], int l, int r, int q, int n){
        if(dp[l][r] !=null) return dp[l][r];
        int a = l > 0 ? solve(nums, queries, l-1, r, q,n) : -1;
        int b = r < n ? solve(nums, queries, l, r+1, q, n) : -1;

        int ans = Math.max(Math.max(a,b), 0);
        if(a >=0 && a < q && nums[l-1] >= queries[a]){
            ans = Math.max(ans, a + 1);
        }

        if(b >=0 && b < q && nums[r] >= queries[b]){
            ans = Math.max(ans, b + 1);
        }

        return dp[l][r] = ans;
    }
}