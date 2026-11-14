package maximum_xor_product_3192;

class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        for(int i=n-1;i>=0;i--){
            if( ( a & (1l<<i))==0 && (b & (1l<<i))==0){
                a |= (1l << i);
                b |= (1l<<i);
                continue;
            }
            if( ( a & (1l<< i)) !=0 && (b & (1l<<i))!=0) continue;

            long curr = Math.abs(a-b);
            long newA = (a ^ (1l<<i));
            long newB = (b ^ (1l<<i));
            long newDiff = Math.abs(newA- newB);
            if(newDiff < curr){
                a = newA;
                b = newB;
            }
        }

        a = sum(a,0);
        long ans = 0;

        while ( b > 0){
            if(( b & 1) == 1l){
                ans = sum(ans, a);
            }
            b >>= 1;
            a <<= 1;
            a = sum(a,0);
        }

        return (int)ans;

    }


    private long sum(long a, long b){
        long sum = a + b;
        long mod = (long)1e9 + 7;

        return sum%mod;
    }
}


/**

    1 - 001
    6 - 110
        101
11110 => 30
      11111 => 31
 */