class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Integer dp[][] = new Integer[n][m];
        
        return solve(nums1, nums2, n-1,m-1, dp);
    }

    private int solve(int a1[], int a2[], int i, int j, Integer dp[][]){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(a1[i]==a2[j]){
            dp[i][j] = solve(a1, a2, i-1, j-1, dp)+1;
        }else{
            dp[i][j] = Math.max(solve(a1, a2, i, j-1, dp), solve(a1,a2, i-1, j, dp));
        }

        return dp[i][j];
    }
}