package distinct_subsequences_ii_977;

import java.util.*;
class Solution {
    int mod = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        int index[] = new int[26];
        Arrays.fill(index, -1);
        for(int i=0;i<n;i++){
            int ind = s.charAt(i) - 'a';

            dp[i + 1] = prod(dp[i], 2);

            if(index[ind] != -1){
                dp[i + 1] = add(dp[i + 1], -dp[index[ind]]);
            }

            index[ind] = i ;



        }

        return add(dp[n], -1);

    }

    private int add(long a, long b){
        return (int)((a+b + mod)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}