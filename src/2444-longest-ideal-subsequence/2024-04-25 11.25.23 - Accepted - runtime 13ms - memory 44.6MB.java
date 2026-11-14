class Solution {
    public int longestIdealString(String s, int k) {
        int dp[] = new int[27];
        for(int i=s.length()-1;i>=0;i--){
            int ind = s.charAt(i) - 'a';

            int start = Math.max(ind - k, 0);
            int end = Math.min(ind + k, 26);

            int ans = Integer.MIN_VALUE;
            while(start <= end){
                ans = Math.max(ans, dp[start]);
                start++;
            }
            dp[ind] = ans+1;
        }

        int ans = Integer.MIN_VALUE;
        for(int x : dp){
            ans = Math.max(ans, x);
        }
        return ans;
    }
}