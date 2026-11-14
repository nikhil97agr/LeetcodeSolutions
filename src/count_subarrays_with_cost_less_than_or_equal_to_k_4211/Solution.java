package count_subarrays_with_cost_less_than_or_equal_to_k_4211;

import java.util.*;
import java.util.ArrayDeque;
import java.util.TreeMap;

class Solution {

    public long countSubarrays(int[] nums, long k) {

        long ans = 0;
        var map = new TreeMap<Integer, Integer>();
        int start = 0;
        int end = 0;
        var min = new ArrayDeque<Integer>();
        var max = new ArrayDeque<Integer>();
        int n = nums.length;
        while (end < n) {
            while (!min.isEmpty() && min.peekFirst() < start) {
                min.pollFirst();
            }

            while (!max.isEmpty() && max.peekFirst() < start) {
                max.pollFirst();
            }

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[end]) {
                min.pollLast();
            }

            while (!max.isEmpty() && nums[max.peekLast()] <= nums[end]) {
                max.pollLast();
            }
            min.offer(end);
            max.offer(end);

            while (start < end && score(nums[min.peekFirst()], nums[max.peekFirst()], start, end) > k) {
                ans += (end - start);
                start++;

                while (!min.isEmpty() && min.peekFirst() < start) {
                    min.pollFirst();
                }

                while (!max.isEmpty() && max.peekFirst() < start) {
                    max.pollFirst();
                }
                
            }

            end++;
        }

        while (start < end) {
            ans += end - start;
            start++;
        }
        return ans;
    }

    private long score(int min, int max, int start, int end) {

        long len = end - start + 1;
        long total = max - min;

        return total * len;
    }

}