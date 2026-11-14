class Solution {
    long mod= (long)1e9 + 7;
    public int minimumPossibleSum(int n, int target) {
        long first = target/2;
        long min = Math.min(n, first);
        n-= min;

        long a= rangeSum(1, min);

        if(n!=0){
            long b = rangeSum(target, n);

            return (int)sum(a,b);
        }
    

    return (int)a;


    }

    private long rangeSum(long start, long n){
        long num = prod(n , (sum(prod(2,start) , (n-1))));
        long den = pow(2, mod-2);

        return prod(num, den);
    }

    private long pow(long a, long b){

        if(a == 1 || b==0) return 1;
        if(b==1) return a;

        long p = pow(a,b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    long sum(long a, long b){
        return (a+b)%mod;
    }

    long prod(long a, long b){
        return (a*b)%mod;
    }
}


/** 12
1,2,3,4,5,6,7,8,9,10
11,10, 9
1


 */