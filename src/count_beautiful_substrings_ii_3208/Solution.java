package count_beautiful_substrings_ii_3208;

import java.util.*;
class Solution {
    public long beautifulSubstrings(String s, int k) {
        long ans = 0;
        Map<Long, Map<Long, Long>> map =new HashMap<>();
        Set<Character> vowel = Set.of('a','e','i','o','u');

        map.computeIfAbsent(0l, x-> new HashMap<>()).put(0l, 1l);
        long c = 0;
        long v = 0;
        for(char ch : s.toCharArray()){
            v += (vowel.contains(ch)) ? 1 : 0;
            c += (vowel.contains(ch)) ? 0 : 1;

            for(Map.Entry<Long, Long> entry : map.getOrDefault(v - c, new HashMap<>()).entrySet()){
                long key = entry.getKey();
                long val = entry.getValue();

                if(((v - key)*(v-key))%k==0){
                    ans += val;
                }
            }

            map.computeIfAbsent(v-c, x-> new HashMap<>()).merge(v%k, 1l, Long::sum);
        }

        return ans;
    }
}