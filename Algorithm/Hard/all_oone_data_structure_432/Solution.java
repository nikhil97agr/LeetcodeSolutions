package all_oone_data_structure_432;

import java.util.*;
class AllOne {
    TreeMap<Integer, Set<String>> map;
    Map<String, Integer> map2;
    public AllOne() {
        map = new TreeMap<>();
        map2 = new HashMap<>();
    }
    
    public void inc(String key) {
        if(map2.containsKey(key)){
            int cnt = map2.get(key);
            map.get(cnt).remove(key);
            if(map.get(cnt).isEmpty()) map.remove(cnt);
            map.computeIfAbsent(cnt+1, c -> new HashSet<>()).add(key);
            map2.put(key, cnt+1);
        }else{
            map.computeIfAbsent(1, c-> new HashSet<>()).add(key);
            map2.put(key, 1);
        }
    }
    
    public void dec(String key) {
        int cnt = map2.get(key);
        if(cnt ==1){
            map2.remove(key);
            map.get(cnt).remove(key);
            if(map.get(cnt).isEmpty()) map.remove(cnt);
        }else{
            map2.put(key, cnt-1);
            map.get(cnt).remove(key);
            if(map.get(cnt).isEmpty()) map.remove(cnt);
            map.computeIfAbsent(cnt-1, c -> new HashSet<>()).add(key);
        }
    }
    
    public String getMaxKey() {
        if(map.isEmpty()) return "";
        return map.lastEntry().getValue().stream().findFirst().get();
    }
    
    public String getMinKey() {
        if(map.isEmpty()) return "";
        return map.firstEntry().getValue().stream().findFirst().get();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */