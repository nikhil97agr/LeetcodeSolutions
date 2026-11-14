package minimum_array_sum_3654;

class Solution {
    Integer dp[][][];
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        dp = new Integer[nums.length][op1 +1][op2+1];
        return solve(nums, k, op1, op2, 0, nums.length);
    }

    private int solve(int nums[], int k, int op1, int op2, int i, int n){
        if(i==n) return 0;
        if(dp[i][op1][op2] !=null) return dp[i][op1][op2];
        int ans = nums[i] + solve(nums, k, op1, op2, i+1,n);
        if(op1 ==0 && op2==0){
            return dp[i][op1][op2] = ans;
        }

        if(op2 !=0 && nums[i]>=k){
            ans = Math.min(ans, nums[i] - k + solve(nums, k, op1, op2 -1, i+1, n));
        }
        
         if(op1 !=0){
            ans = Math.min(ans, (nums[i] + 1)/2 + solve(nums, k, op1 -1, op2, i+1, n));
        }
        
        if(op1 !=0 && op2 !=0){
            int v1 =(nums[i] + 1)/2;
            int v2 = nums[i] - k;

            if(v1 >= k){
                ans = Math.min(ans, v1 - k + solve(nums, k, op1 - 1, op2 - 1, i+1, n));
            }

            if(v2 >= 0){
                ans = Math.min(ans, (v2+1)/2 + solve(nums,k, op1-1, op2-1, i+1, n));
            }
        }

        return dp[i][op1][op2] =ans;
    }
}