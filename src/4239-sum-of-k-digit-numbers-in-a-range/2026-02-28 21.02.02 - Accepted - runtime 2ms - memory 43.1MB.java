class Solution {
    long mod = (long)1e9 + 7;
    public int sumOfNumbers(int l, int r, int k) {
        int ans = 0;
        int total = r- l + 1;
        int p1 = prod(total, r + l);
        int p2 = pow(total, k - 1);
        int p3 = sum(pow(10, k), -1);

        int p = prod(p1, prod(p2, p3));

        return prod(p, pow(18, mod - 2));

    }

    private int pow(long a, long b){
        if(a==0) return 0;
        if(a==1 || b == 0) return 1;
        if(b==1) return prod(a, 1);
        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1) p = prod(p, a);
        return p;
    }

    private int sum(long a, long b)
    {
        return (int)((a+b + mod)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}