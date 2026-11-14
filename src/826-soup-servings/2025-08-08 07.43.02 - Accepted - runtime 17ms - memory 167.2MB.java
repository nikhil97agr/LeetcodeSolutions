class Solution {
    public double soupServings(int n) {
        if (n >= 5000)
            return 1d;

        Double dp[][] = new Double[n+1][n+1];

        return solve(n, n, dp);
    }

    private double solve(int n, int m, Double dp[][]) {
        if (n <= 0 && m <= 0)
            return 0.5d;

        if (n <= 0)
            return 1d;

        if (m <= 0)
            return 0;

        if (dp[n][m] != null)
            return dp[n][m];

        return dp[n][m] = 0.25*(solve(n - 100, m, dp) + solve(n - 75, m - 25, dp) + solve(n - 50, m - 50, dp)
                + solve(n - 25, m - 75, dp));
    }
}