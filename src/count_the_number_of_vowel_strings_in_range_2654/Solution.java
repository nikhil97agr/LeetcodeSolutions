package count_the_number_of_vowel_strings_in_range_2654;

import java.util.*;
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count = 0;
        for(int i=left;i<=right;i++){
            int n = words[i].length();
            String word = words[i];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(n-1))){
                count++;
            }
        }
        return count;
    }
}