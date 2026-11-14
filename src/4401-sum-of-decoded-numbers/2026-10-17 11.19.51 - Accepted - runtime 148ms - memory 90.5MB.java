class Solution {
    int mod = 1_000_000_007;
    public int sumDecoded(long[] nums) {
        int ans = 0;

        for(long num : nums){
            long w = num%10;
            long d = num / 10;
            long x = 0;
            long y = 0;
            List<Long> dig = new ArrayList<>();
            while(d > 0){
                dig.add(d%10);
                d/=10;
            }
            int i=dig.size() - 1;
            while(w-- > 0){
                x = x * 10 + dig.get(i--);
            }

            while(i >=0){
                y = y * 10 + dig.get(i--);
            }

            ans = add(ans, pow(x, y));

        }
        return ans;
    }

    private int add(long a, long b){
        long s = a + b;
        return (int)(s%mod);
    }

    private int prod(long a, long b){
        long p = a * b;
        return (int)(p%mod);
    }

    private int pow(long a, long b){

        int ans = 1;
        while(b > 0){
            if(b%2==1){
                ans = prod(ans, a);
            }

            a = prod(a, a);
            b/=2;
        }

        return ans;
    }
}