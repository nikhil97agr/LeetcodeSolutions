class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, nums.length, 0, 0);
    }

    private int solve(int nums[], int n, int i, int xor){
        if(i==n) return xor;

        int ans = 0;

        ans = solve(nums, n, i+1, xor) + solve(nums, n, i+1, xor^nums[i]);
        return ans;
    }
}