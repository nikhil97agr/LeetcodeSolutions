class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;
        if((dividend < 0 && divisor >=0) || (divisor < 0 && dividend >=0)) isNeg = true;
        
        long a = Math.abs(1l*dividend);
        long b = Math.abs(1l*divisor);
        if(a==b) return (isNeg ? -1 : 1);
        
        long ans = 0;
        while(b <= a){
            long pow = 0;

            while( a > (b<<(pow+1))){
                pow++;
            }

            ans += (1<<pow);
            a -= (b<<pow);
        }
        if(ans == (1L<<31) && !isNeg) return Integer.MAX_VALUE;

        return (isNeg? -1 : 1) * (int)ans;

    }
}