package number_of_ways_to_wear_different_hats_to_each_other_1531;

import java.util.*;
class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        Integer dp[][] = new Integer[41][(1<<n)];

        return solve(1, hats, 0, (1<<n)-1, n, dp);
        
    }

    private int solve(int j, List<List<Integer>> hats, int mask, int finalMask,  int n, Integer dp[][]){
        if(j==41){
            if(mask == finalMask) return 1;
            return 0;
        }
        if(dp[j][mask] !=null) return dp[j][mask];
        int ans = solve(j+1, hats, mask, finalMask, n, dp);
        for(int i=0;i<n;i++){
            if((mask & (1<<i))!=0) continue;

            if(!hats.get(i).contains(j)) continue;

            ans = add(ans, solve(j+1, hats, mask | (1<<i), finalMask,  n, dp));
        }

        return dp[j][mask] = ans;
    }

    private int add(long a, long b){
        long sum = a + b;
        long mod = (long)1e9 + 7;

        return (int)(sum%mod);
    }
}