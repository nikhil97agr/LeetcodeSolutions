package most_frequent_ids_3363;

import java.util.*;
class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        TreeMap<Long, Integer> map = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Long> m2 = new HashMap<>();
        int n = nums.length;
        long ans[] = new long[n];
        
        for(int i=0;i<n;i++){
            if(m2.containsKey(nums[i])){
                long cnt = m2.get(nums[i]);
                map.put(cnt, map.get(cnt)-1);
                if(map.get(cnt)==0) map.remove(cnt);
                cnt += freq[i];
                map.put(cnt, map.getOrDefault(cnt, 0)+1);
                m2.put(nums[i], cnt);
            }else{
                m2.put(nums[i], 1L*freq[i]);
                map.put(1L*freq[i], map.getOrDefault(1L*freq[i], 0)+1);
            }
            ans[i] = map.firstKey();
        }
        return ans;
        
    }
}