package repeated_dna_sequences_187;

import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       
        HashMap<String, Integer> map = new HashMap();

        if (s.length() <= 10) {
            return new ArrayList();
        }
        String x = s.substring(0, 10);
        map.put(x, 1);
        for (int i = 1; i < s.length()-9; i++) {
            x = s.substring(i, i + 10);
            map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        }

        List<String> result = new ArrayList();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}