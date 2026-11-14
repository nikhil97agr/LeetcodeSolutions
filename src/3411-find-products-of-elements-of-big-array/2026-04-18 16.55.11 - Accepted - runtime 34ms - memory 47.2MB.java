class Solution {
    public int[] findProductsOfElements(long[][] queries) {
        var q = queries.length;
        int ans[]= new int[q];
        for(int i=0;i<q;i++){

            ans[i] = solve(queries[i]);
        }

        return ans;
    }

    private int solve(long query[]){
        long l = query[0], r = query[1], mod = query[2];

        long []lCnt = count(l - 1);
        long []rCnt = count(r);
        var ans = 1;
        for(int i=0;i<63;i++){
            long diff = rCnt[i] - lCnt[i];
            if(diff ==0) continue;
            ans = prod(ans, pow(1l << i, diff, mod), mod);
            if(ans ==0){
                return 0;
            }
        }

        return ans;
    }

    private long[] count(long index){
        long min = 0;
        long max = index + 5;
        long highestPow = 0;
        long extra = index + 1;
        while(min <= max){
            long mid =min + (max - min)/2;
            long ones = cntOnes(mid);

            if(ones < index + 1){
                highestPow= mid;
                min = mid + 1;
                extra = index + 1 - ones;
            }else if(ones > index + 1){
                max = mid -1;
            }else{
                highestPow = mid;
                extra = 0;
                break;
            }
        }

        long bitCount[] = bitCount(highestPow);

        if(extra ==0) return bitCount;

        long higher = max + 1;
        for(int bit =0;bit < 64;bit++){
            long b = (higher >> bit) & 1;
            if(b == 1){
                bitCount[bit]++;
                extra--;
                if(extra ==0) return bitCount;
            }
        }

        return bitCount;
    }


    private long[] bitCount(long num){
        long bitCnt[] = new long[64];
        for(int bit =0;bit < 55;bit++){
            long pairs = (num + 1)/(1l << (bit + 1));
            bitCnt[bit] = pairs * (1l << bit);
            long left = (num + 1)%(1l << (bit + 1));
            if(left > (1l << bit)){
                bitCnt[bit] += left - ( 1l << bit);
            }
        }

        return bitCnt;
    }

    private long cntOnes(long num){
        long setBits = 0;
        long n = num + 1;
        for(long bit =0;(1l<<bit) <= num;bit++){
            long totalPairs = n / (1l <<( bit + 1));
            setBits += totalPairs * (1l << bit);
            setBits += Math.max(0l, n%(1l << (bit + 1)) - (1l << bit));
        }

        return setBits;
    }

    private int prod(long a, long b, long mod){
        a = a%mod;
        b = b%mod;
        return (int)((a*b)%mod);
    }

    private int pow(long a, long b, long mod){
        int ans = 1;
        while(b > 0){
            if(b%2==1){
                ans= prod(ans, a, mod);
            }

            a = prod(a, a, mod);
            b>>=1;
        }

        return ans;
    }
}