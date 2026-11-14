package count_ways_to_build_good_strings_2562;

import java.util.*;
class Solution {
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        long dp[] = new long[high+1];
        long mod = (long)1e9+7;
        Arrays.fill(dp, -1);
        dp[0] = solve(low, high, zero, zero, one, dp, mod) + solve(low, high,one, zero, one, dp, mod );
        return (int)(dp[0]%mod);
    }
    
    public long solve(int low, int high, int ind, int zero, int one, long dp[], long mod){
        if(ind>high){
            return 0;
        }

        
        if(dp[ind] !=-1){
            return dp[ind]%mod;
        }

        dp[ind] = solve( low,  high, ind+zero, zero, one, dp, mod)%mod + solve( low,  high, ind+one, zero, one, dp, mod)%mod;
        dp[ind] %=mod;
        if(ind>=low && ind<=high){
            dp[ind]++;
        }
        return dp[ind]%mod;
        
        
        
    }
}