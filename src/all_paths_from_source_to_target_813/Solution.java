package all_paths_from_source_to_target_813;

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Integer>();
            for(int x : graph[i]){
                adjList[i].add(x);
            }
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        boolean visited[] =new boolean[n];
        dfs(0, list, result, adjList, n, visited);
        return result;
    }

    private void dfs(int src, List<Integer> list, List<List<Integer>> result, LinkedList adjList[], int n, boolean visited[]){
        if(src==n-1){
            list.add(src);
            result.add(list.stream().collect(Collectors.toList()));
            list.remove(list.size()-1);
            return;
        }

        visited[src] = true;
        list.add(src);
        Iterator<Integer> it = adjList[src].iterator();
        while(it.hasNext()){
            int x = it.next();
            if(!visited[x]){
                dfs(x, list,result, adjList, n, visited);
            }
        }

        visited[src] = false;
        list.remove(list.size()-1);
    }
}