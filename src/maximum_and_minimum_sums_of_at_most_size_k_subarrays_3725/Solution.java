package maximum_and_minimum_sums_of_at_most_size_k_subarrays_3725;

import java.util.*;
import java.util.Arrays;
import java.util.Stack;

class Solution {

    public long minMaxSubarraySum(int[] nums, int k) {

        int n = nums.length;

        return max(nums, k, n) + min(nums, k, n);
    }

    private long max(int nums[], int k, int n) {

        int nge[] = nge(nums, n, true);
        int pge[] = pge(nums, n, true);
        return calc(nge, pge, nums, k, n);
    }

    private long min(int nums[], int k, int n) {
        int nge[] = nge(nums, n, false);
        int pge[] = pge(nums, n, false);
        
        return calc(nge, pge, nums, k, n);
    }

    private long calc(int nge[], int pge[], int nums[], int k, int n) {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int leftIndex = pge[i];
            int rightIndex = nge[i];
            int leftLen = i - leftIndex;
            int rightLen = rightIndex - i;
            if (leftLen + rightLen - 1 <= k) {
                long sub = 1l * leftLen * rightLen;
                ans += sub * nums[i];
                continue;
            }

            int minLeft = Math.max(i - k + 1, leftIndex + 1);
            int minRight = Math.min(i + k - 1, rightIndex - 1);

            leftLen = i - minLeft;
            rightLen = minRight - i;
            long sub = 0;
            if (leftLen < rightLen) {
                for (int j = minLeft; j <= i; j++) {
                    int right = Math.min(minRight, j + k -1);
                    sub += (right - i + 1);
                }
            } else {
                for (int j = minRight; j >= i; j--) {
                    int left = Math.max(j - k + 1, minLeft);
                    sub += (i - left + 1);
                }
            }

            ans += sub * nums[i];
        }

        return ans;
    }

    private int[] pge(int nums[], int n, boolean isMax) {

        int pge[] = new int[n];
        var stack = new Stack<Integer>();
        Arrays.fill(pge, -1);

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (isMax ? nums[stack.peek()] < nums[i] : nums[stack.peek()] > nums[i])) {
                pge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return pge;
    }

    private int[] nge(int nums[], int n, boolean isMax) {

        int nge[] = new int[n];
        var stack = new Stack<Integer>();
        Arrays.fill(nge, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (isMax ? nums[stack.peek()] <= nums[i] : nums[stack.peek()] >= nums[i])) {
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }
        return nge;
    }

}