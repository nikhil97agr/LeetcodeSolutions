package make_sum_divisible_by_p_1694;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        int ans = nums.length;
        int n =nums.length;
        
        for(int x : nums) sum = (sum + x)%p;

        if(sum==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        for(int i=0;i<n;i++){
            curr = (curr + nums[i])%p;

            int req = (curr - sum + p )%p;

            if(map.containsKey(req)){
                ans = Math.min(ans, i - map.get(req));
            }

            map.put(curr,i);
        }


        return ans == n ? -1 : ans;
    }
}