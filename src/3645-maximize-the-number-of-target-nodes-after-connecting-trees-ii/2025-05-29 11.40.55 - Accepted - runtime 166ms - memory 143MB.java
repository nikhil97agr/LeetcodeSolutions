import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        LinkedList<Integer> tree1[] = buildGraph(edges1, n);
        LinkedList<Integer> tree2[] = buildGraph(edges2, m);

        int res[] = new int[n];
        Map<Integer, Integer> t1 = new HashMap<>();
        Map<Integer, Integer> t2 = new HashMap<>();

        dfs(0, 0,0, tree1, t1);
        dfs(0, 0, 0,tree2, t2);
        int max = t2.values().stream().max(Integer::compareTo).get();
        int cnt[] = new int[n];
        dfs2(0, 0, 0, tree1, t1, cnt);

        for(int i=0;i<n;i++){
            res[i] = cnt[i] + max;
        }
        return res;
    }

    private void dfs2(int src, int dest, int level, LinkedList<Integer> adjList[], Map<Integer, Integer> map, int cnt[]){
        cnt[dest] = map.get(level);

        for(int child : adjList[dest]){
            if(src !=child){
                dfs2(dest, child, (level+1)%2, adjList, map, cnt);
            }
        }
    }

    private void dfs(int src, int dest, int level, LinkedList<Integer>[] tree1, Map<Integer, Integer> map) {
        map.put(level, map.getOrDefault(level, 0)+1);

        for(int child : tree1[dest]){
            if(child != src){
                dfs(dest, child, (level+1)%2, tree1, map);
            }
        }
    }


    private LinkedList<Integer>[] buildGraph(int edges[][], int n){
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        return adjList;
    }
}