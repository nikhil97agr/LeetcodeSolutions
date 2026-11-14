package find_the_distinct_difference_array_2777;

import java.util.*;
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> pref= new HashMap<>();
        Map<Integer, Integer> suf = new HashMap<>();
        int ans[] = new int[nums.length];
        int n = nums.length;

        for(int x : nums) suf.merge(x, 1, Integer::sum);

        for(int i=0;i<n;i++){
            pref.merge(nums[i], 1, Integer::sum);
            suf.merge(nums[i], -1, Integer::sum);

            if(suf.get(nums[i]) ==0) suf.remove(nums[i]);

            ans[i] = pref.size() - suf.size();
        }

        return ans;
    }
}