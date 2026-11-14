class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        if(n==2){
            if(nums[0] == nums[1]) return 1;
            return 2;
        }

        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int diff = nums[i] - nums[j];

                if(diff < 0){
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                }else if(diff > 0){
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));

        return ans;
    }

}