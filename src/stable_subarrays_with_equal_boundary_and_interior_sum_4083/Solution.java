package stable_subarrays_with_equal_boundary_and_interior_sum_4083;

import java.util.*;
class Solution {
    public long countStableSubarrays(int[] capacity) {
        long ans= 0;
        Map<Long, Map<Integer, List<Integer>>> map = new HashMap<>();
        long sum = 0;
        int n = capacity.length;
        for(int i=0;i<n;i++){
            long req= sum - capacity[i];
            List<Integer> list = map.getOrDefault(req, new HashMap<>()).getOrDefault(capacity[i], new ArrayList<>());
            ans += getCnt(list, i-2);
            sum += capacity[i];
            map.computeIfAbsent(sum, x->new HashMap<>()).computeIfAbsent(capacity[i], y-> new ArrayList<>()).add(i);
        }

        return ans;
    }

    private int getCnt(List<Integer> list, int i){
        int ind = list.size() - 1;
        while( ind >= 0 && list.get(ind) > i){
            ind--;
        }

        return ind + 1;
    }
}