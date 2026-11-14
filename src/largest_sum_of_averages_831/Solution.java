package largest_sum_of_averages_831;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        Double dp[][][] = new Double[n][k+1][n+1];
        return solve(0, 0,0, nums, k, n, dp);   
    }

    private double solve(int i, double sum, int cnt, int nums[], int k, int n, Double dp[][][]){
        if(i==n){
            return sum/(1d*cnt);
        }
        if(dp[i][k][cnt]!= null) return dp[i][k][cnt];
        if(sum ==0d || k==1){
            return dp[i][k][cnt] = solve(i+1, sum + nums[i], cnt+1, nums, k, n, dp);
        }

        return dp[i][k][cnt] = Math.max(solve(i+1, sum + nums[i], cnt+1, nums, k, n, dp), solve(i+1, nums[i], 1, nums, k-1, n, dp) + sum/(1d*cnt));



    }

}