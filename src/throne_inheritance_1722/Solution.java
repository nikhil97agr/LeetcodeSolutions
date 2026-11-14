package throne_inheritance_1722;

import java.util.*;
class ThroneInheritance {
    Map<String, List<String>> map;
    Set<String> died;
    String king;
    public ThroneInheritance(String kingName) {
        king = kingName;
        map = new HashMap<>();
        died = new HashSet<>();
        map.put(king, new ArrayList<>());

    }
    
    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, x -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        died.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        System.out.println(king);
        dfs(king, result);

        return result;
    }

    private void dfs(String parent, List<String> result){
        if(!died.contains(parent)){
            result.add(parent);
        }

        for(String child : map.getOrDefault(parent, new ArrayList<>())){
            dfs(child, result);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */