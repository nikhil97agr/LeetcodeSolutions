package minimum_number_of_operations_to_satisfy_conditions_3404;

import java.util.*;
class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> map[] = new HashMap[m];
        
        for(int i=0;i<m;i++){
            map[i] = new HashMap<>();
            for(int j=0;j<n;j++){
                int x = grid[j][i];
                map[i].put(x, map[i].getOrDefault(x, 0)+1);
            }
        }
        Integer dp[][] = new Integer[m][11];
        
        return solve(dp, 10, 0,m, map, n);
    }
    
    private int solve(Integer dp[][],int prev,  int ind, int m, Map<Integer, Integer> map[], int n){
        if(ind == m){
            return 0;
        }
        
        if(dp[ind][prev] != null) return dp[ind][prev];
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<=9;i++){
            if(i != prev){
                ans = Math.min(ans, n - map[ind].getOrDefault(i, 0) + solve(dp, i, ind+1, m, map, n));
            }
        }
        
        return dp[ind][prev] = ans;
    }
}