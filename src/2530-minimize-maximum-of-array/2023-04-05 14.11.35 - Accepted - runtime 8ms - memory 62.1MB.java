class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            ans = Math.max(ans, (sum+i)/(i+1));
        }
        return (int)ans;
    }
}