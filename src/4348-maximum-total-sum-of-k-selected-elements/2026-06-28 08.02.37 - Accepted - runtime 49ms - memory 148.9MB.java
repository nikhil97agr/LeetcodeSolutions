class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans = 0;
        
        for(int i=nums.length - 1;i>=0 && k > 0;i--, k--){
            ans += Math.max(1l * mul * nums[i], nums[i]);
            mul--;
        }

        return ans;
    }
}