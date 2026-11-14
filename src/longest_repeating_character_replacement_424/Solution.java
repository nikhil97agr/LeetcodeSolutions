package longest_repeating_character_replacement_424;

import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        char ch[] = s.toCharArray();

        int ans = 0;
        int maxCount = 0;
        int n = s.length();
        while(end < n){
            map.put(ch[end], map.getOrDefault(ch[end], 0)+1);
            maxCount = Math.max(maxCount, map.get(ch[end]));
            int len = (end-start+1) - maxCount;
            if(len > k){
                map.put(ch[start], map.get(ch[start])-1);
                
                start++;
            }
            ans = Math.max(ans, end-start+1);
            end++;
        }

        return ans;
    }
}