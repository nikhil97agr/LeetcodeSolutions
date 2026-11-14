import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int ans[] = new int[Arrays.stream(queries).max().getAsInt()+1];
        int ind = 0;
        Arrays.sort(intervals, (i1,i2) -> i1[0] - i2[0]);
        TreeMap<Integer, Integer> size = new TreeMap<>();
        Map<Integer, Map<Integer, Integer>> end = new HashMap<>();
        for(int i=0;i<ans.length;i++){
            while(ind < intervals.length && intervals[ind][0] == i){
                int s = intervals[ind][0];
                int e = intervals[ind][1];
                int len = e - s + 1;

                size.merge(len, 1, Integer::sum);
                end.computeIfAbsent(e, x-> new HashMap<>()).merge(s, 1, Integer::sum);
                ind++;
            }

            if(size.isEmpty()){
                ans[i] = -1;
                continue;
            }
            ans[i] = size.firstKey();

            if(!end.containsKey(i)) continue;

            Map<Integer, Integer> map =end.get(i);
            for(int s : map.keySet()){
                int cnt = map.get(s);
                while(cnt-- > 0){
                    int len = i - s + 1;
                    size.merge(len, -1, Integer::sum);
                    if(size.get(len) ==0) size.remove(len);
                }
            }
            
            end.remove(i);
        }

        int res[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            res[i] = ans[queries[i]];
        }

        return res;
    }
}