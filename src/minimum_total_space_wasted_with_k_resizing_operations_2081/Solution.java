package minimum_total_space_wasted_with_k_resizing_operations_2081;

class Solution {

    Integer dp[][];

    public int minSpaceWastedKResizing(int[] nums, int k) {
        dp = new Integer[nums.length][k+2];
        
        return solve(0, k+1, nums, nums.length);
    }

    private int solve(int i, int k, int nums[], int n) {

        if (i + k >= n) {
            return 0;
        }

        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][k] != null) {
            return dp[i][k];
        }
        
        int ans = solve(i+1, k-1, nums, n);
        int total =nums[i];
        int max = nums[i];
        for(int j=i+1;j<n;j++){
            max = Math.max(nums[j] , max);
            total += nums[j];
            
            int steps = max * (j - i + 1) - total;
            int another = solve(j+1, k-1, nums, n);
            
            if(another != Integer.MAX_VALUE){
                ans = Math.min(ans, steps + another);
            }
            
        }
        
        return dp[i][k] = ans;
        

    }
}