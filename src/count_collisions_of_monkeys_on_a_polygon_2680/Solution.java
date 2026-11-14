package count_collisions_of_monkeys_on_a_polygon_2680;

class Solution {
    long mod = (long)1e9 + 7;
    public int monkeyMove(int n) {
        return add(pow(2,n), -2);
    }

    private int pow(int a, int b){
        if(a==1 || b==0) return 1;
        if(b==1 ) return a;

        int p = pow(a, b/2);
        p = prod(p, p);
        if(b%2==1){
            p  = prod(p, a);
        }
        return p;
    }

    private int add(long a, long b){
        long sum = a + b + mod;
        return (int)(sum%mod);
    }

    private int prod(long a, long b){
        long p = a*b;

        return (int)(p%mod);
    }
}