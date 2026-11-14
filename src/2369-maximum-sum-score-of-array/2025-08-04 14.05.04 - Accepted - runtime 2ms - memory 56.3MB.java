class Solution {
    public long maximumSumScore(int[] nums) {
        long sum = 0;
        long ans = Long.MIN_VALUE;
        int n = nums.length;

        long suff[]= new long[n+1];
        for(int i=n-1;i>=0;i--){
            suff[i] = suff[i+1] + nums[i];
        }   

        for(int i=0;i<n;i++){
            sum += nums[i];
            ans = Math.max(ans, Math.max(sum, suff[i]));
        }

        return ans;
    }
}