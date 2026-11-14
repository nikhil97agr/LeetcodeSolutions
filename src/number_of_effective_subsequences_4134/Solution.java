package number_of_effective_subsequences_4134;

class Solution {
    int mod = 1_000_000_007;
    public int countEffective(int[] nums) {
        var or = 0;
        var n = nums.length;
        for(var x : nums){
            or |= x;
        }
        if(or == 0) return 0;
        var bits = new int[22];
        var bitLength =0;
        for(var i=0;i<22;i++){
            var bit = (or >> i) & 1;
            if(bit == 1) bits[bitLength++] =i;
        }
        var max = 1<<bitLength;
        var freq = new int[max];

        for(var x : nums){
            var newOr = 0;
            for(var i =0 ;i< bitLength;i++){
                var bit = (x >> bits[i]) & 1;
                if(bit == 1){
                    newOr |= (1 << i);
                }
            }
            freq[newOr]++;
        }
        
        for(var bit = 0;bit < bitLength;bit++){
            for(var mask = 0;mask < max;mask++){
                var b = (mask >> bit) & 1;
                if(b == 1){
                    freq[mask] = add(freq[mask], freq[mask ^ (1<<bit)]);
                }
            }
        }

        var pow = new int[n + 1];
        pow[0] = 1;
        for(int i=1;i<=n;i++){
            pow[i] = prod(pow[i-1], 2);
        }

        var ans = 0;
        var maxMask = max - 1;

        for(var mask =1;mask <=maxMask;mask++){
            var complement = maxMask ^ mask;
            var cnt = freq[complement];
            var totalSub = pow[cnt];

            if(Integer.bitCount(mask)%2== 1) ans = add(ans, totalSub);
            else ans = add(ans, -totalSub);
        }

        return ans;
    }

    private int prod(long a, long b){
        return (int)((a * b)%mod);
    }

    private int add(long a, long b){
        long sum = a + b + mod;


        return (int)(sum%mod);
    }
}