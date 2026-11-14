class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][2];

        for(int[] d : dp){
            Arrays.fill(d, -1);
        }


        return solve(dp,nums, 0, n, 0);
    }

    private int solve(int dp[][], int nums[], int i, int n, int j){
        if(i>=n){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(i==0){
            return dp[i][j] = Math.max(solve(dp, nums, i+1, n, 0), solve(dp, nums, i+2, n, 1)+nums[i]); 
        }

        if(i==n-1){
            if(j==1){
                return 0;
            }
            return nums[i];
        }

        dp[i][j] = Math.max(solve(dp, nums,i+1, n, j), solve(dp, nums, i+2, n, j)+nums[i]);

        return dp[i][j];
    }




}