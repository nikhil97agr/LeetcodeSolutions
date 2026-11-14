package pythagorean_distance_nodes_in_a_tree_4180;

import java.util.*;
class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<Integer> list[] = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v= e[1];
            list[u].add(v);
            list[v].add(u);
        }

        int dx[] = new int[n];
        int dy[] = new int[n];
        int dz[] = new int[n];

        dfs(x, -1, list, 0, dx);
        dfs(y, -1, list, 0, dy);
        dfs(z, -1, list, 0, dz);
        int ans = 0;
        for(int i=0;i<n;i++){
            if(check(dx[i], dy[i], dz[i]) || check(dy[i], dx[i], dz[i]) || check(dz[i], dx[i], dy[i])) ans++;
        }

        return ans;
        
    }

    private boolean check(long a, long b, long c){
        return a*a == b*b + c*c;
    }

    private void dfs(int curr, int par, List<Integer> list[], int dist, int d[]){
        d[curr] = dist;

        for(int child : list[curr]){
            if(child == par) continue;

            dfs(child, curr, list, dist+1, d);
        }
    }
}