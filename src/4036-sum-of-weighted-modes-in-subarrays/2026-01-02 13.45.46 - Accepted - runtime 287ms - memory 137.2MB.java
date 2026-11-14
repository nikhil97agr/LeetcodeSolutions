import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public long modeWeight(int[] nums, int k) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> count = new HashMap<>();
        long ans = 0;
        int start = 0;
        int end = 0;
        while(end < k-1){
            add(nums[end], map, count);
            end++;
        }

        while(end < nums.length){
            add(nums[end], map, count);
            int mode = map.firstEntry().getValue().first();
            ans += 1l * mode * count.get(mode);
            remove(nums[start], map, count);
            start++;
            end++;
        }

        return ans;
    }

    private void add(int val, TreeMap<Integer, TreeSet<Integer>> map, Map<Integer, Integer> count){
        if(!count.containsKey(val)){
            count.put(val, 1);
            map.computeIfAbsent(1, x-> new TreeSet<>()).add(val);
            return;
        }
        
        int prev = count.get(val);
        map.get(prev).remove(val);
        if(map.get(prev).isEmpty()) map.remove(prev);
        count.put(val, prev + 1);
        prev++;
        map.computeIfAbsent(prev, x-> new TreeSet<>()).add(val);
    }
    
    private void remove(int val, TreeMap<Integer, TreeSet<Integer>> map, Map<Integer, Integer> count){
        int cnt = count.get(val);
        if(cnt == 1){
            count.remove(val);
            map.get(cnt).remove(val);
            if(map.get(cnt).isEmpty()) map.remove(cnt);
            return;
        }
        
        count.put(val, cnt - 1);
        map.get(cnt).remove(val);
        if(map.get(cnt).isEmpty()) map.remove(cnt);
        
        cnt--;
        map.computeIfAbsent(cnt, x-> new TreeSet<>()).add(val);
    }

}