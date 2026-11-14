package first_letter_to_appear_twice_2427;

import java.util.*;
class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
            if(set.contains(c)) return c;

            set.add(c);
        }

        return ' ';
    }
}