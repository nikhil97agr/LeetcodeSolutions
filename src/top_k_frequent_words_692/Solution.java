package top_k_frequent_words_692;

import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        List<Map.Entry<String, Integer>> listEntry = new ArrayList<>(map.entrySet());

        Collections.sort(listEntry , (a,b)->{
            if(a.getValue() == b.getValue()){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });

        List<String> result= new ArrayList<>();
        for(Map.Entry<String, Integer> entry : listEntry){
            result.add(entry.getKey());
            if(result.size()==k) return result;
        }

        return result;
    }
}