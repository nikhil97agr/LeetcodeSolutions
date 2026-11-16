package add_edges_to_make_degrees_of_all_nodes_even_2596;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Set<Integer> adjList[] = new HashSet[n];
        for(int i=0;i<n;i++){ 
            adjList[i] = new HashSet<>();
        }
        for (var e : edges) {
            int u = e.get(0) - 1;
            int v = e.get(1) - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        List<Integer> set = new ArrayList<>();
        
        for(var i=0;i<n;i++){
            var s = adjList[i];
            if(s.size()%2==1){
                set.add(i);
            }
        }
        
        if(set.size() >=5 || set.size()%2==1) return false;
        
        if(set.isEmpty()) return true;
        
        if(set.size() == 2){
            int a = set.get(0);
            int b = set.get(1);

            if(!adjList[a].contains(b)) return true;
            for(int i=0;i<n;i++){
                if(!adjList[i].contains(a) && !adjList[i].contains(b)) return true;
            }
            return false;
        }
        
        for(int a : set){
            for(int b : set){
                if(a==b) continue;
                for(int c : set){
                    if(a==c || b ==c ) continue;
                    for(int d : set){
                        if(a ==d || b ==d || c==d) continue;
                        if(!adjList[a].contains(b) && !adjList[c].contains(d)) return true;
                    }
                }
            }
        }
        
        return false;

    }
}