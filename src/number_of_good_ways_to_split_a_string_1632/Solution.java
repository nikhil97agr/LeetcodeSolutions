package number_of_good_ways_to_split_a_string_1632;

import java.util.*;
class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap();
        Map<Character, Integer> right = new HashMap();
        for(char c : s.toCharArray()){
            right.put(c, right.getOrDefault(c,0)+1);
        }
        int total = 0;
        for(char c : s.toCharArray()){
            left.put(c, left.getOrDefault(c, 0)+1);
            right.put(c, right.get(c)-1);
            
            if(right.get(c)==0){
                right.remove(c);
            }
            if(left.size()==right.size()){
                total++;
            }
        }
        return total;
        
        
    }
}