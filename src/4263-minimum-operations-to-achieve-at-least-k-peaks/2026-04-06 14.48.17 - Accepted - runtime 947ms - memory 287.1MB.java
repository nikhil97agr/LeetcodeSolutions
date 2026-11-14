class Solution {
    int cost[];
    Integer dp[][];
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return 0;
        if(k > n/2) return -1;
        cost = new int[n];
        dp = new Integer[n][k+1];

        for(int i=0;i<n;i++){
            int left = nums[(i-1+n)%n];
            int right = nums[(i+1)%n];

            int max= Math.max(left, right) + 1;
            cost[i] = Math.max(0, max - nums[i]);
        }

        int a = solve(2, n-1, k-1, nums);
        if(a != Integer.MAX_VALUE){
            a += cost[0];
        }
        dp = new Integer[n][k+1];
        int b = solve(1, n, k, nums);

        int ans = Math.min(a,b);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int i, int n, int k, int nums[]){
        if(k ==0){
            return 0;
        }
        
        if(i >=n) return Integer.MAX_VALUE;

        if(dp[i][k]!=null) return dp[i][k];
        
        int skip = solve(i+1, n, k, nums);
        int take = solve(i+2, n, k-1, nums);
        

        if(take != Integer.MAX_VALUE){
            take = cost[i] + take;
        }
        return dp[i][k]= Math.min(take, skip);
    }
}