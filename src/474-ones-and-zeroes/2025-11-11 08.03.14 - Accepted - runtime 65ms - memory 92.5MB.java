class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int cnt[][] = new int[strs.length][2];
        Integer dp[][][] = new Integer[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            cnt[i] = getCnt(strs[i]);
        }
        return solve(strs, m, n, 0, 0, 0, cnt, dp);
    }

    private int solve(String arr[], int m, int n, int zero, int one, int i, int cnt[][], Integer dp[][][]){
        if(i==arr.length) return 0;

        if(dp[i][zero][one] != null) return dp[i][zero][one];
        String s = arr[i];
        int c[] = cnt[i];

        int ans = 0;
        if(c[0] + zero <=m && c[1] + one <= n){
            ans = 1 + solve(arr, m, n, zero+ c[0], one + c[1], i+1,  cnt, dp);
        }

        ans = Math.max(ans, solve(arr, m, n, zero, one, i+1, cnt, dp));

        return dp[i][zero][one]=ans;
    }
    private int[] getCnt(String s){
        char ch[] = s.toCharArray();
        int zero = 0;
        int one = 0;
        for(char c : ch){
            if(c == '0') zero++;
            else one++;
        }

        return new int[]{zero, one};
    }
}