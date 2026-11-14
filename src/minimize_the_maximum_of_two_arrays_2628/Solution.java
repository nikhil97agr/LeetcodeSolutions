package minimize_the_maximum_of_two_arrays_2628;

class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int ans = 0;
        long lcm = (1l*divisor1*divisor2)/gcd(divisor1,divisor2);
        while(min <= max){
            int mid = min + (max - min)/2;
            if(mid <= 20){
                System.out.println("THIS");
            }
            if(check(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2, lcm)){
                ans = mid;
                max =mid - 1;
            }else{
                min = mid+ 1;
            }
        }

        return ans;
    }

    private boolean check(int n, int d1, int d2, int c1, int c2, long lcm){
        long a = n/d1;
        long b = n/d2;
        long c = 1l*n/lcm;

        return n - a - b + c >= Math.max(0, c1 - (b-c)) + Math.max(0, c2 - (a-c));
    }

    private long gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}