package smallest_common_region_1190;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, List<String>> map =new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(List<String> list : regions){
            String start = list.get(0);
            for(int i=1;i<list.size();i++){
                String s = list.get(i);
                map.computeIfAbsent(start, x-> new ArrayList<>()).add(s);
                indegree.merge(s, 1, Integer::sum);
            }
        }

        String s = "";
        for(String key : map.keySet()){
            if(indegree.getOrDefault(key, 0) == 0) {
                s =key;
                break;
            }
        }
        return lca(s, "", region1, region2, map);
    }

    private String lca(String curr, String par, String r1, String r2, Map<String, List<String>> map){
        String first = null;
        String second = null;
        if(curr.equals(r1)) first = r1;
        if(curr.equals(r2)) first = r2;
        for(String child : map.getOrDefault(curr, new ArrayList<>())){
            if(child.equals(par)) continue;
            
            String lca = lca(child, curr, r1, r2, map);
            if(lca == null) continue;
            if(first == null) first = lca;
            else if(second == null){
                second = lca;
            }
        }
        
        if(second == null) return first;
        
        return curr;
        
    }
}