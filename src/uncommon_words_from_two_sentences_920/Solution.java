package uncommon_words_from_two_sentences_920;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {


        Map<String, Integer> map = new HashMap<>();

        for(String s : s1.split(" ")){
            addToMap(s, map);
        }

        for(String s : s2.split(" ")){
            addToMap(s, map);
        }

        return map.entrySet().stream().filter(entry -> entry.getValue()<2).map(Map.Entry::getKey).toList().toArray(new String[0]);
    }

    private void addToMap(String s, Map<String, Integer> map){
        map.put(s, map.getOrDefault(s, 0)+1);
    }

}