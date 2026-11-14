package find_champion_ii_3189;

import java.util.*;
class Solution {
    public int findChampion(int n, int[][] edges) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();

        for(int e[] : edges){
            adjList[e[1]].add(e[0]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(adjList[i].size() ==0) list.add(i);
        }

        if(list.size() > 1) return -1;
        return list.get(0);

    }
}