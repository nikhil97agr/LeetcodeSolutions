package count_unhappy_friends_1705;

import java.util.*;
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            Map<Integer, Integer> m = new HashMap<>();
            for(int j=0;j<n-1;j++){
                m.put(preferences[i][j], j);
            }
            map.put(i, m);
        }
        int m = pairs.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(j==i) continue;

                int x = pairs[i][0];
                int y = pairs[i][1];
                int u = pairs[j][0];
                int v = pairs[j][1];

                if(check(x, y, u, v, map) || check(x, y, v, u, map)){
                    set.add(x);
                }

                if(check(y,x,u,v, map) || check(y,x,v,u, map)){
                    set.add(y);
                }

                if(check(u,v,x,y, map) || check(u,v,y,x, map)){
                    set.add(u);
                }

                if(check(v,u, x,y, map) || check(v,u,y,x,map)){
                    set.add(v);
                }


            }
        }
        return set.size();
    }

    private boolean check(int x, int y, int u, int v, Map<Integer, Map<Integer, Integer>> map){
        Map<Integer, Integer> m1 = map.get(x);
        Map<Integer, Integer> m2 = map.get(u);
        
        return m1.get(u) < m1.get(y) && m2.get(x) < m2.get(v);
    }
}