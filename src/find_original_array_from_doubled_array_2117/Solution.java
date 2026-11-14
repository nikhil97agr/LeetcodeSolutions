package find_original_array_from_doubled_array_2117;

import java.util.*;
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2==1) return new int[0];
        Arrays.sort(changed);
        int len = n/2;
        int ans[] =new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : changed){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int j =0;
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(changed[i])){
                if(changed[i]%2==1) return new int[]{};

                if(map.containsKey(changed[i]/2)){
                    ans[j++] = changed[i]/2;
                    map.put(changed[i], map.get(changed[i])-1);
                    map.put(changed[i]/2, map.get(changed[i]/2)-1);
                    if(map.get(changed[i])==0) map.remove(changed[i]);
                    if(map.containsKey(changed[i]/2) && map.get(changed[i]/2)==0) map.remove(changed[i]/2);
                }
            }

            if(j==len) break;
        
        }
        return map.isEmpty() ? ans : new int[]{};
    }
}