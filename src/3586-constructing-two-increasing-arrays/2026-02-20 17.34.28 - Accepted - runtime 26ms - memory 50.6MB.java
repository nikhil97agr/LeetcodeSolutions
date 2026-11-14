class Solution {
    public int minLargest(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=m;i++){
            dp[0][i] = next(dp[0][i-1], nums2[i-1]);
        }

        for(int i=1;i<=n;i++){
            dp[i][0] = next(dp[i-1][0], nums1[i-1]);

            for(int j=1;j<=m;j++){
                dp[i][j] = Math.min(next(dp[i-1][j], nums1[i-1]), next(dp[i][j-1], nums2[j-1]));
            }
        }

        return dp[n][m];

    }

    private int next(int prev, int flag){
        if(flag == 0){
            if(prev%2==0) return prev +  2;
            return prev+ 1;
        }else{
            if(prev%2==1) return prev + 2;
            return prev + 1;
        }
    }
}