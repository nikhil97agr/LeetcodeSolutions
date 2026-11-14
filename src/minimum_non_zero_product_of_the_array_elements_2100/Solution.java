package minimum_non_zero_product_of_the_array_elements_2100;

class Solution {
    public int minNonZeroProduct(int p) {
        long max = (1l<<p) -1 ;

        return prod(max, pow(max - 1, (max-1)/2));
    }

    private int pow(long a, long b){
        if(b==0 || a==1) return 1;
        if(b==1) return prod(a, 1);
        
        int p = pow(a, b/2);
        p = prod(p,p);

        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    private int prod(long a, long b){
        long mod = (long)1e9 + 7;

        long p = (a%mod)*(b%mod);

        return (int)(p%mod);
    }
}