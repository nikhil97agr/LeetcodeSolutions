package ugly_number_iii_1307;

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int start = 1;
        int end = (int)2e9;

        while(start < end){
            int mid = start + (end - start)/2;

            long cnt = get(mid, a, b, c);
            if(cnt < 1l*n){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return end;
    }

    private long get(int mid, int a, int b, int c){
        long total =0l +  mid /a + mid/b + mid/c  - mid/lcm(a,b) - mid/lcm(b,c) - mid/lcm(a,c) + mid/lcm(a,b,c);

        return total;  
    }

    private long lcm(int a, int b){
        return (1l*a*b)/ gcd(a,b);
    }

    private long lcm(int a, int b, int c){
        long l1 = (1l*a*b)/gcd(a,b);

        return (l1 * c)/gcd(l1,c);
    }

    private long gcd(long a, long b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}