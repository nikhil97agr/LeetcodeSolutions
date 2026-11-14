package minimum_number_of_operations_to_make_word_k_periodic_3384;

import java.util.*;
class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : word.toCharArray()){
            sb.append(c);
            if(sb.length() == k){
                String s = sb.toString();
                map.put(s, map.getOrDefault(s, 0)+1);
                sb = new StringBuilder();
            }
            
            
        }
        int total = word.length()/k;
        int ans = Integer.MAX_VALUE;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            ans = Math.min(ans, total - entry.getValue());
        }
        return ans;
    }
}