package maximum_score_after_binary_swaps_4130;

import java.util.*;
class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            que.offer(nums[i]);
            if(s.charAt(i) == '1'){
                ans += que.poll();
            }
        }

        return ans;
    }
}