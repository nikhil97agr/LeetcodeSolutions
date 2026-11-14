package maximize_subarray_sum_after_removing_all_occurrences_of_one_element_3688;

class Solution {
    public long maxSubarraySum(int[] nums) {
        long ans=nums[0];
        
        var map = new long[2000001];
        long pre = 0;
        long minFromStart = 0;
        long overallMin = 0;

        for(int val : nums){
            pre += val;
            
            ans = Math.max(ans, pre - overallMin);

            if( val < 0){
                var adjustedIndex = val + 1000000;
                long prevMinForVal = map[adjustedIndex];

                map[adjustedIndex] = Math.min(prevMinForVal, minFromStart) + val;

                overallMin = Math.min(overallMin, map[adjustedIndex]);
            }

            minFromStart = Math.min(minFromStart, pre);

            overallMin = Math.min(overallMin, minFromStart);
        }

        return ans;
    }
}