class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int dp[] = new int[k];
        solve(dp, cookies, n, k, 0); 
        return res;
    }

    private void solve(int dp[], int cookie[], int n, int k, int i){
        if(i==n){
            int temp = 0;
            for(int x : dp) temp = Math.max(x, temp);
            res = Math.min(res, temp);
            return;
        }

        for(int j=0;j<k;j++){
            dp[j] += cookie[i];
            solve(dp, cookie, n, k, i+1);
            dp[j] -= cookie[i];
        }

    }
}