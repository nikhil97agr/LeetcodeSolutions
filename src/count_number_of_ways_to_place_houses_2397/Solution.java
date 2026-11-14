package count_number_of_ways_to_place_houses_2397;

import java.util.*;
class Solution {
    int dp[];
    public int countHousePlacements(int n) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        int cnt = solve(0, n);
        return prod(cnt, cnt);
    }
    private int solve(int i, int n){
        if(i>=n) return 1;
        if(dp[i] !=-1) return dp[i];
        return dp[i] = add(solve(i+1, n), solve(i+2, n));
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l * a + b;
        return (int)(sum%mod);
    }

    private int prod(long a, long b){
        long mod = (long)1e9 + 7;
        long p = a * b;
        return (int)(p%mod);
    }
}