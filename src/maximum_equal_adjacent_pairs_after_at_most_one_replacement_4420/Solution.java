package maximum_equal_adjacent_pairs_after_at_most_one_replacement_4420;

import java.util.*;
class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int equal = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length - 1;i++){
            long min = Math.min(nums[i], nums[i+ 1]);
            long max = Math.max(nums[i], nums[i + 1]);
            if(min == max){
                equal++;
                continue;
            }
            String key = min+":"+max;

            map.merge(key, 1, Integer::sum);

        
        }
        return equal + map.values().stream().max(Integer::compareTo).orElse(0);
    }
}