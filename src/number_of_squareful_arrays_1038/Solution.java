package number_of_squareful_arrays_1038;

import java.util.*;
class Solution {
    public int numSquarefulPerms(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        Integer dp[][] = new Integer[n][(1<<n)];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            map.computeIfAbsent(x, y -> new ArrayList<>()).add(i);
        }
        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                ans += solve(nums, i, 1 << i, (1 << n) - 1, map, dp);
                break;
            }
        }

        return ans;
    }

    private int solve(int nums[], int prev, int state, int finalState, Map<Integer, List<Integer>> map, Integer dp[][]) {
        if (state == finalState) {
            return 1;
        }
        if(dp[prev][state]!=null) return dp[prev][state];
        int ans = 0;

        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                if ((state & (1 << i)) == 0) {
                    if (check(nums[prev], key)) {
                        ans += solve(nums, i, state | (1 << i), finalState, map, dp);
                    }
                    break;
                }
            }
        }

        return dp[prev][state] = ans;
    }

    private boolean check(int a, int b) {
        long sum = a + b;
        long sq = (long) Math.sqrt(sum);

        return (sq * sq) == sum;
    }
}