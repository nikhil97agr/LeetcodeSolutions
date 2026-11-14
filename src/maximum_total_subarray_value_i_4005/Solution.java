package maximum_total_subarray_value_i_4005;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = 1_000_000_001;
        int max = 0;
        for(var x : nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }


        return 1l * k * (max - min);
    }
}