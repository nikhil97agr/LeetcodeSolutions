class Solution {
    Long dp[][][];
    public long maxScore(int[] nums1, int[] nums2, int k) {
        dp = new Long[nums1.length][nums2.length][k+1];
        return solve(0, 0, k, nums1, nums2);
    }

    private long solve(int i, int j, int k, int n1[], int n2[]){
        if( k ==0 ) return 0;
        if( i == n1.length || j == n2.length) return Long.MIN_VALUE;

        if(dp[i][j][k] !=null) return dp[i][j][k];

        long a= solve(i+1, j, k, n1, n2);
        long b = solve(i, j+1, k, n1, n2);
        long c = solve(i+1, j+1, k-1, n1, n2);

        if(c != Long.MIN_VALUE){
            c += 1l*n1[i] * n2[j];
        }

        return dp[i][j][k] = Math.max(a, Math.max(b,c));
    }
}