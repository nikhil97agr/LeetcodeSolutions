package maximum_transactions_without_negative_balance_4081;

import java.util.*;
class Solution {
    public int maxTransactions(int[] transactions) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        long sum =0;
        int n = transactions.length;
        int skip = 0;
        for(int x : transactions){
            sum += x;
            if( x< 0){
                que.offer(x);
            }

            while(!que.isEmpty() && sum < 0){
                sum -= que.poll();
                skip++;
            }
        }


        return n - skip;
    }
}