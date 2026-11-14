package contiguous_array_525;

import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        int cnt = 0;
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<n;i++){
            int dig = nums[i];
            if(dig ==0 ){
                cnt--;
            }else{
                cnt++;
            }

            if(map.containsKey(cnt)){
                ans = Math.max(ans, i - map.get(cnt) );
            }else{
                map.put(cnt, i);
            }
        }

        return ans;

    }
}