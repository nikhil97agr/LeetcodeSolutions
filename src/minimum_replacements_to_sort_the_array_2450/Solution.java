package minimum_replacements_to_sort_the_array_2450;

class Solution {
     public long minimumReplacement(int[] nums) {
        int n = nums.length;
        int prev = nums[n - 1];
        long total = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > prev) {
                int steps = nums[i]/ prev;
                if (nums[i] % prev != 0) {
                    steps++;
                }

                total += steps - 1;
                prev = nums[i] / steps;
            } else {
                prev = nums[i];
            }
        }
        return total;
    }
}