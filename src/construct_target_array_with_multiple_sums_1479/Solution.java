package construct_target_array_with_multiple_sums_1479;

import java.util.*;

import java.util.Collection;class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
        for(long x : target){
            que.offer(x);
            sum += x;
        }
        while(!que.isEmpty()){
            long next = que.poll();
            sum -= next;

            if(sum == 1 || next ==1) return true;
            if(next < sum || sum == 0 || next%sum == 0) return false;
            next %= sum;
            sum += next;
            que.offer(next);
        }

        return true;
    }
}