class Solution {
    public int alternatingXOR(int[] nums, int target1, int target2) {
        int s1 = target1;
        int s2 = target1 ^ target2;
        int s3 = target2;
        int s4 =0;
        int n = nums.length;
        int dp[] = new int[4];
        int xor = 0;
        for(int i=0;i<n;i++){
            int x = nums[i];
            xor ^= x;

            int cnt[] = new int[4];

            if(xor == s1){
                cnt[0] = add(1, dp[3]);
            }

            if(xor == s2){
                cnt[1] = dp[0];
            }

            if(xor == s3){
                cnt[2] = dp[1];
            }

            if(xor == s4){
                cnt[3] = dp[2];
            }

            

            if(i==n-1){
                 return add(cnt[0], add(cnt[1], add(cnt[2], cnt[3])));   
            }

            dp[0] = add(dp[0], cnt[0]);
            dp[1] = add(dp[1], cnt[1]);
            dp[2] = add(dp[2], cnt[2]);
            dp[3] = add(dp[3], cnt[3]);
        }

        return 0;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = 1l*a+b;

        return (int)(sum%mod);
    }
}