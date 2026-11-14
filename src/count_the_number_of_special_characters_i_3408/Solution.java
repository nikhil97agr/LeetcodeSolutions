package count_the_number_of_special_characters_i_3408;

import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)) upper.add(ch);
            else lower.add(ch);
        
        }
        int ans = 0;
        for(char ch : lower){
            char c = Character.toUpperCase(ch);
            if(upper.contains(c)){
                ans++;
            }
        }
        return ans;
    }
}