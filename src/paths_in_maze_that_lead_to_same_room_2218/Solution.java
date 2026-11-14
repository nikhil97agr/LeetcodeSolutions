package paths_in_maze_that_lead_to_same_room_2218;

import java.util.*;
class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int x[] : corridors){
            map.computeIfAbsent(x[0], e-> new HashSet<>()).add(x[1]);
            map.computeIfAbsent(x[1], e-> new HashSet<>()).add(x[0]);
        }
        int cnt = 0;
        for(int e[] : corridors){
            Set<Integer> s1 = map.get(e[0]);
            Set<Integer> s2 = map.get(e[1]);

            s1.remove(e[1]);
            s2.remove(e[0]);

            for(int x : s1){
                if(s2.contains(x)) cnt++;
            }


        }

        return cnt;

    }
}