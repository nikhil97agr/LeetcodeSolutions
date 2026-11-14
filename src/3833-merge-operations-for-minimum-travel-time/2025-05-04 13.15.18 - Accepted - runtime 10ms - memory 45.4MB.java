class Solution {
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        Integer dp[][][] = new Integer[n+1][k+1][101];

        return solve(position, time, dp, 0, k, time[0],n);
    }

    private int solve(int pos[], int time[], Integer dp[][][], int i, int k, int t, int n){
        if(i==n-1){
            if(k==0) return 0;
            return Integer.MAX_VALUE;
        }
        if(dp[i][k][t]!=null) return dp[i][k][t];
        int ans = Integer.MAX_VALUE;
        int total = 0;
        for(int j=0;j<=k;j++){
            int ind = i+j+1;
            if(ind > n-1) break;
            total += time[ind];

            int temp = solve(pos, time, dp, ind, k-j, total, n);

            if(temp!=Integer.MAX_VALUE){
                ans = Math.min(ans, temp + (pos[ind] - pos[i])*t);
                
            }

        }

        return dp[i][k][t] = ans;
    }

}