package delayed_count_of_equal_elements_4228;

import java.util.*;
class Solution {
    public int[] delayedCount(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=k+1;j<n;j++){
            map.merge(nums[j], 1, Integer::sum);
        }
        int j = k + 1;
        for(int i=0;i<n;i++){
            ans[i] = map.getOrDefault(nums[i], 0);
            if(j < n){
                map.merge(nums[j], -1, Integer::sum);
                j++;
            }
        }
        return ans;
    }
}