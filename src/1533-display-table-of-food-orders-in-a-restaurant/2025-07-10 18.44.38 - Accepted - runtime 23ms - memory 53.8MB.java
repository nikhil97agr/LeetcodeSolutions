import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> set = new TreeSet<>();

        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();


        for(List<String> order : orders){
            int table = Integer.parseInt(order.get(1));
            String dish = order.get(2);

            set.add(dish);
            map.computeIfAbsent(table, t-> new HashMap<>()).merge(dish, 1, Integer::sum);
        }
        Map<String, Integer> m2 = new HashMap<>();
        int i = 1;
        for(String s : set){
            m2.put(s, i);
            i++;
        }
        List<String> column =new ArrayList<>();

        column.add("Table");
        column.addAll(set);

        List<List<String>> result = new ArrayList<>();

        result.add(column);

        for(Integer table : map.keySet()){
            List<String> l = new ArrayList<>();

            l.add(""+table);
            for( i=0;i<set.size();i++){
                l.add("0");
            }
            for(Map.Entry<String, Integer> entry : map.get(table).entrySet()){
                int ind = m2.get(entry.getKey());

                    l.set(ind, String.valueOf(entry.getValue()));

            }

            result.add(l);
        }
        return result;
    }
}