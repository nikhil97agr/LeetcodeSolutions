class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        Integer dp[][] = new Integer[1<<n][m];
        return solve(bikes, workers, (1<<n)-1, 0, 0, dp);
    }

    private int solve(int bikes[][], int workers[][], int finalState, int state, int i, Integer dp[][]){
        if(state == finalState) return 0;

        if(i == bikes.length) return Integer.MAX_VALUE;
        if(dp[state][i]!=null) return dp[state][i];
        int ans = solve(bikes, workers, finalState, state, i+1, dp);
        for(int j=0;j<workers.length;j++){
            if((state & ( 1<<j)) ==0){
                int a = solve(bikes, workers, finalState, state |( 1<<j), i+1, dp);

                if(a != Integer.MAX_VALUE){
                    ans = Math.min(ans, a + dist(bikes[i], workers[j]));
                }
            }
        }

        return dp[state][i] = ans;
    }

    private int dist(int a[], int b[]){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}