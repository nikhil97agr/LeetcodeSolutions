package minimum_height_trees_310;

import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int e[] : edges){
            map.computeIfAbsent(e[0], a-> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], a-> new HashSet<>()).add(e[0]);
        }
        if(n<2){
            List<Integer> result =new ArrayList<>();
            for(int i=0;i<n;i++) result.add(i);
             return result;
        }

        int total = n;

        Queue<Integer> que = new LinkedList<>();

        for(int key : map.keySet()){
            if(map.get(key).size()==1) que.offer(key);
        }

        while(total > 2){
            int size = que.size();
            total -= size;
            while(size-->0){
                int x = que.poll();
                for(int ne : map.get(x)){
                    map.get(ne).remove(x);
                    if(map.get(ne).size()==1) que.offer(ne);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!que.isEmpty()) result.add(que.poll());
        return result;

    }
}