package course_schedule_iv_1558;

import java.util.*;
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] queries) {
        List<Boolean> res = new ArrayList<>();

        int degree[] = new int[n];

        LinkedList<Integer> adjList[] = new LinkedList[n];

        init(adjList);
        Set<Integer> set[] = new HashSet[n];
        for(int i=0;i<n;i++){
            set[i] = new HashSet<>();
            set[i].add(i);
        }
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            degree[v]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0) que.offer(i);
        }

        while(!que.isEmpty()){
            int u = que.poll();

            for(int v : adjList[u]){
                degree[v]--;
                set[v].addAll(set[u]);
                if(degree[v]==0){
                    que.offer(v);
                }
            }
        }

        for(int q[] : queries){
            int u=q[0], v=q[1];
            if(set[v].contains(u)){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;

    }


    private void init(LinkedList<Integer> adjList[])
    {
        for(int i=0;i<adjList.length;i++){
            adjList[i] = new LinkedList<>();
        }
    }
}