package minimum_cost_walk_in_weighted_graph_3348;

import java.util.*;
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int par[] = new int[n];
        for(int i=0;i<n;i++) par[i] = i;

        for(int e[] : edges){
            int p1 = find(par, e[0]);
            int p2 = find(par, e[1]);

            if(p1 != p2){
                par[p1] = p2;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = (1<<31)-1;

        for(int e[] : edges){
            int p1 = find(par, e[0]);
            int p2 = find(par, e[1]);
            if(p1 == p2){
                map.put(p1, map.getOrDefault(p1, max)&e[2]);
            }
        }

        int ans[] = new int[query.length];
        Arrays.fill(ans, -1);

        for(int i=0;i<query.length;i++){
            int s = query[i][0];
            int e = query[i][1];

            int p1 = find(par, s);
            int p2 = find(par, e);

            if(p1 == p2){
                ans[i] = map.get(p1);
            }
        }

        return ans;
    }

    private int find(int par[], int p){
        if(par[p] == p){
            return p;
        }
        return par[p] = find(par, par[p]);
    }
}