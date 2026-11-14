package find_the_sum_of_the_power_of_all_subsequences_3345;

import java.util.*;
class Solution {
    public int sumOfPower(int[] nums, int k) {
        long mod = (long)1e9+7;
        long ans = 0;
        int n = nums.length;
        Long dp[][][] = new Long[n][n+1][k+1];
        for(int len =1;len <=n;len++){
            solve(nums, k, n, len, 0, dp, mod);
        }
        
        Map<Integer, Long> pow = new HashMap<>();
        pow.put(0, 1L);
        long curr = 1;
        for(int i=1;i<=n;i++){
            curr = curr<<1;
            curr%=mod;
            pow.put(i, curr);
        }
        
        for(int i=1;i<=n;i++){
            ans = ans + (dp[0][i][k]*pow.get(n-i))%mod;
            ans %= mod;
        }
        return (int)ans;
    }

    private long solve(int nums[], int k, int n, int len, int i, Long dp[][][], long mod){
        if(k==0){
            if(len == 0){
                return 1L;
            }
            return 0;
        }
        if( k < 0) return 0;
        if(len == 0) return 0;
        if(i==n ) return 0;

        if(dp[i][len][k] != null) return dp[i][len][k]%mod;

        return dp[i][len][k] = (solve(nums, k - nums[i], n, len-1, i+1, dp, mod)%mod + solve(nums, k, n, len, i+1, dp, mod)%mod);
    }
}