package maximum_substrings_with_distinct_start_4087;

import java.util.*;
class Solution {
    public int maxDistinct(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        return set.size();
    }
}