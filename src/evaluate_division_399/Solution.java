package evaluate_division_399;

import java.util.*;
class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(src, new HashMap<>());
            graph.putIfAbsent(dest, new HashMap<>());
            graph.get(src).put(dest, value);
            graph.get(dest).put(src, 1/value);
        }

        double result[] = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(graph.get(src)==null || graph.get(src).isEmpty() || graph.get(dest)==null || graph.get(dest).isEmpty()){
                result[i] = -1d;
                continue;
            }
            result[i] = -1d;
            dfs(graph, result, i, src, dest, new HashSet<>(), 1d);
        }
        return result;
    }

    private boolean dfs(Map<String, Map<String, Double>> graph, double result[], int ind, String src, String dest, Set<String> visited, double value){
        if(visited.contains(src)){
            return false;

        }

        visited.add(src);
        if(src.equals(dest)){
            result[ind] = value;
            return true;
        }

        for(Map.Entry<String, Double> entry : graph.get(src).entrySet()){
           if(dfs(graph, result, ind, entry.getKey(), dest, visited, value*entry.getValue())){
               return true;
           }
        }
        return false;
    }
}