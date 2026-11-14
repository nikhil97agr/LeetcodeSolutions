import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {

        new Solution().sortableIntegers(new int[]{2, 1, 3, 4});
    }

    public int sortableIntegers(int[] nums) {

        Set<Integer> divs = new HashSet<>();
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
            }
        }
        int clone[] = nums.clone();
        Arrays.sort(clone);
        int ans = 0;

        for (int d : divs) {
            if (possible(nums, clone, d, n)) {
                ans += d;
            }
        }

        return ans;
    }

    private boolean possible(int[] nums, int[] sorted, int k, int n) {

        for (int start = 0; start < n; start += k) {
            if (!isCyclicShift(nums, sorted, start, k)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclicShift(int[] nums, int[] sorted, int start, int k) {


        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < k; i++) {

            count.put(nums[start + i], count.getOrDefault(nums[start + i], 0) + 1);
            count.put(sorted[start + i], count.getOrDefault(sorted[start + i], 0) - 1);
        }
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        int drops = 0;
        for (int i = 0; i < k; i++) {
            int current = nums[start + i];
            int next = nums[start + (i + 1) % k];
            if (current > next) {
                drops++;
            }
        }

        return drops <= 1;
    }
}