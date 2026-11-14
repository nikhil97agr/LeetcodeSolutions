package minimum_removals_to_achieve_target_xor_4097;

class Solution {
    Integer dp[][];
    public int minRemovals(int[] nums, int target) {
        dp = new Integer[nums.length][1<<15];
        
        int ans = solve(0, nums.length, nums, 0, target);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int i, int n, int nums[], int xor, int target){
        if(i==n){
            if(xor == target){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(dp[i][xor]!=null) return dp[i][xor];

        int remove = solve(i+1, n, nums,xor, target);
        int notRemove = solve(i+1, n,nums, xor ^ nums[i], target);
        if(remove != Integer.MAX_VALUE){
            remove++;
        }

        return dp[i][xor] = Math.min(remove, notRemove);
    }
}