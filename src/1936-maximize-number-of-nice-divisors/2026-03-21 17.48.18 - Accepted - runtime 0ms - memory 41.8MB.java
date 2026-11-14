class Solution {
    
    public int maxNiceDivisors(int primeFactors) {
        if(primeFactors == 1) return 1;

        int cnt = primeFactors /3;
        int ans = 1;
        if(primeFactors%3==1){
            cnt--;
            ans = prod(ans, 4);
        }else if(primeFactors%3==2){
            ans= prod(ans, 2);
        }


        return prod(ans, pow(3, cnt));
    }



    private int prod(long a, long b){
        long mod = 1000000007;
        return (int)((a*b)%mod);
    }

    private int pow(long a, long b){
        if(a==0 || b==1){
            return prod(a, 1);
        }

        if(b == 0 || a==1) return 1;

        int p = pow(a, b/2);
        p = prod(p, p);
        if(b%2==1){
            p = prod(p,a);
        }

        return p;
    }


}