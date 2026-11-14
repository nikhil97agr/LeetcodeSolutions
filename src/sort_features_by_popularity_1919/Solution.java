package sort_features_by_popularity_1919;

import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        int n = features.length;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> count= new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(features[i], i);
            count.put(features[i], 0);
        }

        for(String s : responses){
            for(String str : Arrays.stream(s.split(" ")).collect(Collectors.toSet())){
                if(map.containsKey(str)){
                    count.merge(str, 1, Integer::sum);
                }
            }
        }

        return count.entrySet().stream().sorted((a,b) ->{
            if(Objects.equals(a.getValue(), b.getValue())){
                int i1 = map.get(a.getKey());
                int i2 = map.get(b.getKey());

                return i1 - i2;
            }

            return b.getValue() - a.getValue();
        }).map(Map.Entry::getKey).toArray(String[] :: new);
        
    }
}