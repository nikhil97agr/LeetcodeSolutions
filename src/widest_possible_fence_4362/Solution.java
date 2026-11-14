package widest_possible_fence_4362;

import java.util.*;
class Solution {
    public int maximumWidth(int[] planks) {
        var m1 = new HashMap<Integer, Integer>();
        var m2 = new HashMap<Integer, Integer>();

        for(var x : planks){
            m1.merge(x, 1, Integer::sum);
            m2.merge(x, 1, Integer::sum);
        }
        int ans = 1;

        for(var x : m1.keySet()){
            for(var y : m1.keySet()){
                if(x < y){
                    m2.merge(x+y, Math.min(m1.get(x), m1.get(y)), Integer::sum);
                }

                if(x == y){
                    m2.merge(x + y, m1.get(x)/2, Integer::sum);
                }
            }
        }

        for(var x : m2.values()){
            ans = Math.max(ans, x);
        }


        return ans;
    }
}