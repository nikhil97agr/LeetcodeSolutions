package nth_magical_number_910;

class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = (long)1e9+7;

        long min = 1;
        long max = 1L*n*Math.min(a,b);
        long ans = 0;
        while(min <= max){
            long mid = min + (max-min)/2;

            long count = mid/a + mid/b - mid/lcm(a,b);

            if(count >= n){
                ans = mid%mod;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return (int)ans;
    }

    private long lcm(int a, int b){
        return (1L*a*b)/gcd(a,b);
    }

    private long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}