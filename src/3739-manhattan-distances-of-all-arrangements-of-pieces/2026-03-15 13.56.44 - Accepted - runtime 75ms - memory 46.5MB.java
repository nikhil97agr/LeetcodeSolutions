class Solution {
    long mod = (long)1e9 + 7;

    public int distanceSum(int m, int n, int k) {


        int base = ncr(n*m-2, k-2);

        int ans = 0;
        for(int dist = 1;dist < n;dist++)
            ans = add(ans, prod(dist, n - dist, m, m));

        for(int dist = 1;dist < m;dist++){
            ans = add(ans, prod(dist, m - dist, n, n));
        }

        return prod(ans, base);

    }

    private int ncr(int n, int r){
        int num = 1;
        int den = 1;

        for(int i=0;i<r;i++){
            num = prod(num, n - i);
            den = prod(den, i + 1);
        }
        return prod(num, pow(den, mod - 2));
    }

    private int pow(long a, long b){
        if(a==0 || b == 1){
            return prod(a);
        }
        if(a==1 || b ==0) return 1;

        int p = pow(a, b/2);
        p = prod(p, p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
        
    }

    private int add(long...num){
        long res = 0;
        for(long x : num){
            res += x;
            res%=mod;
        }

        return (int)res;
    }

    private int prod(long...num){
        long p = 1;
        for(long x : num){
            p *= x;
            p%=mod;
        }

        return (int)p;
    }
}