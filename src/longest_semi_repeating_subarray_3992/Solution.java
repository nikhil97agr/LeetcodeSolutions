package longest_semi_repeating_subarray_3992;

import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int cnt[] = new int[100001];
        int start = 0;
        int end = 0;
        while(end < nums.length){
            cnt[nums[end]]++;

            if(cnt[nums[end]] > 1) set.add(nums[end]);

            while(start < end && set.size() > k){
                cnt[nums[start]]--;
                if(cnt[nums[start]] == 1) set.remove(nums[start]);
                start++;
            }

            ans = Math.max(ans, end - start + 1 );
            end++;
        }

        return ans;
    }
}