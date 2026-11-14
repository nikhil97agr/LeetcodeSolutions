class Solution {
    public int stoneGameV(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0]= nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        Integer dp[][] = new Integer[n][n];
        return solve(0, n-1, pre, nums, dp);
    }

    private int solve(int start, int end, int pre[], int nums[], Integer dp[][]){
        if(start >= end) return 0;
        if(dp[start][end]!=null) return dp[start][end];
        int sum =0;
        int sum2 = pre[end] - (start == 0 ? 0 : pre[start-1]);
        int i=start;
        int ans = 0;
        while(i < end){
            sum += nums[i];
            sum2 -= nums[i];

            if(sum > sum2){
                ans = Math.max(ans, sum2 + solve(i+1, end, pre, nums, dp));
            }else if(sum < sum2){
                ans = Math.max(ans, sum + solve(start, i, pre, nums, dp));
            }else{
                ans = Math.max(ans,
                Math.max(
                    sum2 + solve(i+1, end, pre, nums, dp),
                    sum + solve(start, i, pre, nums, dp)
                ));
            }
            i++;
        }

        return dp[start][end] = ans;
    }
}