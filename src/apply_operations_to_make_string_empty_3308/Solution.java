package apply_operations_to_make_string_empty_3308;

import java.util.*;
class Solution {
    public String lastNonEmptyString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            lastIndex.put(c, i);
        }
        int cnt = 0;
        for(int val : map.values()) cnt = Math.max(cnt, val);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()!=cnt){
                lastIndex.remove(entry.getKey());
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(lastIndex.entrySet());
        Collections.sort(list, (a,b)-> a.getValue() - b.getValue());
        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            res.append(entry.getKey());
        }
        return res.toString();
    }
}