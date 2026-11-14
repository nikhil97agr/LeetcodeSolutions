class Solution {
    public int minimumIncrements(int[] nums, int[] target) {
        int m = target.length;
        int n = nums.length;
        int finalBit = 1<<m;
        long lcm[] = new long[finalBit];
        for(int i=1;i<finalBit;i++){
            long l = 1;
            for(int j=0;j<m;j++){
                if((i&(1<<j))!=0){
                    l = lcm(l, target[j]);
                }
            }
            lcm[i] = l;
        }
        long dp[] = new long[finalBit];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int x : nums){
            long temp[] = dp.clone();
            for(int i=1;i<finalBit;i++){
                long l = lcm[i];
                long r = x%l;
                long diff = r==0? 0 : (l-r);
                for(int j=0;j<finalBit;j++){
                    int next = j|i;
                    temp[next] = Math.min(temp[next], dp[j] + diff);
                }
            }
            dp =temp;
        }
        return (int)dp[finalBit-1];
    }

    private long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    private long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}