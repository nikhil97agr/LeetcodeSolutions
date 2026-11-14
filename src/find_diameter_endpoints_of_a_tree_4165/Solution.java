package find_diameter_endpoints_of_a_tree_4165;

import java.util.*;
class Solution {
    public String findSpecialNodes(int n, int[][] edges) {
        if(n==2) return "11";
        char res[] = new char[n];
        Arrays.fill(res, '0');
        Queue<int[]> que = new LinkedList<>();
        List<Integer> list[] = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            list[u].add(v);
            list[v].add(u);
        }

        que.offer(new int[]{0, 0});
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean vis[] =new boolean[n];
        vis[0] = true;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int u = next[0];
            int dist = next[1];
            map.computeIfAbsent(dist, x-> new ArrayList<>()).add(u);

            for(int child : list[u]){
                if(!vis[child]){
                    vis[child] = true;
                    que.offer(new int[]{child, dist + 1});
                }
            }
        }

        int max = map.keySet().stream().max(Integer::compareTo).get();
        que.clear();
        vis = new boolean[n];
        for(int x : map.get(max)){
            if(que.isEmpty()){
                que.offer(new int[]{x,0});
                vis[x] = true;
            }
            res[x] = '1';
        }
        map.clear();
        while(!que.isEmpty()){
            int next[] = que.poll();
            int u = next[0];
            int dist = next[1];
                    map.computeIfAbsent(dist, x-> new ArrayList<>()).add(u);

            for(int child : list[u]){
                if(!vis[child]){
                    vis[child] = true;
                    que.offer(new int[]{child, dist + 1});
                }
            }
        }

        max = map.keySet().stream().max(Integer::compareTo).get();
        for(int x : map.get(max)){
            res[x] = '1';
        }

        return new String(res);
    }
}