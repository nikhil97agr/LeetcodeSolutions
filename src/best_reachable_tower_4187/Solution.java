package best_reachable_tower_4187;

import java.util.*;
class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        Arrays.sort(towers, (a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int a = -1;
        int b = -1;
        int q = -1;
        for(int t[] : towers){
            int dist = dist(center, t);
            if(dist <= radius){
                if(t[2] > q){
                    q = t[2];
                    a = t[0];
                    b = t[1];
                }
            }
        }

        return new int[]{a,b};
    }

    private int dist(int c[], int t[]){
        int x = Math.abs(c[0] - t[0]);
        int y = Math.abs(c[1] - t[1]);

        return x + y;
    }
}