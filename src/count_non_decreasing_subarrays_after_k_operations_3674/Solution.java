package count_non_decreasing_subarrays_after_k_operations_3674;

import java.util.*;
import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        var ans = 0l;
        var n = nums.length;
        var j = n-1;
        var stack = new ArrayDeque<int[]>();
        var op = 0l;

        for(var i=n-1;i>=0;i--){
            int cnt = 1;
            while(!stack.isEmpty() && stack.peekLast()[0] <= nums[i]){
                var peek = stack.removeLast();
                var diff = nums[i] - peek[0];
                op += 1l * diff * peek[1];
                cnt += peek[1];

            }
            stack.offerLast(new int[]{nums[i], cnt});
            while(op > k && j >=i){

                var diff = stack.peekFirst()[0] - nums[j];
                op -= diff;
                stack.peekFirst()[1]--;
                if(stack.peekFirst()[1] ==0) stack.removeFirst();
                j--;

            }

            ans += ( j - i + 1);
        }


        return ans;
    }
}