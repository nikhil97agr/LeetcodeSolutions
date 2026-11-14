class Solution {
    public long minimumTime(int[] d, int[] r) {
        long ans = 0;
        long start = 0;
        long end = (long)1e13;
        long d1 = d[0], d2 = d[1], r1= r[0], r2 = r[1];
        while(start <= end){
            long mid = (start+end)/2;

            long a = mid - mid/r1;
            long b = mid - mid/r2;
            long lcm = lcm(r1, r2);
            long c = mid - mid/r1 - mid/r2 + mid/lcm;

            if(a >= d1 && b >= d2 && a + b - c >= d1 + d2){
                ans = mid;
                end = mid-  1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    private long gcd(long a, long b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}