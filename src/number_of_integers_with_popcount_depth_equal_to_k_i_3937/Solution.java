package number_of_integers_with_popcount_depth_equal_to_k_i_3937;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private String s;
    private long[][][] memo;
    private Map<Integer, Integer> depthMemo;

    public long popcountDepth(long n, int k) {
        if (k == 0) {
            return 1;
        }

        this.depthMemo = new HashMap<>();
        this.depthMemo.put(1, 0);


        List<Integer> validPopcounts = new ArrayList<>();
        for (int c = 1; c <= 60; c++) {
            if (getDepth(c) == k - 1) {
                validPopcounts.add(c);
            }
        }

        if (validPopcounts.isEmpty()) {
            return 0;
        }

        this.s = Long.toBinaryString(n);
        long totalCount = 0;

        for (int c : validPopcounts) {

            this.memo = new long[s.length()][61][2];
            for (long[][] arr2D : memo) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
            totalCount += dp(0, c, false);
        }

        if (k == 1) {
            totalCount--;
        }

        return totalCount;
    }




    private int getDepth(int c) {
        if (depthMemo.containsKey(c)) {
            return depthMemo.get(c);
        }
        int depth = getDepth(Integer.bitCount(c)) + 1;
        depthMemo.put(c, depth);
        return depth;
    }


    private long dp(int idx, int count, boolean isLess) {
        if (count < 0) {
            return 0;
        }
        if (idx == s.length()) {
            return (count == 0) ? 1 : 0;
        }

        int isLessInt = isLess ? 1 : 0;
        if (memo[idx][count][isLessInt] != -1) {
            return memo[idx][count][isLessInt];
        }

        long ans = 0;
        int limit = isLess ? 1 : s.charAt(idx) - '0';

        for (int digit = 0; digit <= limit; digit++) {
            boolean newIsLess = isLess || (digit < limit);
            ans += dp(idx + 1, count - digit, newIsLess);
        }

        return memo[idx][count][isLessInt] = ans;
    }
}