class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int dp[][] = new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x, -1);
        }
        return solve(ring.toCharArray(), n, key.toCharArray(), m, 0, 0, dp);
    }

    private int solve(char[] ring, int n, char[] key, int m, int i, int j, int dp[][]){

        if(j == m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 1000000;
        for(int k=0;k<n;k++){
            if(ring[k] == key[j]){
                int temp = solve(ring, n, key, m, k, j+1, dp);
                int x = 1 + Math.abs(k-i);
                if( k > i){
                    x = Math.min(x, 1 + i  + n-k);
                }else if( k < i){
                    x = Math.min(x, 1 + (n-i-1) + k+1);
                }
                ans = Math.min(ans, temp + x);
            }
        }

        return dp[i][j] = ans;


    }
}