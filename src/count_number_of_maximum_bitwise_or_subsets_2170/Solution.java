package count_number_of_maximum_bitwise_or_subsets_2170;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int x : nums){
            max |= x;
        }
        int n = nums.length;
        Integer dp[][] = new Integer[n][max+1];

        return solve(0, 0, max,nums, n, dp);
    }

    private int solve(int i, int or,int max, int nums[], int n, Integer dp[][]){
        if(i==n){
            if(max == or) return 1;
            return 0;
        }

        if(dp[i][or]!=null) return dp[i][or];

        return dp[i][or] = solve(i+1, or, max, nums, n, dp) + solve(i+1, or | nums[i], max, nums, n, dp);
    }
}