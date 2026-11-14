package distance_to_a_cycle_in_undirected_graph_1347;

import java.util.*;
class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
      Stack<Integer> stack = new Stack<>();

      LinkedList<Integer> adjList[] = new LinkedList[n];
      for(int i=0;i<n;i++){
        adjList[i] = new LinkedList<>();
      }
      for(int e [] : edges){
        int u = e[0];
        int v = e[1];
        adjList[u].add(v);
        adjList[v].add(u);
      }
      boolean vis[] = new boolean[n];
      Set<Integer> set = getCycle(0, adjList, stack, -1, vis);

      int ans[] = new int[n];


      for(int i=0;i<n;i++){
        if(set.contains(i)){
            dfs(0, i, -1, adjList, set, ans);
        }
      }

      return ans;
    }

    private void dfs(int depth, int curr, int par, LinkedList<Integer> adjList[], Set<Integer> set, int ans[]){

        for(int child : adjList[curr]){
            if(child == par || set.contains(child)) continue;

            ans[child] = depth + 1;

            dfs(depth + 1, child, curr, adjList, set, ans);
        }
    }

    private Set<Integer> getCycle(int curr, LinkedList<Integer> adjList[], Stack<Integer> stack, int par, boolean vis[]){
        vis[curr] = true;

        stack.push(curr);
        for(int child : adjList[curr]){
            if(child == par) continue;

            if(vis[child]){
                Set<Integer> res = new HashSet<>();

                while(stack.peek() != child){
                    res.add(stack.pop());
                }

                res.add(stack.pop());

                return res;
            }

            Set<Integer> res = getCycle(child, adjList, stack,curr, vis);

            if(!res.isEmpty()){
                return res;
            }
        }

        stack.pop();
        return new HashSet<>();
    }
}