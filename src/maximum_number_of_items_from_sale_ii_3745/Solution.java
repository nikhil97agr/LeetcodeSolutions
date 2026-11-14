package maximum_number_of_items_from_sale_ii_3745;

import java.util.*;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int min = Integer.MAX_VALUE;

        for(int i[] : items){
            min = Math.min(min, i[1]);
        }

        Map<Integer, Integer> factors = new HashMap<>();
        for(int i[] : items){
            compute(factors, i[0]);
        }

        var map = new TreeMap<Integer, Long>();
        for(int i[] : items){
            int f = i[0];
            int p = i[1];

            int extra = factors.get(f) - 1;

            if(extra > 0 && p < 2 * min ){
                map.put(p, map.getOrDefault(p, 0l) + extra);
            }
        }


        int ans = 0;
        for(var entry : map.entrySet()){
            var p = entry.getKey();
            var extra = entry.getValue();

            int qty = budget / p;

            long minQty = Math.min(qty, extra);
            budget -= p * minQty;
            ans += minQty * 2;
        }

        return ans + budget/ min;

    }

    private void compute(Map<Integer, Integer> map, int f){
        for(int i=1;i<=Math.sqrt(f);i++){
            if(f%i==0){
                int a= f/i;
                int b = i;

                map.merge(b, 1, Integer::sum);
                if(a!=b){
                    map.merge(a, 1, Integer::sum);
                }
            }
        }
    }

}