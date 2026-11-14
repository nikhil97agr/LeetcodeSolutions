package number_of_ways_to_paint_n_3_grid_1527;

class Solution {
    int combo[][] = new int[][]{
        {3,1,2},{3,1,3}, {3,2,1}, {3,2,3},
        {1,2,1}, {1,2,3}, {1,3,1}, {1,3,2},
        {2,1,3}, {2,3,1}, {2,1,2}, {2,3,2}
    };
    public int numOfWays(int n) {
        Integer dp[][][][] = new Integer[n][4][4][4];
        return solve(0, n, 0, 0, 0, dp);
    }

    private int solve(int i, int n, int i1, int i2, int i3, Integer dp[][][][]){
        if(i==n) return 1;
        if(dp[i][i1][i2][i3]!=null) return dp[i][i1][i2][i3];
        int ans = 0;
        for(int comb [] : combo){
            if(comb[0] !=i1 && comb[1]!=i2 && comb[2] != i3){
                ans = add(ans,solve(i+1, n, comb[0], comb[1], comb[2], dp));
            }
        }
        return dp[i][i1][i2][i3] = ans;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}