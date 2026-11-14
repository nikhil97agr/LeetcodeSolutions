class Solution {
    public int maxSumDivThree(int[] nums) {
        Integer dp[][] = new Integer[nums.length][3];

        int ans =  solve(nums, 0, 0, nums.length, dp);

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private int solve(int nums[], int mod, int i, int n, Integer dp[][]){
        if(i==n){
            return mod ==0 ? 0 : Integer.MIN_VALUE;
        }

        if(dp[i][mod]!=null) return dp[i][mod];


        int ans1 = solve(nums, (mod + nums[i])%3, i+1, n, dp);
        int ans2 = solve(nums, mod, i+1, n, dp);

        if(ans1!= Integer.MIN_VALUE){
            ans1 += nums[i];
        }

        return dp[i][mod] = Math.max(ans1, ans2);
    }
}