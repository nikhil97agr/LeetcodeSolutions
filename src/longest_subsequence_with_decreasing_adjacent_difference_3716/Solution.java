package longest_subsequence_with_decreasing_adjacent_difference_3716;

import java.util.*;
class Solution {
    public int longestSubsequence(int[] nums) {
        int ans[][] = new int[302][302];

        for(int i=nums.length - 1;i>=0;i--){
            int val = nums[i];

            for(int nextValue = 1;nextValue <= 300;nextValue++){
                int diff = Math.abs(val - nextValue);
                ans[val][diff] = Math.max(ans[val][diff], ans[nextValue][diff] + 1);
            }

            for(int next = 1;next <= 300;next++){
                ans[val][next] = Math.max(ans[val][next], ans[val][next-1]);
            }
        }

        return Arrays.stream(ans).map(d-> Arrays.stream(d).max().getAsInt()).max((a,b) ->a-b).get();
    }


}