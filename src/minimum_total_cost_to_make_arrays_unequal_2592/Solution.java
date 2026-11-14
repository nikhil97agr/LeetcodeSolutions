package minimum_total_cost_to_make_arrays_unequal_2592;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public long minimumTotalCost(int[] n1, int[] n2) {

        int n = n1.length;
        long ans = 0;
        int max =0;
        int c = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int val = -1;
        for (int i = 0; i < n; i++) {
            if (n1[i] == n2[i]) {
                ans += i;
                c++;
                map.merge(n1[i], 1, Integer::sum);
                if(map.get(n1[i]) >  max){
                    max = map.get(n1[i]);
                    val = n1[i];
                }
            }
        }
        if (map.isEmpty()) {
            return 0;
        }

        if(max >n/2){
            return -1;
        }

        for(int i=0;i<n && 2 * max > c;i++){
            if(n1[i] != n2[i] && n1[i] !=val && n2[i] != val){
                c++;
                ans += i;
            }
        }
        
        if( 2 * max > c){
            return -1;
        }

        return ans;
    }
}