package sort_characters_by_frequency_451;

import java.util.*;
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2)-> e2.getValue() - e1.getValue());

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            for(int i=0;i<entry.getValue();i++){
                res.append(entry.getKey());
            }
        }
        return res.toString();
    }
}