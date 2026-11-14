import java.util.Arrays;

class Solution {


    public int[] kthRemainingInteger(int[] nums, int[][] queries) {

        int n = nums.length;

        int pre[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i];
            if (nums[i] % 2 == 0) {
                pre[i + 1]++;
            }
        }
        int q = queries.length;
        int ans[] = new int[q];

        for (int i = 0; i < q; i++) {
            ans[i] = calc(nums, queries[i][0], queries[i][1], queries[i][2], pre, n);
        }

        return ans;
    }

    private int calc(int nums[], int l, int r, int k, int pre[], int n) {

        int start = 2;
        int end = Integer.MAX_VALUE - 1;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            var ind = Arrays.binarySearch(nums, mid);
            if (ind < 0) {
                ind = -ind - 1;
            }

            if (ind == nums.length || nums[ind] > mid) {
                ind--;
            }

            int total = mid / 2;
            if (ind >= l) {
                total -= (pre[Math.min(ind + 1, r + 1)] - pre[l]);
            }

            if (total >= k) {
                ans = mid;
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }

        return ans;
    }
}