class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        int n= nums.length;
        int q= queries.length;
        int ans[] = new int[q];
        int sqrt = (int)Math.sqrt(n);
        int dp[][] = new int[n][sqrt];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<sqrt;j++){
                dp[i][j] = nums[i];
                dp[i][j] = add(dp[i][j], i+j < n ? dp[i+j][j] : 0);
            }
        }
        for(int i=0;i<q;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            
            if(y >= sqrt){
                int sum = 0;
                for(int j=x;j<n;j+=y){
                    sum = add(sum, nums[j]);
                }
                ans[i] = sum;
                continue;
            }

            ans[i] = dp[x][y];




            
        }
        return ans;
    }

    private int add(long a, long b){
        long mod = (long)1e9 + 7;
        return (int)((a+b)%mod);
    }
}