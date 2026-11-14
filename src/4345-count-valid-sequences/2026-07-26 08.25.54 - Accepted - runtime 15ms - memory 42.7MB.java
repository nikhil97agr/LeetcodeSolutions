class Solution {
    int mod = 1_000_000_007;
    public int countValidSequences(int n, int k) {
        int ans = ncr(n - 1, k - 1);
        int sub = 0;
        if((n-k)%2 == 0){
            int m= (n - k)/2;
            sub = ncr(m + k - 1, k -1 );
        }

        ans = add(ans, -sub);

        return ans;
    }

    private int ncr(int n, int r){
        if(r < 0 || r > n) return 0;
        if( r ==0 || r == n) return 1;

        int num = 1;
        int den = 1;
        for(int i=0;i<r;i++){
            num = prod(num, n - i);
            den = prod(den, i + 1);
        }

        return prod(num, pow(den, mod - 2));
    }

    private int add(long a, long b){
        return (int)((a + b + mod)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }

    private int pow(long a, long b){
        int ans = 1;

        while( b > 0){
            if(b%2== 1l){
                ans = prod(ans, a);
            }

            a = prod(a,a);
            b/=2;
        }

        return ans;
    }
}