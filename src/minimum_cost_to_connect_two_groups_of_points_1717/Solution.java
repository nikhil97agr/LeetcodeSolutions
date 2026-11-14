package minimum_cost_to_connect_two_groups_of_points_1717;

import java.util.*;
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size();
        int n =cost.get(0).size();
        Integer dp[][] = new Integer[m][(1<<n)];
        return solve(0, cost,0, m, n, dp);
    }

    private int solve(int i, List<List<Integer>> cost,int curr, int m, int n, Integer dp[][]){
        if(i==m){
            int extra = 0;
            for(int j=0;j<n;j++){
                if((curr & (1<<j))==0){
                    int min = 1001;
                    for(i=0;i<m;i++){
                        min = Math.min(min, cost.get(i).get(j));
                    }
                extra += min;
                    
                }
            }

            return extra;
        }

        if(dp[i][curr]!=null) return dp[i][curr];


        int ans = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){

                ans = Math.min(ans, cost.get(i).get(j) + solve(i+1, cost, curr | (1<<j), m, n, dp));
            
        
    }

        return dp[i][curr] = ans;
    }
}