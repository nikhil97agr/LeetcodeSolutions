package recover_the_original_array_2241;

import java.util.*;
class Solution {
    public int[] recoverArray(int[] nums) {
       Arrays.sort(nums);
       int n = nums.length/2;

       for(int gap = 1;gap <= n;gap++){
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
        }
        int diff = nums[gap] - nums[0];
        if(diff%2!=0 || diff == 0) continue;
        int i=0;
        int ind = 0;
        int ans[] = new int[n];
        while(ind < n && i < 2*n){
            int v1 = nums[i];
            int v2 = v1 + diff;
            if(!map.containsKey(v1) || !map.containsKey(v2)){
                i++;
                continue;
            }
            i++;
            remove(v1, map);
            remove(v2, map);
            ans[ind++] = v1 + diff/2;

        }

        if(map.isEmpty()){
            return ans;
        }
       }  

       return new int[0];
    }

    private void remove(int val, Map<Integer, Integer> map){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }
}