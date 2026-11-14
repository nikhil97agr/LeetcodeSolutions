package smallest_range_i_944;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = 0;
        int min = 100000;
        for(int x: nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        } 

        min = min + k;
        max = max - k;

        return min >= max ? 0 : max -min;
    }
}