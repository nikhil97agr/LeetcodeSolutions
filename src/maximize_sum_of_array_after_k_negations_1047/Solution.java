package maximize_sum_of_array_after_k_negations_1047;

import java.util.*;
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int x : nums) que.offer(x);
        while(k-- >0){
            int min = que.poll();
            min = -1*min;
            que.offer(min);
        }

        int sum =0;
        while(!que.isEmpty()){
            sum += que.poll();
        }

        return sum;

    }
}