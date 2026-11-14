package number_of_orders_in_the_backlog_1928;

import java.util.*;
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell =new PriorityQueue<>((a,b)->{
            return a[0] - b[0];
        });
        PriorityQueue<int[]> buy = new PriorityQueue<>((a,b) ->{
            return b[0] - a[0];
        });
        for(int o[] : orders){
            int amt =o[1];
            int price = o[0];
            int type = o[2];

            if(type ==0){
                while(!sell.isEmpty() && sell.peek()[0] <= price && amt > 0){
                    int next[] =sell.poll();
                    if(amt >= next[1]){
                        amt -= next[1];
                    }else{
                        
                        next[1] -= amt;
                        amt = 0;
                        sell.offer(next);
                    }
                }

                if(amt > 0){
                    buy.offer(new int[]{price, amt, type});
                }
            }else{
while(!buy.isEmpty() && buy.peek()[0] >= price && amt > 0){
                    int next[] =buy.poll();
                    if(amt >= next[1]){
                        amt -= next[1];
                    }else{
                        
                        next[1] -= amt;
                        amt = 0;
                        buy.offer(next);
                    }
                }

                if(amt > 0){
                    sell.offer(new int[]{price, amt, type});
                }
            }
        }

        int ans = 0;

        while(!buy.isEmpty()){
            ans= add(ans, buy.poll()[1]);
        }
        while(!sell.isEmpty()){
            ans = add(ans, sell.poll()[1]);
        }

        return ans;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}