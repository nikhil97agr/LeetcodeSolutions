class Solution {
    public int countGoodNumbers(long n) {
        return prod(pow(4, n/2), pow(5, (n+1)/2));
    }

    int pow(int a, long b){
        int ans = 1;
        while(b > 0){
            if(b%2==1){
                ans = prod(ans, a);
            }
            a = prod(a,a);
            b/=2;
        }

        return ans;
    }

    int prod(long a, long b){
        int mod = 1_000_000_007;

        return (int)((a*b)%mod);
    }
}