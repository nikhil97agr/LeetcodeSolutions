package maximum_multiplication_score_3518;

class Solution {
    public long maxScore(int[] a, int[] b) {
        Long dp[][] = new Long[4][b.length];
        return solve(a, b, 0, 0, 4, b.length ,dp);
    }

    private long solve(int a[], int b[], int i1, int i2, int lena, int lenb, Long dp[][]){
        if(i1 == lena) return 0l;

        if(i2 == lenb) return Long.MIN_VALUE;
        if(dp[i1][i2] !=null) return dp[i1][i2];
        long ans1 = solve(a, b, i1, i2+1, lena, lenb, dp);
        long ans2 = solve(a, b, i1 +1, i2 + 1, lena, lenb, dp);
        if(ans2 != Long.MIN_VALUE){
            ans2 += 1l*a[i1]*b[i2];
        }

        return dp[i1][i2] = Math.max(ans1, ans2);
    }
}