package find_the_longest_equal_subarray_2832;

import java.util.*;
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        TreeMap<Integer, Integer> map =new TreeMap<>(Collections.reverseOrder());
        int ans = 0;
        int n = nums.size();

        int cnt[] = new int[n+1];
        int start = 0;
        int end = 0;
        while(end < n){
            int val = nums.get(end);
           int curr = cnt[val];
           if(curr !=0){
            map.merge(curr, -1, Integer::sum);
            if(map.get(curr) ==0) map.remove(curr);
            
           }
           map.merge(curr+1, 1, Integer::sum);
            cnt[val]++; 

           while(possible(map,k, end -start + 1) > k){

            val = nums.get(start);
             curr = cnt[val];
            map.merge(curr, -1, Integer::sum);
            map.merge(curr-1, 1, Integer::sum);
            if(map.get(curr) ==0){
                map.remove(curr);
            }
            cnt[val]--;
            start++;
           }

           int c = possible(map, k, end - start + 1);

           ans = Math.max(ans, end - start + 1 - c);
           end++;

        }

        return ans;
    }

    private int possible(TreeMap<Integer, Integer> map,int k, int len){
        int cnt = map.firstKey();

        return len - cnt;
    }
}