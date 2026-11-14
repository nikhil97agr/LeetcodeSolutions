package longest_arithmetic_sequence_after_changing_at_most_one_element_4230;

class Solution {

    public int longestArithmetic(int[] nums) {

        int n = nums.length;

        int maxLen = 2;

        for (int i = 0; i < n - 1; ) {
            int d = nums[i + 1] - nums[i];
            int start = i;
            while (i < n - 1 && nums[i + 1] - nums[i] == d) {
                i++;
            }

            int currentStreak = i - start + 1;
            maxLen = Math.max(maxLen, Math.min(n, currentStreak + 1));

            if (i + 2 < n && nums[i + 2] - nums[i] == 2 * d) {
                int j = i + 2;
                int nextStreak = 1;
                while (j < n - 1 && nums[j + 1] - nums[j] == d) {
                    j++;
                    nextStreak++;
                }
                maxLen = Math.max(maxLen, currentStreak + 1 + nextStreak);
            }

            if (i + 1 < n && i - 1 >= 0 && (nums[i + 1] - nums[i - 1]) % 2 == 0) {
                int newD = (nums[i + 1] - nums[i - 1]) / 2;
                if (newD != d) {
                    int left = 1;
                    int k = i - 1;
                    while (k > 0 && nums[k] - nums[k - 1] == newD) {
                        k--;
                        left++;
                    }
                    int right = 1;
                    int m = i + 1;
                    while (m < n - 1 && nums[m + 1] - nums[m] == newD) {
                        m++;
                        right++;
                    }
                    maxLen = Math.max(maxLen, left + right + 1);
                }
            }

            if (i == start) {
                i++;
            }
        }

        for (int i = 0; i < n - 2; i++) {
            maxLen = Math.max(maxLen, 3);
        }

        return maxLen;
    }
}