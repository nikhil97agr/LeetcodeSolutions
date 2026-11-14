package count_non_decreasing_arrays_with_given_digit_sums_4259;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    int max = 5000;
    List<Integer> list[];

    public int countArrays(int[] digitSum) {

        list = new ArrayList[51];
        for (int i = 0; i <= 50; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i <= max; i++) {
            int sum = 0;
            int val = i;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }

            if (sum > 50) {
                continue;
            }
            list[sum].add(i);
        }

        int dp[] = new int[max + 1];
        List<Integer> first = list[digitSum[0]];
        for (int x : first) {
            dp[x] = 1;
        }

        int n = digitSum.length;
        for (int i = 1; i < n; i++) {
            int pre[] = new int[max + 1];
            pre[0] = dp[0];
            for (int j = 1; j <=max; j++) {
                pre[j] = add(pre[j - 1], dp[j]);
            }

            int newDp[] = new int[max + 1];

            for (int x : list[digitSum[i]]) {
                newDp[x] = pre[x];
            }
            dp = newDp;
        }

        int ans = 0;
        for (int x : dp) {
            ans = add(ans, x);
        }

        return ans;


    }

    private int add(int a, int b) {

        int mod = 1_000_000_007;

        return (int) ((1l * a + b) % mod);
    }
}