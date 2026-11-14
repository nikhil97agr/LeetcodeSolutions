package find_the_longest_substring_containing_vowels_in_even_counts_1473;

import java.util.*;
class Solution {
    public int findTheLongestSubstring(String s) {
        int prefix[] =new int[32];
        Arrays.fill(prefix, -2);
        prefix[0] = -1;
        Map<Character, Integer> map = new HashMap<>();

        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        int bit = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
            int ind = map.get(c);

            bit = bit^(1<<ind);

            if(prefix[bit] == -2 ) prefix[bit]=i;
            }
            ans = Math.max(ans, i - prefix[bit]);

        }
        return ans;
    }
}