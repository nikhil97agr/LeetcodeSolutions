package minimum_increments_to_equalize_leaf_paths_3909;

import java.util.*;
import java.util.LinkedList;
import java.util.TreeMap;

class Solution {
    public int minIncrease(int n, int[][] edges, int[] cost) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        int path[] = new int[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int e[] : edges){
            int u =e[0];
            int v = e[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int max = dfs(0, adjList, -1, cost, 0, path);

        State state = dfs(0, adjList, -1, max, path);

        return state.cnt;
    }

    private State dfs(int curr, LinkedList<Integer> adjList[], int par, int max, int path[]){
        if(adjList[curr].size() == 1 &&  par != -1){
            State state = new State();
            state.map.put(path[curr], 1);
            state.cnt = (path[curr] != max ? 1 : 0);
            state.total = 1;
            state.maxCnt = 1;
            state.max = path[curr];
            return state;
        }

        State state = new State();
        TreeMap<Integer, Integer> map = state.map;
        int cnt = 0;
        int total = 0;
        
        for(int child : adjList[curr]){
            if(child == par) continue;
            State next = dfs(child, adjList, curr, max, path);
            map.merge(next.max, next.maxCnt, Integer::sum);
            cnt += next.cnt;
            total += next.total;
        }


        int min = map.floorKey(max);

        int next = 0;

        if(min == max){
            next = total - map.get(max);
        }else{
            next = 1 + total - map.get(min);
        }


        state.cnt = Math.min(cnt, next);
        state.total = total;
        state.max = min;
        state.maxCnt = map.get(min);

        return state;



    }

    private int dfs(int curr, LinkedList<Integer> adjList[],int par, int cost[], int currPath, int path[]){
        if(adjList[curr].size() == 1 && par != -1){
            path[curr] = currPath + cost[curr];
            return currPath + cost[curr];
        }


        int ans = Integer.MIN_VALUE;

        for(int child : adjList[curr]){
            if(child == par) continue;

            ans = Math.max(ans, dfs(child, adjList, curr, cost, currPath + cost[curr], path));
        }

        return ans;
    }


    class State{
        TreeMap<Integer, Integer> map;
        int cnt;
        int total;
        int maxCnt;
        int max;
        public State(){
            map = new TreeMap<>();
            cnt = 0;
            total = 0;
            maxCnt = 0;
            max = 0;
        }
    }
}