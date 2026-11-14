package maximum_number_of_groups_getting_fresh_donuts_1924;

import java.util.*;
class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int left[] = new int[batchSize];
        for(int g : groups){
            left[g%batchSize]++;
        }
        return solve(0, batchSize, new HashMap<>(), left, groups.length - left[0]) + left[0];
    }

    private int solve(int extra, int size, Map<String, Integer> map, int left[], int grps){
        if(grps ==0) return 0;
        String key = Arrays.toString(left)+":"+extra;
        if(map.containsKey(key)) return map.get(key);
        int ans = 0;
        for(int i=1;i<size;i++){
            if(left[i] == 0) continue;

            left[i]--;
            ans = Math.max(ans, solve((extra - i + size)%size, size, map, left, grps - 1) );
            left[i]++;
        }

        if(extra ==0) ans++;
        map.put(key, ans);
        return ans;

    }
}