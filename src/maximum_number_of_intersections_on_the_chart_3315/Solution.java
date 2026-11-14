package maximum_number_of_intersections_on_the_chart_3315;

import java.util.*;
class Solution {
    public int maxIntersectionCount(int[] y) {
        Map<Integer, Integer> lineStart = new HashMap<>();
        Map<Integer, Set<Integer>> pointStart = new HashMap<>();
        Map<Integer, Integer> lineEnd = new HashMap<>();
        Map<Integer, Set<Integer>> pointEnd =new HashMap<>();
        int cnt = 0;
        int ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<y.length-1;i++){
            int y1 = y[i];
            int y2 = y[i+1];
            int min = Math.min(y1, y2);
            int max = Math.max(y1, y2);
            set.add(y1);
            set.add(y2);
            lineStart.merge(min, 1, Integer::sum);
            lineEnd.merge(max, 1, Integer::sum);
            pointStart.computeIfAbsent(min, x -> new HashSet<>()).add(y[i] == min ? i : i + 1);
            pointStart.computeIfAbsent(max, x-> new HashSet<>()).add(y[i] == max ? i : i+1);
        }

        while(!set.isEmpty()){
            int key = set.removeFirst();
            ans = Math.max(ans, cnt);

            cnt -= lineEnd.getOrDefault(key, 0);
            cnt += pointStart.getOrDefault(key, new HashSet<>()).size();
            ans = Math.max(ans, cnt);
            cnt -= pointStart.getOrDefault(key, new HashSet<>()).size();
            cnt += lineStart.getOrDefault(key, 0);
            
        }

        return Math.max(ans,cnt);
    }
}