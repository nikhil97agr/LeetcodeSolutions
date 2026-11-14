package minimum_number_of_seconds_to_make_mountain_height_zero_3496;

import java.util.*;
import java.util.PriorityQueue;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Node> que = new PriorityQueue<>( (a,b)->{
            long ans1  = a.ans + 1l*(a.cnt+1)*a.time;
            long ans2  = b.ans + 1l*(b.cnt+1)*b.time;
            if(ans1 >= ans2) return 1;
            return -1;
        });
        for(int x : workerTimes){
            que.offer(new Node(x));
        }
        while(mountainHeight > 0){
            Node node = que.poll();

            node.ans = node.ans + 1l*(node.cnt+1)*node.time;
            node.cnt++;
            que.offer(node);
            mountainHeight--;
        }
        long ans = Integer.MIN_VALUE;

        while(!que.isEmpty()){
            ans = Math.max(ans, que.poll().ans);

        }
        return ans;
    }

    class Node{
        int time;
        int cnt;
        long ans;

        public Node(int time){
            this.time = time;
            this.cnt = 0;
            this.ans = 0;
        }
    }
}