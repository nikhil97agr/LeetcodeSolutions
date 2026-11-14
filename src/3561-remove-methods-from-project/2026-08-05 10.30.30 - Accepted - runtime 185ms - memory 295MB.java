import java.sql.Array;
import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(i);
        }
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int i[] : invocations){
            adjList[i[0]].add(i[1]);
        }

        Set<Integer> removed = new HashSet<>();

        dfs(removed, k, adjList, set);

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(set.contains(i)){
                if(!dfs2(vis, adjList, i, removed)){
                    List<Integer> ans = new ArrayList<>();
                    for(int j=0;j<n;j++){
                        ans.add(j);
                    }
                    return ans;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(set.contains(i)) ans.add(i);
        }
        return ans;

    }

    private boolean dfs2(boolean[] vis, LinkedList<Integer> adjList[], int u, Set<Integer> set){
        vis[u] = true;

        for(int x : adjList[u]){
            if(set.contains(x)) return false;
            if(vis[x]) continue;
            if(!dfs2(vis, adjList, x, set)) return false;
        }
        return true;
    }
    private void dfs(Set<Integer> set ,int u, LinkedList<Integer> adjList[], Set<Integer> set2){
        set.add(u);
        set2.remove(u);
        for(int x : adjList[u]){
            if(!set.contains(x)){
                dfs(set,x , adjList,set2);
            }
        }
    }
}