package find_the_number_of_k_even_arrays_3614;


import java.lang.reflect.Modifier;class Solution {
    long mod = (long)1e9 + 7;
    public int countOfArrays(int n, int m, int k) {
        int e= 0;
        int o = 0;
        Long dp[][][] = new Long[n][k+1][2];
        if(m%2==1){
            o = 1 + m/2;
            e = m/2;
        }else{
            o = e = m/2;
        }

        long ans = o * solve(n, 1, e, o, k, 1, dp) + e * solve(n, 1, e, o, k, 0, dp);
        return (int)(ans%mod);
    }

    private long solve(int n, int i, int e, int o,  int k, int prev, Long dp[][][]){
        if(i == n){
            if(k==0) return 1;
            return 0;
        }
        if(dp[i][k][prev]!=null) return dp[i][k][prev];
        if(prev ==0){
            if(k!=0){
                return dp[i][k][prev] = add(prod(e ,solve(n, i+1, e, o, k-1, prev, dp)) , prod(o,solve(n, i+1, e, o, k, 1, dp)));
            }else{
                return dp[i][k][prev] = prod(o , solve(n, i+1, e, o, k, 1, dp));
            }
        }else{
            return dp[i][k][prev] = add(prod(e , solve(n, i+1, e, o, k, 0, dp)) , prod(o , solve(n,i+1, e,o, k, 1, dp)));
        }
    }

    private long add(long a, long b){
        long sum = a + b;

        return sum%mod;
    }

    private long prod(long a, long b){
        long p = a*b;

        return p;
    }
}