package palindromic_subarray_sum_4031;

import java.util.*;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        new Solution().getSum(new int[]{1, 2, 3, 2, 1, 5, 6});
    }

    public long getSum(int[] nums) {

        var manacher = new ManacherAlgorithm(nums);
        var p = manacher.p;
        var t = manacher.t;
        int n = t.length;
        long pre[] = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = t[i] + pre[i];
        }
        long ans = -1_000_000_000_000_000_0L;
        for (int i = 0; i < n; i++) {
            int size = p[i];

            int start = i - size + 1;
            int end = i + size - 1;
            ans = Math.max(ans, pre[end + 1] - pre[start]);
        }

        return ans;
    }


    class ManacherAlgorithm {

        public int p[];
        int[] t;

        public ManacherAlgorithm(int arr[]) {

            int n = arr.length;

            t = new int[n * 2 + 1];
            p = new int[t.length];
            Arrays.fill(t, 0);
            for (int i = 1, j = 0; j < n; i += 2, j++) {
                t[i] = arr[j];
            }

            Arrays.fill(p, 1);

            build();
        }

        public void build() {

            int n = t.length;
            int l = 1;
            int r = 1;
            for (int i = 1; i < n; i++) {
                if (i < r) {
                    p[i] = Math.max(0, Math.min(r - i, p[l + r - i]));
                }else{
                    p[i] = Math.max(0, r - i);
                }
                while (i + p[i] < n && i - p[i] >= 0 && t[i + p[i]] == t[i - p[i]]) {
                    p[i]++;
                }
                if (i + p[i] > r) {
                    l = i - p[i];
                    r = i + p[i];
                }
            }
        }


    }
}