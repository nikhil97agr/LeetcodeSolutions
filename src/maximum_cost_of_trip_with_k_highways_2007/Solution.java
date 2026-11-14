package maximum_cost_of_trip_with_k_highways_2007;

import java.util.*;
class Solution {
    public int maximumCost(int n, int[][] highways, int k) {
        List<int[]> []list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] =new ArrayList<>();

        }

        if( k > highways.length) return -1;
        for(int e[] : highways){
            int u = e[0];
            int v = e[1];
            int t = e[2];
            list[u].add(new int[]{v, t});
            list[v].add(new int[]{u, t});
        }
        int finalMask = (1<<n)-1;
        Integer dp[][][] = new Integer[n][finalMask + 1][k+1];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, solve(1<<i, finalMask, i, list, k, dp));
        }

        return Math.max(ans, -1);
    }

    private int solve(int mask, int finalMask, int curr, List<int[]>[] list, int k, Integer dp[][][] ){
        if(k==0) return 0;
        if(mask == finalMask){
            return Integer.MIN_VALUE;
        }

        if(dp[curr][mask][k]!=null) return dp[curr][mask][k];
        int ans = Integer.MIN_VALUE;
        for(int child[] : list[curr]){
            int u = child[0];
            int t = child[1];

            if((mask & (1<<u))!=0) continue;

            ans = Math.max(ans, t + solve(mask | (1<<u), finalMask, u, list, k-1, dp));
        }

        return dp[curr][mask][k] =  ans;
    }


}