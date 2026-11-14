package unique_morse_code_words_822;

import java.util.*;
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String morse[] = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(morse[c-'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}