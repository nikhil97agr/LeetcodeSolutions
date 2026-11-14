package number_of_different_integers_in_a_string_1933;

import java.util.*;
class Solution {
    public int numDifferentIntegers(String word) {
        for(char c = 'a'; c<='z';c++){
            word = word.replaceAll(""+c, " ");
        }
        Set<String> set = new HashSet<>();
        String words[] = word.split(" ");
        for(String s : words){
            while(s.length() > 1 && s.indexOf("0") == 0){
                s = s.substring(1);
            }
            if(!s.isEmpty()) set.add(s);
        }


        return set.size();
    }
}