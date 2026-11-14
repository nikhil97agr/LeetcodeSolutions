package check_if_the_sentence_is_pangram_1960;

import java.util.*;
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for(char c : sentence.toCharArray()) set.add(c);


        return set.size() == 26;
    }
}