package painting_the_walls_2808;

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Long dp[][] = new Long[n][n+1];
        return (int)solve(cost, time ,0, 0, n, dp);
    }

    private long solve(int cost[], int time[], int i, int wallsPainted, int n, Long dp[][]){
        if(wallsPainted >=n ) return 0;
        if(i >= n) return Integer.MAX_VALUE;

        if(dp[i][wallsPainted]!=null) return dp[i][wallsPainted];

        long temp = Math.min(cost[i] + solve(cost, time, i+1, wallsPainted + time[i]+1, n, dp), solve(cost, time, i+1, wallsPainted, n, dp));

        return  dp[i][wallsPainted] = temp;

    }
}