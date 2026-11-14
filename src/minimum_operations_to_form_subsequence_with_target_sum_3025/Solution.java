package minimum_operations_to_form_subsequence_with_target_sum_3025;

import java.util.*;
class Solution {
    public int minOperations(List<Integer> nums, int target) {
        long total = 0;
        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        for(var x : nums){
            total += x;
            que.offer(x);
        }

        int ans = 0;
        if(total < target) return -1;
        while(target > 0){
            int peek = que.poll();
            if(total - peek >= target){
                total -= peek;
                continue;
            }
            if(peek <= target){
                total -= peek;
                target -= peek;
                continue;
            }

            que.offer(peek/2);
            que.offer(peek/2);
            ans++;
        }

        return ans;
    }
}