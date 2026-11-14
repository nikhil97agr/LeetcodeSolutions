package custom_sort_string_807;

import java.util.*;
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : order.toCharArray()){
            set.add(c);
            for(char ch : s.toCharArray()){
                if(c== ch){
                    res.append(ch);
                }
            }
        }

        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                res.append(c);
            }
        }
        return res.toString();

    }
}