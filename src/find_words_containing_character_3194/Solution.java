package find_words_containing_character_3194;

import java.util.*;
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<words.length;i++){
            if(words[i].indexOf(x) !=-1) list.add(i);
        }
        return list;
    }
}