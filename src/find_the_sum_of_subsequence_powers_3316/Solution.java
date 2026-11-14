package find_the_sum_of_subsequence_powers_3316;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    long mod = (long)1e9 + 7;
    Map<String, Integer> dp = new HashMap<>();
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        return solve(nums, k, n-1, n, Integer.MAX_VALUE, n);
    }

    private int solve(int nums[], int k, int i, int prev, int minDiff, int n){
        if(k ==0){
            return minDiff;
        }
        if(i<0) return 0;
        String state = k+":"+i+":"+prev+":"+minDiff;
        if(dp.containsKey(state)) return dp.get(state);
        int ans = solve(nums, k, i-1, prev, minDiff, n);

        int excl = solve(nums, k-1, i-1, i, prev == n ? minDiff : (Math.min(minDiff, nums[prev] - nums[i])), n);
        if(excl != Integer.MAX_VALUE){
            ans = add(ans, excl);
        }
        dp.put(state, ans);
        return ans;
    }

    private int add(long a, long b){
        return (int)((a + b)%mod);
    }


}