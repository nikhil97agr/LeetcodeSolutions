package first_unique_even_element_4252;

import java.util.*;
class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        for(int x : nums){
            if(x%2==0){
                que.offer(x);
                map.merge(x, 1, Integer::sum);
            }
        }

        while(!que.isEmpty()){
            int next = que.poll();
            if(map.get(next) ==1) return next;
        }

        return -1;
    }
}