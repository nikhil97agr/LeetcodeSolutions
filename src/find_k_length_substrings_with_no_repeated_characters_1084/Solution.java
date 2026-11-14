package find_k_length_substrings_with_no_repeated_characters_1084;

import java.util.*;
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        int start = 0;
        int end = 0;
        while(end < k-1){
            map.merge(s.charAt(end), 1, Integer::sum);
            end++;
        }
        int n = s.length();
        while(end < n){
            map.merge(s.charAt(end), 1, Integer::sum);
            end++;
            if(map.size()==k) ans++;
            char ch = s.charAt(start);

            map.merge(ch, -1, Integer::sum);
            if(map.get(ch) ==0) map.remove(ch);
            start++;
        }

        return ans;
    }
}