package find_the_most_common_response_3707;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> map = new HashMap<>();
        for(List<String> list : responses){
            Set<String> set = new HashSet<>(list);
            for(String s : set){
                map.put(s, map.getOrDefault(s,0)+1);
            }

        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b)->{
            if(Objects.equals(a.getValue(), b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }

            return b.getValue() - a.getValue();
        });

        return list.get(0).getKey();
    }
}