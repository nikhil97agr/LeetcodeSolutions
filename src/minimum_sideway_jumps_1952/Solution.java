package minimum_sideway_jumps_1952;

class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        Integer dp[][] = new Integer[n+1][4];
        return solve(0, 2, obstacles, n-1, dp);
    }

    private int solve(int i, int lane, int obstacles[], int n, Integer dp[][]){
        if(i==n) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][lane]!=null) return dp[i][lane];
        if(obstacles[i+1]!= lane ){
            ans = solve(i+1, lane, obstacles, n, dp);
        }else{
            int obs = obstacles[i];
            
            if(lane -1 > 0 && obs != lane-1){
                ans = Math.min(ans, 1 + solve(i+1 , lane-1, obstacles, n, dp));
            }
            if(lane -2 > 0 && obs != lane - 2){
                ans = Math.min(ans, 1 + solve(i+1, lane - 2, obstacles, n, dp));
            }
            if(lane +1 <= 3 && obs != lane + 1){
                ans = Math.min(ans, 1 + solve(i+1, lane + 1, obstacles, n, dp));
            }

            if(lane + 2 <= 3 && obs != lane + 2){
                ans = Math.min(ans, 1 + solve(i+1, lane + 2, obstacles, n, dp));
            }
        }

        return dp[i][lane] = ans;

        
    }
}