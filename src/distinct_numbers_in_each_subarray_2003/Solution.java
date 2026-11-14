package distinct_numbers_in_each_subarray_2003;

import java.util.*;
class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k-1;i++){
            map.merge(nums[i], 1, Integer::sum);
        }
        int start = 0;
        int end = k-1;
        while(end < n){
            map.merge(nums[end], 1, Integer::sum);
            result.add(map.size());
            map.merge(nums[start], -1, Integer::sum);
            if(map.get(nums[start]) ==0) map.remove(nums[start]);
            end++;
            start++;
        }

        return result.stream().mapToInt(x-> x).toArray();
    }
}