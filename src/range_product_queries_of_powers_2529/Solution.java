package range_product_queries_of_powers_2529;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = generatePowers(n);
        Collections.sort(powers);
        long pre[] = new long[powers.size() + 1];
        pre[0] = 1;

        for(int i=1;i<=powers.size();i++){
            pre[i] = prod(pre[i-1], powers.get(i-1));
        }

        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            long temp = div(pre[r+1], pre[l]);
            ans[i] = (int)temp;
        }

        return ans;

    }

    private List<Integer> generatePowers(int n){
        List<Integer> res = new ArrayList<>();
        while( n > 0){
            int p = (int)(Math.log(n)/ Math.log(2));
            n -= (1<<p);
            res.add(1<<p);
        }
        return res;
    }

    private long inv(long a){
        return pow(a, mod - 2);
    }

    private long prod(long a, long b){
        long prod =a*b;

        return prod%mod;
    }

    private long div(long a, long b){
        a = a%mod;
        long inv = inv(b);
           return prod(inv, a);
    }

    private long pow(long a, long b){
        if(b==0) return 1;
        if(b== 1) return a;

        long p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }
}