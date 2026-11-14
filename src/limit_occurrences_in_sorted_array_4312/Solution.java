package limit_occurrences_in_sorted_array_4312;

import java.util.*;
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        int prev = nums[0];
        for(int x : nums){
            if(prev == x){
                if(cnt !=k){
                    cnt++;
                    result.add(x);
                }
            }else{
                result.add(x);
                prev = x;
                cnt = 1;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}