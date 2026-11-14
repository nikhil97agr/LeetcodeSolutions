class Solution {
    public int minXor(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int pre[] = new int[n+1];

        for(int i=0;i<n;i++){
            pre[i +1] = pre[i] ^ nums[i];
        }
        if(k==1) return pre[n];
        int dp[][] = new int[n][k+1];
        for(int i=0;i<n;i++){
            dp[i][1] = pre[i+1];
        }

        for(int j=2;j<=k;j++){
            for(int i=1;i<n;i++){
                if( j > i +1) continue;
                int res= Integer.MAX_VALUE;
                for(int l=i;l >=j-1;l--){
                    res = Math.min(res, Math.max(dp[l-1][j-1], pre[i+1]^pre[l]));
                }

                dp[i][j] = res;
            }
        }

        return dp[n-1][k];
    }
}