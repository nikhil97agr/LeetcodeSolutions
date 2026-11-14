class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            int max = 0;
            for(int j=i-1;j>=0;j--){
                int ans = dp[j];
                if(ch[i]==ch[j]){
                    dp[j] = 2 + max;

                }

                max = Math.max(max, ans);
            }
        }
        int ans = 0;
        for(int x : dp){
            ans = Math.max(ans, x);
        }
        return ans;
    }
}