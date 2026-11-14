class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        Long dp[][] = new Long[n][2];

        return solve(0,0, nums, nums.length, dp );
    }

    private long solve(int ind, int parity, int nums[], int n, Long dp[][]){
        if(ind == n){
            return 0l;
        }

        if(dp[ind][parity]!=null) return dp[ind][parity];

        if(parity == 0){
            return dp[ind][parity] = Math.max(
                nums[ind] + solve(ind+1, 1, nums, n, dp),
                solve(ind + 1, parity, nums,n , dp)
            );
        }else{
            return dp[ind][parity] = Math.max(
                -nums[ind] + solve(ind+1, 0, nums, n, dp),
                solve(ind+1, parity, nums,n, dp)
            );
        }
    }
}