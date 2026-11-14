class Solution {
    public long[] resultArray(int[] nums, int k) {
        long ans[] = new long[k];

        for(int x=0;x<k;x++){
            long dp[] = new long[k];
            long total = 0;
            for(int y : nums){
                long newDp[] = new long[k];
                for(int i=0;i<k;i++){
                    int rem = (int)((1l*i*y)%k);
                    newDp[rem] += dp[i];
                }
                newDp[y%k]++;
                dp = newDp;
                total += dp[x];
            }
            ans[x] = total;
        }

        return ans;
    }
}