package number_of_pairs_of_strings_with_concatenation_equal_to_target_2133;

import java.util.*;
class Solution {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        int n= target.length();
        for(String s : nums){
            if(target.startsWith(s)){
                String sub = target.substring(s.length());
                ans += map.getOrDefault(sub, 0);
            }

            if(target.endsWith(s)){
                String sub = target.substring(0, n-s.length());
                ans += map.getOrDefault(sub, 0);
            }
            map.put(s, map.getOrDefault(s,0)+1);
        }
        return ans;

    }
}