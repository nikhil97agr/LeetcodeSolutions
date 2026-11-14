class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        int maxCurr = nums[0];
        int minCurr = nums[0];
        for(int i=1;i<n;i++){
            maxCurr = Math.max(nums[i], maxCurr + nums[i]);
            max = Math.max(max, maxCurr);

            minCurr = Math.min(nums[i], minCurr + nums[i]);
            min = Math.min(min, minCurr);
        }

        int total = Arrays.stream(nums).sum();

        if(total == min) return max;

        return Math.max(max, total - min);

    }
}