package minimize_hamming_distance_after_swap_operations_1840;

import java.util.*;
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int cnt = 0;
        int par[] = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
        }

        for(int s[]:  allowedSwaps){
            int a=s[0];
            int b=s[1];
            int p1 = find(a, par);
            int p2 = find(b, par);
            par[p2] =p1;
        }
        var map =new HashMap<Integer, Map<Integer, Integer>>();
        for(int i=0;i<n;i++){
            int p = find(i, par);
            map.computeIfAbsent(p, x-> new HashMap<>()).merge(source[i], 1, Integer::sum);
        }

        for(int i=0;i<n;i++){
            int p = find(i, par);
            if(!map.containsKey(p)) continue;
            var m = map.get(p);
            if(m.containsKey(target[i])){
                cnt++;
                m.merge(target[i], -1, Integer::sum);
                if(m.get(target[i]) == 0){
                    m.remove(target[i]);
                }

                if(map.get(p).isEmpty()){
                    map.remove(p);
                }
            }
        }

        return n- cnt;

    }

    private int find(int p, int par[]){
        if(par[p] == p) return p;
        return par[p] = find(par[p], par);
    }
}