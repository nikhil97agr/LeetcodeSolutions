package count_covered_buildings_3819;

import java.util.*;
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> x = new HashMap<>();
        Map<Integer, TreeSet<Integer>> y = new HashMap<>();

        for(int cor[] : buildings){
            int x1 = cor[0];
            int y1 = cor[1];
            x.computeIfAbsent(x1, z -> new TreeSet<>()).add(y1);
            y.computeIfAbsent(y1, z-> new TreeSet<>()).add(x1);
        }

        int ans = 0;

        for(int b[]: buildings){
            int x1 = b[0];
            int y1 = b[1];

            if(x.get(x1).lower(y1) != null &&
              x.get(x1).higher(y1) != null &&
              y.get(y1).lower(x1) != null && 
              y.get(y1).higher(x1) != null){
               ans++; 
              }
        }

        return ans;
    }
}