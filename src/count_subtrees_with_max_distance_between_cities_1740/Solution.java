package count_subtrees_with_max_distance_between_cities_1740;

import java.util.*;
class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int ans[] = new int[n-1];

        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int e[] : edges){
            int u = e[0]-1;
            int v = e[1]-1;
            adjList[u].add(v);
            adjList[v].add(u);
        }
        for(int mask=1;mask<(1<<n);mask++){
            if(Integer.bitCount(mask) == 1)continue;
            if(component(mask, adjList, n)){
                int dia[] = new int[]{0};
                for(int i=0;i<n;i++){
                    if((mask & (1<<i))!=0){
                        diameter(mask, adjList, dia, i, -1);
                        break;
                    }
                }
                ans[dia[0]-1]++;
            }
        }

        return ans;
    }

    private int diameter(int mask, LinkedList<Integer> adjList[], int dia[], int src, int par){

        int max = 0;
        int second = 0;

        for(int child : adjList[src]){
            if(child == par || (mask & (1<<child)) ==0) continue;
            int d = diameter(mask, adjList, dia, child, src);

            if(d >= max){
                second = max;
                max =d;
            }else if(d > second){
                second = d;
            }
        }

        dia[0] = Math.max(max + second, dia[0]);
        return max + 1;
    }

    private boolean component(int mask, LinkedList<Integer> adjList[], int n){
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++){
            if((mask&(1<<i))!=0){
                dfs(mask, adjList, i, -1, vis);
                break;
            }
        }
        for(int i=0;i<n;i++){
            if((mask&(1<<i))!=0 && !vis[i]) return false;
        }

        return true;
    }

    private void dfs(int mask, LinkedList<Integer> adjList[], int src, int par, boolean vis[]){
        vis[src] = true;

        for(int child : adjList[src]){
            if(child == par || (mask & (1<<child)) ==0){
                continue;
            }

            dfs(mask, adjList, child, src, vis);
        }
    }
}