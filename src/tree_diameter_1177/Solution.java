package tree_diameter_1177;

import java.util.*;
class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length+1;

        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        int farNode[] = bfs(0, adjList);

        int nextFarNode[] = bfs(farNode[0], adjList);

        return nextFarNode[1];
    }

    private int[] bfs(int start, LinkedList<Integer> adjList[]){
        boolean visited[] = new boolean[adjList.length];

        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        int dist = -1;
        int farNode = 0;
        que.offer(start);

        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){
                int next = que.poll();
                for(int ne : adjList[next]){
                    if(!visited[ne]){
                        visited[ne] = true;
                        que.offer(ne);
                        farNode = ne;
                    }
                }
            }
        
            dist++;

        }
        System.out.println(dist);
         return new int[]{farNode, dist};
    }



}