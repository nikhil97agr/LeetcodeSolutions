package shopping_offers_638;

import java.util.*;
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return solve(price, special, needs, map);
    }

    private int solve(List<Integer> price, List<List<Integer>> offer, List<Integer>need, Map<List<Integer>, Integer> map){
        if(map.containsKey(need)){
            return map.get(need);
        }
       int res = calc(price, need);

       for(List<Integer> o : offer){
        int j=0;
        List<Integer> clone = new ArrayList<>(need);
        for(;j<o.size() -1;j++){
            int diff = clone.get(j) - o.get(j);
            if(diff < 0) break;
            clone.set(j, diff);
        }
        if(j== o.size()-1){
            res = Math.min(res, o.get(j) + solve(price, offer, clone, map));
        }
       } 
        map.put(need, res);
       return res;

        
    }

    private int calc(List<Integer> price, List<Integer> need){
        int ans = 0;
        for(int i=0;i<price.size();i++){
            ans += price.get(i) * need.get(i);
        }

        return ans;
    }
}