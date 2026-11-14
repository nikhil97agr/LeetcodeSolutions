package four_keys_keyboard_651;

class Solution {
    public int maxA(int n) {
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = i;
        }

        for(int i=1;i<=n;i++){
            for(int j=i+3;j<=n;j++){
                dp[j] = Math.max(dp[j], (j-i-1)*dp[i]);
            }
        }
        return dp[n];
    }
}