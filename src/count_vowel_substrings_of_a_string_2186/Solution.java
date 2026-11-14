package count_vowel_substrings_of_a_string_2186;

import java.util.*;
class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = word.length();
        int ans = 0;
        for(int i=0;i<word.length();i++){
            Set<Character> vis = new HashSet<>();
            for(int j=i;j<n && set.contains(word.charAt(j)); j++){
                vis.add(word.charAt(j));
                if(vis.size() == 5){
                    ans++;
                }
            }
        }

        return ans;
    }
}