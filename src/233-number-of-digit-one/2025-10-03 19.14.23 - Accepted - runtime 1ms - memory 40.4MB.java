class Solution {
    public int countDigitOne(int n) {
        String num = (""+n);
        Integer dp[][][] = new Integer[num.length() + 2][2][num.length() + 2];

        return solve(dp, 0, 1, 0, num.toCharArray(), num.length());
    }

    private int solve(Integer dp[][][], int i, int flag, int cnt, char num[], int n){
        if(i==n) return cnt;

        if(dp[i][flag][cnt] !=null) return dp[i][flag][cnt];
            int ans = 0;

        if(flag == 1){
            int lim = num[i] - '0';

            for(int j=0;j<lim;j++){
                int next = cnt  + (j==1 ? 1 : 0);
                ans += solve(dp, i+1, 0, next, num, n);
            }

            ans += solve(dp, i+1, 1, cnt + (lim == 1 ? 1 : 0), num, n);
        }else{
            for(int j=0;j<=9;j++){
                int next = cnt + (j==1 ? 1 : 0);
                ans += solve(dp, i+1, 0, next, num, n);
            }
        }

        return dp[i][flag][cnt] = ans;
    }
}