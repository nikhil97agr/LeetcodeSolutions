class Solution {

    int price[][];
    Long dp[][];

    public long sellingWood(int m, int n, int[][] prices) {

        price = new int[m + 1][n + 1];
        dp = new Long[m+1][n+1];
        for (int p[] : prices) {
            price[p[0]][p[1]] = p[2];
        }
        return solve(m, n);
    }

    private long solve(int m, int n) {

        if (m == 1 && n == 1) {
            return price[1][1];
        }

        if(dp[m][n] !=null) return dp[m][n];

        if (m == 1) {
            long ans = price[m][n];
            for(int i=1;i<n;i++){
                ans = Math.max(ans, price[1][i] + solve(m, n - i));
            }

            return dp[m][n] = ans;
        }

        if( n == 1){
            long ans = price[m][n];
            for(int i=1;i<m;i++){
                ans = Math.max(ans, price[i][1] + solve(m-i, n));
            }
            return dp[m][n] = ans;
        }

        long ans = price[m][n];

        for(int i=1;i<n;i++){
            ans = Math.max(ans, solve(m, i) + solve(m, n-i));
        }
        
        for(int i=1;i<m;i++){
            ans = Math.max(ans, solve(i, n) + solve(m-i, n));
        }
        return dp[m][n] =ans;
    }
}