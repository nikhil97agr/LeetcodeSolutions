package minimum_total_distance_traveled_2554;

import java.util.*;

class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();

        List<Integer> factories =new ArrayList<>();
        
        for(int f[] : factory){
            for(int i=0;i<f[1];i++){
                factories.add(f[0]);
            }
        }
        Collections.sort(factories);
        Collections.sort(robot);
        int m = factories.size();
        Long dp[][] = new Long[n+1][m+1];

        return solve(robot, factories, n, m, dp);

    }

    private long solve(List<Integer> robot,List<Integer> factory, int n, int m, Long dp[][]){

        if(n==0) return 0l;

        if(m==0) return Long.MAX_VALUE;

        if(dp[n][m]!=null) return dp[n][m];
        
        long ans1 = solve(robot, factory, n-1, m-1, dp);
        long ans2 = solve(robot, factory, n, m-1, dp);

        if(ans1 != Long.MAX_VALUE) ans2 = Math.min(ans2, ans1 + Math.abs(factory.get(m-1)-robot.get(n-1)));

        return dp[n][m] = ans2;
    
    }

}