package maximum_number_of_potholes_that_can_be_fixed_3425;

import java.util.*;
class Solution {
    public int maxPotholes(String road, int budget) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        int count = 0;
        for(char c: road.toCharArray()){
            if(c=='.'){
                if(count!=0){
                    que.offer(count);
                    count = 0;
                }
            }else{
                count++;
            }
        }
        if(count !=0 ){
            que.offer(count);
        }

        int total =0;
        while(!que.isEmpty() && budget > 0){
            int next = que.poll();
            if(next >= budget){
                total += budget - 1;
                break;
            }else{
                total += next;
                budget -= (next + 1);
            }
        }

        return total;
    }
}