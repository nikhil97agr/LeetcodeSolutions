package number_of_ways_to_reach_a_position_after_exactly_k_steps_2477;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new HashMap<>();
        return solve(startPos, endPos, k);
    }

    private int solve(int curr, int end, int k){
        if(k==0){
            if(curr == end) return 1;
            return 0;
        }

        if(dp.containsKey(curr) && dp.get(curr).containsKey(k)) return dp.get(curr).get(k);

        int ans = add(
                solve(curr -1, end, k-1),
                solve(curr + 1, end, k-1)
        );

        dp.computeIfAbsent(curr,x-> new HashMap<>()).put(k, ans);
        return ans;

    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l * a + b;
        return (int)(sum%mod);
    }

}