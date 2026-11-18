package burst_balloons_312;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n+1][n+1];
        int arr[] = new int[n+2];
        arr[0] = arr[n+1]  = 1;
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];
        }

        return solve(arr, 1, n, dp);
    }

    private int solve(int nums[], int left, int right, Integer dp[][]){
        if(left > right) return 0;
        int ans = 0;
        if(dp[left][right]!=null) return dp[left][right];
        for(int i=left;i<=right;i++){
            int coins = nums[left-1]*nums[i]*nums[right+1];

            int remain = solve(nums, left, i-1, dp) + solve(nums, i+1, right, dp);

            ans = Math.max(ans, coins + remain);
        }

        return dp[left][right] = ans;
    }
}