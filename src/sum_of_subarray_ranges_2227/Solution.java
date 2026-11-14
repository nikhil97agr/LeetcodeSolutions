package sum_of_subarray_ranges_2227;

class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;

            for(int j=i;j<n;j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += (1l*max - min);
            }
        }

        return ans;
    }
}