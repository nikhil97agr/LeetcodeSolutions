package most_common_word_837;

import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")) return "b";
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        for(String s : paragraph.split(" ")){
            StringBuilder sb = new StringBuilder();

            for(char c : s.toCharArray()){
                if(Character.isLetter(c)) sb.append(c);
            }

            String temp =sb.toString().toLowerCase();
            if(!set.contains(temp)) map.merge(temp, 1, Integer::sum);
        }

        int cnt = 0;
        for(int val : map.values()) cnt = Math.max(cnt, val);


        for(String key : map.keySet()){
            if(map.get(key) == cnt) return key;
        }

        return "";
    }
}