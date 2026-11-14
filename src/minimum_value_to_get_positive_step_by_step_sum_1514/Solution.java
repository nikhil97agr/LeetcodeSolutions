package minimum_value_to_get_positive_step_by_step_sum_1514;

class Solution {
    public int minStartValue(int[] nums) {
        int prefix = Integer.MAX_VALUE;
        int total = 0;
        for(int x : nums)
        {
            total += x;
            prefix = Math.min(prefix, total);
        }
        if(prefix>0)
            return 1;
        return -1*prefix + 1;
    }
}