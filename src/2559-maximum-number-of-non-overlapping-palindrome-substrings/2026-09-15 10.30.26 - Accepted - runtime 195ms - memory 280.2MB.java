class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int len[][] =new int[n][n];
        for(int i=0;i<n;i++) len[i][i] = 1;
        for(int x = 2;x<=n;x++){
            int i=0;
            for(int j=i+x-1;j<n;j++,i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i+1 == j){
                        len[i][j] = 2;
                    }else{
                        if(len[i+1][j-1] == (j-1 - (i+1) +1)){
                            len[i][j] = len[i+1][j-1] + 2;
                        }
                    }
                }
            }
        }
        Integer dp[][] = new Integer[n][n];
        return solve(0, 0, len, k, n, dp);
    }

    private int solve(int i, int j, int len[][], int k, int n, Integer dp[][]){
        if(j == n){
            return 0;
        }
        if(dp[i][j] !=null){
            return dp[i][j];
        }
        int ans = solve(i+1, j+1, len, k, n, dp);
        int ind = j;
        for(;j<n;j++){
            if(len[i][j] >= k){
                ans = Math.max(ans, 1 + solve(j+1, j+1, len, k ,n, dp));
            }
        }

        return dp[i][ind] = ans;
    }
}