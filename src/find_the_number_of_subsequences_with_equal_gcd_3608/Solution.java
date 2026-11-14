package find_the_number_of_subsequences_with_equal_gcd_3608;

import java.util.*;
class Solution {
    int mod = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        var max = Arrays.stream(nums).max().getAsInt();

        var dp = new int[max + 1][max + 1];

        dp[0][0] = 1;
        for(int x : nums){
            var dp2 = new int[max + 1][max + 1];
            for(int i=max;i>=0;i--){
                for(int j=max;j>=0;j--){
                    var g1 = gcd(i, x);
                    var g2 = gcd(j, x);

                    dp2[g1][j] = add(dp2[g1][j], dp[i][j]);
                    dp2[i][g2] = add(dp2[i][g2], dp[i][j]);
                    dp2[i][j] = add(dp2[i][j], dp[i][j]);
                }
            }

            dp = dp2;
        }

        var res = 0;
        for(var i=1;i<=max;i++){
            res = add(res, dp[i][i]);
        }


        return res;


    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }

    private int add(long a, long b){
        return (int)((a+b)%mod);
    }

}