package trim_trailing_vowels_4229;

import java.util.*;
class Solution {
    public String trimTrailingVowels(String s) {
        Set<Character> set =Set.of('a', 'e','i', 'o', 'u');

        int n = s.length();
        int i = n-1;
        while(i >=0){
            if(set.contains(s.charAt(i))){
                i--;
            }else{
                break;
            }
        }

        if(i < 0) return "";

        return s.substring(0, i + 1);
    }
}