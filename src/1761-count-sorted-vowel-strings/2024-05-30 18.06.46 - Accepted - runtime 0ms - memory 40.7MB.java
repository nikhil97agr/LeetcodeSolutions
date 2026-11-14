class Solution {
    public int countVowelStrings(int n) {
        Integer dp[][] = new Integer[n][5];

        return solve(0, n, dp, 0);
    }

    private int solve(int i, int n, Integer dp[][], int vow){
        if(i==n) return 1;
        if(vow >=5 ) return 0;
        if(dp[i][vow]!=null) return dp[i][vow];

        int cnt = 0;
        for(int j=vow;j<5;j++){
            cnt += solve(i+1, n, dp, j);
        }
        return dp[i][vow] = cnt;
    }
}