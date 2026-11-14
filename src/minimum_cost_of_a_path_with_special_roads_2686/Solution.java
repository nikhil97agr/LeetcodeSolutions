package minimum_cost_of_a_path_with_special_roads_2686;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Map<Pair, List<Pair>> map =new HashMap<>();

        add(start, target, Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]), map);
        for(int i=0;i<specialRoads.length;i++){
            int road[] = specialRoads[i];
            int s [] = new int[]{road[0], road[1]};
            int e [] = new int[]{road[2], road[3]};
            int c = road[4];
            add(s, e, c, map);

            add(s, target, Math.abs(s[0] - target[0]) + Math.abs(s[1] - target[1]), map);
            add(start, s, Math.abs(start[0] - s[0]) + Math.abs(start[1] - s[1]), map);
            add(start, e, Math.abs(start[0] - e[0]) + Math.abs(start[1] - e[1]), map);
            add(e, target, Math.abs(e[0] - target[0]) + Math.abs(e[1] - target[1]), map);
            
            for(int j=0;j<specialRoads.length;j++){
                if(i==j) continue;

                int s2[] = new int[]{specialRoads[j][0], specialRoads[j][1]};
                int e2[] = new int[]{specialRoads[j][2], specialRoads[j][3]};

                add(s, s2, Math.abs(s[0] - s2[0]) + Math.abs(s[1] - s2[1]), map);
                add(s, e2, Math.abs(s[0] - e2[0]) + Math.abs(s[1] - e2[1]), map);
                add(e, s2, Math.abs(e[0] - s2[0]) + Math.abs(e[1] - s2[1]), map);
                add(e, e2, Math.abs(e[0] - e2[0]) + Math.abs(e[1] - e2[1]), map);
            }
        }

        PriorityQueue<Pair> que= new PriorityQueue<>((a,b) -> a.cost - b.cost);
        que.offer(new Pair(start[0], start[1], 0));
        Map<Pair, Integer> visited = new HashMap<>();
        visited.put(new Pair(start[0], start[1], 0), 0);
        while (!que.isEmpty()) {
            Pair next = que.poll();
            int x = next.x;
            int y = next.y;
            int cost = next.cost;


            for(Pair pair : map.getOrDefault(next, new ArrayList<>())){
                Pair p =new Pair(pair.x, pair.y, cost + pair.cost);
                if(!visited.containsKey(p)){
                    visited.put(p, p.cost);
                    que.offer(p);
                }else if(visited.get(p) > p.cost){
                    visited.put(p, p.cost);
                    que.offer(p);
                }
            }
        }

        return visited.get(new Pair(target[0], target[1], 0));

    }

    private void add(int start[], int end[], int cost, Map<Pair, List<Pair>> map){
        Pair p1 = new Pair(start[0], start[1], 0);
        Pair p2 = new Pair(end[0], end[1], cost);
        map.computeIfAbsent(p1, x-> new ArrayList<>()).add(p2);

    }

    class Pair{
        int x;
        int y;
        int cost;

        public Pair(int x, int y, int cost) {

            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}