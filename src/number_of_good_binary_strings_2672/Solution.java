package number_of_good_binary_strings_2672;

class Solution {
    Integer dp[];
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        dp=new Integer[maxLength + 1];
        return solve(0, minLength, maxLength, oneGroup, zeroGroup);
    }

    private int solve(int len, int min, int max,int one, int zero){
        if(len > max){
            return 0;
        }

        if(dp[len] !=null) return dp[len];

        int ans = add(solve(len + one, min, max, one, zero), solve(len + zero, min, max, one ,zero));

        if(len >= min){
            ans = add(ans, 1);
        }

        return dp[len] = ans;
    }

    private int add(int a, int b){
        long mod = (long) 1e9 + 7;
        long sum = 1l * a + b;
        return ( int)(sum%mod);
    }



}