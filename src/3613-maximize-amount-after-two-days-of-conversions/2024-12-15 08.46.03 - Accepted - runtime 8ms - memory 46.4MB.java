import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> p1, double[] r1, List<List<String>> p2, double[] r2) {
            Map<String, Map<String, Double>> map = new HashMap<>();

            createMap(map, p1, r1);
            Map<String, Double> m1 = new HashMap<>();

            dfs(map, initialCurrency, "", 1d, m1);

            Map<String, Double> m2 = new HashMap<>();

            map.clear();
            createMap(map, p2, r2);

            for(Map.Entry<String, Double> entry : m1.entrySet()){
                dfs(map, entry.getKey(), "", entry.getValue(), m2);
            }

            return m2.get(initialCurrency);
    }

    private void createMap(Map<String, Map<String, Double>> map , List<List<String>> pair, double rate[]){
        for(int i=0;i<rate.length;i++){
            String s1 = pair.get(i).get(0);
            String s2 = pair.get(i).get(1);
            double r = rate[i];

            map.computeIfAbsent(s1, s -> new HashMap<>()).put(s2, r);
            map.computeIfAbsent(s2, s-> new HashMap<>()).put(s1, 1/r);
        }
    }


    private void dfs(Map<String, Map<String, Double>> map, String curr, String par, double value, Map<String, Double> m ){
        m.put(curr, Math.max(m.getOrDefault(curr, 0d), value));
        for(Map.Entry<String, Double> entry : map.getOrDefault(curr, new HashMap<>()).entrySet()){
            if(entry.getKey().equals(par)) continue;

            dfs(map, entry.getKey(), curr, value*entry.getValue(), m);
        }
    }
}