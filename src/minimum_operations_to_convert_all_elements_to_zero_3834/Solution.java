package minimum_operations_to_convert_all_elements_to_zero_3834;

import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                set.add(i);
                continue;
            }
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        set.add(-1);
        set.add(n);

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Set<Integer> s = new HashSet<>();
            Map<Integer, Integer> m = new HashMap<>();
            for(int ind : entry.getValue()){
                Integer low = set.lower(ind);
                Integer high = set.higher(ind);
                s.add(ind);
                m.put(low, high);
            }
            
            ans += m.size();
            set.addAll(s);
            
            
        }

        return ans;
    }
}