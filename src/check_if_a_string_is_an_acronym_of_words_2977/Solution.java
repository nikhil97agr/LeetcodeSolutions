package check_if_a_string_is_an_acronym_of_words_2977;

import java.util.*;
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for(String str : words){
            sb.append(str.charAt(0));
        }

        return sb.toString().equals(s);
        
    }
}