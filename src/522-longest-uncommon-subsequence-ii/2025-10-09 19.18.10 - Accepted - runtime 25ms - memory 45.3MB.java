class Solution {
    public int findLUSlength(String[] strs) {
        int ans = 0;
        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        int n = strs.length;

        for(int i=0;i<n;i++){
            int len =0;
            for(int j=0;j<n;j++){
                if(j==i) continue;
                Integer dp[][] = new Integer[strs[i].length()][strs[j].length()];
                len = Math.max(len, solve(strs[i], strs[j], dp, 0, 0));
            }
            if(len != strs[i].length())
            ans = Math.max(ans, strs[i].length());
        }
        return ans == 0 ? -1 : ans;
    }

    private int solve(String s, String t, Integer dp[][], int i, int j){
        if(i==s.length() || j == t.length()) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans = 1 + solve(s, t, dp, i+1, j+1);
        }

        ans = Math.max(ans, Math.max(solve(s, t, dp, i+1, j), solve(s, t, dp, i, j+1)));

        return dp[i][j] = ans;
    }


    
}