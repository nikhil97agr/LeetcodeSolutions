package power_grid_maintenance_3863;

import java.util.*;

class Solution {
    public int[] processQueries(int n, int[][] connections, int[][] queries) {
        LinkedList<Integer> adjList[] = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            adjList[i] =new LinkedList<>();
        }

        for(int c[] : connections){
            int u = c[0];
            int v = c[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }


        Map<Integer, Integer> station = new HashMap<>();
        Map<Integer, TreeSet<Integer>> grid =new HashMap<>();
        boolean vis[] =new boolean[n+1];
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(adjList, station, grid, vis, cnt, i);
                cnt++;
            }
        }

        List<Integer> list = new ArrayList<>();

        Set<Integer> offline = new HashSet<>();
        for(int q[] : queries){
            int type = q[0];
            int x  = q[1];
            int id = station.get(x);
            if(type == 2){
                offline.add(x);
                if(!grid.getOrDefault(id, new TreeSet<>()).isEmpty() && grid.get(id).contains(x)) {
                    grid.get(id).remove(x);
                    if(grid.get(id).isEmpty()){
                        grid.remove(id);
                    }
                }
                
            }else{
                if(!offline.contains(x)){
                    list.add(x);
                }else{
                    TreeSet<Integer> set = grid.getOrDefault(id, new TreeSet<>());
                    if(set.isEmpty()){
                        list.add(-1);
                    }else{
                        list.add(set.first());
                    }
                }
            }
        }

        int ans[] = new int[list.size()];

        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;



    }

    private void dfs(LinkedList<Integer>[] adjList, Map<Integer, Integer> station, Map<Integer, TreeSet<Integer>> grid, boolean[] vis, int cnt, int u) {


        vis[u] = true;
        grid.computeIfAbsent(cnt, c-> new TreeSet<>()).add(u);
        station.put(u, cnt);

        for(int child : adjList[u]){
            if(!vis[child]){
                dfs(adjList, station, grid, vis, cnt, child);
            }
        }
    }

}