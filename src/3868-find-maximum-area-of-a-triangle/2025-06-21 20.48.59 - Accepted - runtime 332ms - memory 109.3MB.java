import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public long maxArea(int[][] coords) {
        TreeMap<Integer, TreeSet<Integer>> xMap = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> yMap = new TreeMap<>();

        for(int c[] : coords){
            int x = c[0];
            int y = c[1];

            add(xMap, x, y);
            add(yMap, y, x);

        }

        long ans = -1;

        for(Map.Entry<Integer, TreeSet<Integer>> entry : xMap.entrySet()){
            int c = entry.getKey();
            TreeSet<Integer> set = entry.getValue();
            if(set.size() == 1 || xMap.size() == 1) continue;
            int y1 = set.first();
            int y2 = set.last();
            long v = Math.abs(y1 - y2);
            int x1 = xMap.firstKey();
            int x2 = xMap.lastKey();


            ans = Math.max(ans, v * Math.max(Math.abs(c - x1), Math.abs(c - x2)));


        }

        for(Map.Entry<Integer, TreeSet<Integer>> entry : yMap.entrySet()){
            int c = entry.getKey();
            TreeSet<Integer> set = entry.getValue();
            if(set.size() == 1 || yMap.size() == 1) continue;
            int x1 = set.first();
            int x2 = set.last();
            long v = Math.abs(x1 - x2);
            int y1 = yMap.firstKey();
            int y2 = yMap.lastKey();


            ans = Math.max(ans, v * Math.max(Math.abs(c - y1), Math.abs(c - y2)));


        }
        
        return ans;
        
    }

    private void add(TreeMap<Integer, TreeSet<Integer>> map, int x, int y){
        map.computeIfAbsent(x, a -> new TreeSet<>()).add(y);
    }
}