package partition_equal_subset_sum_416;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }

        if(sum%2==1){
            return false;
        }
        sum/=2;
        Boolean dp[][] = new Boolean [n][sum+1];

        return solve(nums, dp, sum , 0, n);
    }

    private boolean solve(int nums[], Boolean dp[][], int sum, int i, int n){
        if(sum==0){
            return true;
        }

        if(sum < 0 || i==n){
            return false;
        }

        if(dp[i][sum]!=null){
            return dp[i][sum];
        }

        dp[i][sum] = solve(nums, dp, sum - nums[i], i+1, n) || solve(nums, dp, sum, i+1, n);
        return dp[i][sum];
    }
}