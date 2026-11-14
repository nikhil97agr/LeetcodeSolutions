class Solution {
    public long maxProduct(int[] nums) {
        long ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int pow = (int)(Math.log(max)/Math.log(2));
        int dp[] = new int[1<<(pow + 1)];
        int maxMask = dp.length -1;

        for(int x : nums){
            dp[x] = x;
        }

        for(int bit = 0;bit <= pow;bit++){
            for(int mask =0;mask <= maxMask;mask++){
                int b = (mask >>bit)&1;
                if(b == 1){
                    dp[mask]= Math.max(dp[mask], dp[mask ^ (1<<bit)]);
                }
            }
        }

        for(int x : nums){
            ans= Math.max(ans,
            1l * x * dp[maxMask ^ x]);
        }

        return ans;

    }

}