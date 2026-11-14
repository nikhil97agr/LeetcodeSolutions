package count_the_number_of_consistent_strings_1786;

import java.util.*;
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }

        int ans = 0;
        for(String s : words){
            Set<Character> c =new HashSet<>();
            for(char ch : s.toCharArray()){
                c.add(ch);
            }
            boolean matched = true;
            for(char ch : c){
                if(!set.contains(ch)){
                    matched = false;
                    break;
                }
            }
            if(matched)ans++;
        }
        return ans;
    }
}