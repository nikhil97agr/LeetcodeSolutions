package check_for_contradictions_in_equations_2065;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    Map<String, Map<String, Double>> graph;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {

        graph = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if(graph.getOrDefault(a, new HashMap<>()).containsKey(b) && graph.get(a).get(b) != val){
                return true;
            }
            put(a, b, val);
            put(b, a, 1 / val);
        }

        for (String key : graph.keySet()) {
            var dist = new HashMap<String, Double>();
            var vis = new HashSet<String>();
            if(!dfs(key, dist, vis, 1)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String key, Map<String, Double> dist, Set<String> vis, double val) {

        if (vis.contains(key)) {
            return equal(dist.get(key), val);
        }

        vis.add(key);
        dist.put(key, val);

        for (var entry : graph.get(key).entrySet()) {
            String child = entry.getKey();
            double d = entry.getValue();

            if(!dfs(child, dist, vis, val * d)){
                return false;
            }
        }
        
        return true;
    }

    private void put(String a, String b, double val) {

        graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, val);
    }

private boolean equal(double a, double b) {
    return Math.abs(a - b) <= (double)1e-5 * Math.max(1d, Math.max(a,b));
}
}