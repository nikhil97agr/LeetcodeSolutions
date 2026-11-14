package vowels_of_all_substrings_2187;

import java.util.*;
class Solution {
    public long countVowels(String word) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        long ans = 0;
        int n = word.length();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(set.contains(c)){
                int start = i+1;
                int end = n-i;
                ans += 1l*start*end;
            }


        }
        return ans;
    }
}