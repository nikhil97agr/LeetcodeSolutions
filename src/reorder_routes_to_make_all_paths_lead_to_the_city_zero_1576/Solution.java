package reorder_routes_to_make_all_paths_lead_to_the_city_zero_1576;

import java.util.*;
class Solution {
    public int minReorder(int n, int[][] connections) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int con[] : connections){
            adjList[con[0]].add(con[1]);
            adjList[con[1]].add(-con[0]);
        }

        return solve(adjList, new boolean[n], 0);
    }
    private int solve(LinkedList<Integer> adjList[], boolean visited[], int start){
            int orientation = 0;

            visited[start] = true;

            Iterator<Integer> it = adjList[start].iterator();
            while(it.hasNext()){
                int next = it.next();

                if(!visited[Math.abs(next)]){
                    orientation += solve(adjList, visited, Math.abs(next)) + (next>0?1:0);
                }
            }
            return orientation;
    }
}