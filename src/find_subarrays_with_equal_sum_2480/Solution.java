package find_subarrays_with_equal_sum_2480;

import java.util.*;
class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map =new HashMap<>();
        for(int i=0;i<n-1;i++){
            map.computeIfAbsent(nums[i] + nums[i+1], x -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()){
            if(list.size() >=2)return true;

            
        }

        return false;
    }
}